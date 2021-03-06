package com.epam.financial_analytics.filter;

import javax.servlet.*;
import java.io.IOException;
import java.util.TimeZone;

public class TimeZoneFilter implements Filter {
    private String timeZone;

    @Override
    public void init(FilterConfig filterConfig) {
        timeZone = filterConfig.getInitParameter("timeZone");

        if (timeZone == null){
            timeZone = "UTC";
        }
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
       String currentTimeZone = TimeZone.getDefault().getID();

        if (currentTimeZone != timeZone) {
            TimeZone.setDefault(TimeZone.getTimeZone(timeZone));
        }

        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {
    }
}
