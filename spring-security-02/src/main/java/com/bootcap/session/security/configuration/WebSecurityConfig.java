package com.bootcap.session.security.configuration;

import com.bootcap.session.security.filter.AfterCsrfFilter;
import com.bootcap.session.security.filter.BeforeFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.csrf.CsrfFilter;

/**
 * Created by jack.
 * 2018-12-10 11:03
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {


    @Autowired
    MyUserDetailsService myUserDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/","/index").permitAll() // permitAll被允许访问
                .antMatchers("/user/**").hasRole("USER")// 指定所有user页面需要USER角色才能访问
                .and()
                .formLogin().loginPage("/login").defaultSuccessUrl("/user")
                .and()
                .logout().logoutUrl("/logout").logoutSuccessUrl("/login");

        /* 自定义Filer调用 */
//        filterAdd(http);
    }

    /**
     * 自定义Filter
     * @param http
     */
    private void filterAdd(HttpSecurity http){
        // 在 UsernamePasswordAuthenticationFilter 前添加 BeforeLoginFilter
        http.addFilterBefore(new BeforeFilter(), UsernamePasswordAuthenticationFilter.class);

        // 在 CsrfFilter 后添加 AfterCsrfFilter
        http.addFilterAfter(new AfterCsrfFilter(), CsrfFilter.class);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication() // 在内存中进行身份验证
//                .passwordEncoder(new BCryptPasswordEncoder())
//                .withUser("user")
//                .password(new BCryptPasswordEncoder().encode("123456"))
//                .roles("USER");
        auth.userDetailsService(myUserDetailsService).passwordEncoder(new BCryptPasswordEncoder());
    }

}
