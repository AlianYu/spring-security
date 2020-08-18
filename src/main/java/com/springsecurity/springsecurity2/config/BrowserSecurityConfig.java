
package com.springsecurity.springsecurity2.config;


import com.springsecurity.springsecurity2.config.security.MySuccessHandler;
import com.springsecurity.springsecurity2.config.security.MyfailureHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.annotation.Resource;


/**
 * @ClassName BrowserSecurityConfig
 * @Description
 * @Author Administrator
 * @Date 2020/8/13 15:21
 * @Version 1.0
 */

@Configuration
public class BrowserSecurityConfig extends  WebSecurityConfigurerAdapter{

    @Resource
    private MySuccessHandler mySuccessHandler;
    @Resource
    private MyfailureHandler myfailureHandler;

/**
     * 登录验证及资源访问的权限规则
     * @param http
     * @throws Exception
     */

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        System.out.println("3:configure(HttpSecurity http) ");

        /*http.csrf().disable() //禁用跨站csrf攻击防御
                .formLogin()
                .loginPage("/mylogin.html")//用户未登录时，访问任何资源都转跳到该路径，即登录页面
                .loginProcessingUrl("/validate/mylogin")//登录表单form中action的地址，也就是处理认证请求的路径
                .usernameParameter("username")///登录表单form中用户名输入框input的name名，不修改的话默认是username
                .passwordParameter("password")//form中密码输入框input的name名，不修改的话默认是password
                .defaultSuccessUrl("/index")//登录认证成功后默认转跳的路径

                .and()

                .authorizeRequests()
                .antMatchers("/login.html","/login").permitAll()//不需要通过登录验证就可以被访问的资源路径
                .antMatchers("/service1","/service2") //需要对外暴露的资源路径
                .hasAnyAuthority("ROLE_user","ROLE_admin")  //user角色和admin角色都可以访问
                .antMatchers("/log","/user")
                .hasAnyRole("admin")  //admin角色可以访问
                .anyRequest().authenticated();*/

        //http认证

/*http.httpBasic().and().authorizeRequests().anyRequest().permitAll().and();*/

        http.csrf().disable() //禁用跨站csrf攻击防御，后面的章节会专门讲解
                .formLogin()

                .loginPage("/mylogin.html")//用户未登录时，访问任何资源都转跳到该路径，即登录页面
                .successHandler(mySuccessHandler)
                .failureHandler(myfailureHandler)

                .loginProcessingUrl("/validate/mylogin")//登录表单form中action的地址，也就是处理认证请求的路径
                //.defaultSuccessUrl("/index")//登录认证成功后默认转跳的路径
                .and()
                .authorizeRequests()
                .antMatchers("/mylogin.html","/hello/*").permitAll()///不需要通过登录验证就可以被访问的资源路径
                .antMatchers("/biz1").hasRole("user") //前面是资源的访问路径、后面是资源的名称或者叫资源ID
                .antMatchers("/biz2").hasRole("user")
                .antMatchers("/syslog").hasRole("admin")
                .antMatchers("/sysuser").hasRole("admin")
                .anyRequest().authenticated();
    }


/**
     * 用户及角色信息配置
     * @param auth
     * @throws Exception
     */

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        System.out.println("2:configure(AuthenticationManagerBuilder auth) ");
        auth.inMemoryAuthentication()
                .withUser("user").password(passwordEncoder().encode("123456"))
                .roles("user").and()
                .withUser("admin").password(passwordEncoder().encode("123456"))
                //.authorities("sys:log","sys:user")
                .roles("admin")
                .and()
                .passwordEncoder(passwordEncoder());//配置BCrypt加密
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        System.out.println("1:PasswordEncoder passwordEncoder() ");
        return new BCryptPasswordEncoder();
    }


/**
     * 开放静态资源
     * @param web
     */

    @Override
    public void configure(WebSecurity web) {
        System.out.println("4:configure(WebSecurity web) ");
        //将项目中静态资源路径开放出来
        web.ignoring().antMatchers( "/css/**", "/fonts/**", "/img/**", "/js/**");
    }
}

