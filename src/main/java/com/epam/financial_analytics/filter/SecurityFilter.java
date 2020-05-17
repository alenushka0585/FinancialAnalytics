package com.epam.financial_analytics.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpSession;
import java.io.IOException;

import static com.epam.financial_analytics.service.ServiceConstant.*;

public class SecurityFilter implements Filter {
    private FilterConfig filterConfig;
    private String requestURI;

    @Override
    public void init(FilterConfig fConfig) throws ServletException {
        filterConfig = fConfig;
        requestURI = fConfig.getInitParameter("requestURI");

        if (requestURI == null){
            requestURI = "/";
        }
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpSession session = req.getSession(false);

        String path = req.getRequestURI();

        if (requestURI.equals(path) || path.equals("/controller/login")) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else if (session.getAttribute(USER) == null) {
            ServletContext servletContext = filterConfig.getServletContext();
            RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher(INDEX_URL + JSP);
            requestDispatcher.forward(servletRequest, servletResponse);
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {
    }
}
