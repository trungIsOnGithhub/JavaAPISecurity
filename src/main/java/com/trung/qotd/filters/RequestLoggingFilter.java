package com.trung.qotd.filters;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Cookie;

@WebFilter("/RequestLoggingFilter")
public class RequestLoggingFilter implements Filter {

	private ServletContext context;
	
    @Override
	public void init(FilterConfig fConfig) throws ServletException {
		this.context = fConfig.getServletContext();
		this.context.log("RequestLoggingFilter initialized");
	}

    @Override
	public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
                                                    throws IOException, ServletException {
		Enumeration<String> params = request.getParameterNames();

		while (params.hasMoreElements()){
			String name = params.nextElement();
			String value = request.getParameter(name);

			this.context.log(request.getRemoteAddr() + "_Params_{"+name+"="+value+"}");
		}
		
		Cookie[] cookies = request.getCookies();

		if (cookies != null){
			for (Cookie cookie : cookies){
				this.context.log(request.getRemoteAddr() + "_Cookie_{"+cookie.getName()+","+cookie.getValue()+"}");
			}
		}

		// pass the request to next filter in chain
		chain.doFilter(request, response);
	}

    @Override
	public void destroy() {
		// close opened resources here
	}

}