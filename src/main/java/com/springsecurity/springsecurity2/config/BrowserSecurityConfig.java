/*
package com.springsecurity.springsecurity2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

*/
/**
 * @ClassName BrowserSecurityConfig
 * @Description
 * @Author Administrator
 * @Date 2020/8/13 15:21
 * @Version 1.0
 *//*

//@Configuration
public class BrowserSecurityConfig extends  WebSecurityConfigurerAdapter{
    */
/**
     * 登录验证及资源访问的权限规则
     * @param http
     * @throws Exception
     *//*

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //http认证
        */
/*http.httpBasic().and().authorizeRequests().anyRequest().permitAll().and();*//*


        //表单认证
        // 表单登录，而不是httpBasic
        http.csrf().disable() //禁用跨站csrf攻击防御，后面的章节会专门讲解
                .formLogin()
                .loginPage("/mylogin.html")//用户未登录时，访问任何资源都转跳到该路径，即登录页面
                .loginProcessingUrl("/validate/mylogin")//登录表单form中action的地址，也就是处理认证请求的路径
                .defaultSuccessUrl("/index")//登录认证成功后默认转跳的路径
                .and()
                .authorizeRequests()
                .antMatchers("/mylogin.html","/hello/*").permitAll()///不需要通过登录验证就可以被访问的资源路径
                .antMatchers("/biz1").hasAnyAuthority("biz1")  //前面是资源的访问路径、后面是资源的名称或者叫资源ID
                .antMatchers("/biz2").hasAnyAuthority("biz2")
                .antMatchers("/syslog").hasAnyAuthority("syslog")
                .antMatchers("/sysuser").hasAnyAuthority("sysuser")
                .anyRequest().authenticated();
    }

    */
/**
     * 用户及角色信息配置
     * @param auth
     * @throws Exception
     *//*

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
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
        return new BCryptPasswordEncoder();
    }

    */
/**
     * 开放静态资源
     * @param web
     *//*

    @Override
    public void configure(WebSecurity web) {
        //将项目中静态资源路径开放出来
        web.ignoring().antMatchers( "/css/**", "/fonts/**", "/img/**", "/js/**");
    }
}
*/
