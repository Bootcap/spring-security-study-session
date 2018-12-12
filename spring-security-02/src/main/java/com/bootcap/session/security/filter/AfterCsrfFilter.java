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
 * 2018-12-12 10:46
 */
public class AfterCsrfFilter extends GenericFilterBean {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("在 CsrfFilter 后添加 AfterCsrfFilter");
        filterChain.doFilter(servletRequest,servletResponse);
    }
}
