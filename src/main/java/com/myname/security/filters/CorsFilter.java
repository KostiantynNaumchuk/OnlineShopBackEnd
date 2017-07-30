package com.myname.security.filters;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class CorsFilter implements Filter {

        /* CORS filer used to enable cross origin requests
        *  filters "OPTION" requests and respond "OK" to them
        *  rest of requests bypassed to filter chain
        * */

        @Override
        public void init(FilterConfig filterConfig) throws ServletException {
        }

        @Override
        public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
            HttpServletRequest req=(HttpServletRequest) request;
            HttpServletResponse res = (HttpServletResponse) response;

           res.setHeader("Access-Control-Allow-Origin", "*");
   /*      redaudant configuration was used during debug
            TODO:
           TO REMOVE AFTER FINALIZATION

            res.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
            res.setHeader("Access-Control-Max-Age", "3600");
  */
            res.setHeader("Access-Control-Allow-Headers", "Content-Type, Access-Control-Allow-Headers, Authorization, X-Requested-With, X-CSRF-TOKEN, X-CSRF-TOKEN ");

            if("OPTIONS".equalsIgnoreCase(req.getMethod())) {
                res.setStatus(HttpServletResponse.SC_OK);
            } else {
                chain.doFilter(req, res);
            }
        }

        public void destroy() {}


}
