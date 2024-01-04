package com.trung.qotd;

import com.trung.qotd.services.AuthenService;
import com.trung.qotd.dao.QuoteDAO;
import com.trung.qotd.entity.Quote;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.ServletException;

import javax.servlet.annotation.WebServlet;

@WebServlet(value = "/welcome")
public class WelcomeServlet extends HttpServlet {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//	private AuthenService authentication = new AuthenService();
	private QuoteDAO quoteDAO = new QuoteDAO();

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
												throws ServletException, IOException {
//		System.out.println(request.getAttribute("name"));
		String requestUsername = request.getParameter("usr_name");
		
		String resourcesView = "/WEB-INF/views/welcome.jsp";

		if ( !AuthenService.validUsername(requestUsername) ) {
			resourcesView = "/WEB-INF/views/error.jsp";
			
			response.sendRedirect("welcome.jsp");

			return;
		}
		
		System.out.println(requestUsername);
		System.out.println(resourcesView);


		Cookie loginCookie = new Cookie("usr_name",user);
		//setting cookie to expiry in 1 hour
		loginCookie.setMaxAge(60*60);

		response.addCookie(loginCookie);

		List<Quote> recentQuotes = quoteDAO.getMany(10);
		
		request.setAttribute("recent_quotes", recentQuotes);

		response.sendRedirect("welcome.jsp");
	}
}