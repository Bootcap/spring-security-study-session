package com.bootcap.session.security.filter;

import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

/**
 * 自定义Filter
 * Created by jack.
 * 2018-12-12 10:44
 */
public class BeforeFilter extends GenericFilterBean {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("在 UsernamePasswordAuthenticationFilter 前添加 BeforeLoginFilter");
        // 继续调用 Filter 链
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
