package com.trung.qotd;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.trung.qotd.dao.QuoteDAO;
import com.trung.qotd.entity.Quote;
import com.trung.qotd.utils.StringValidator;

import java.io.IOException;

import javax.servlet.ServletException;

import javax.servlet.annotation.WebServlet;

@WebServlet(value = "/newquote")
public class NewQuoteServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	QuoteDAO quoteDAO = new QuoteDAO();

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
								throws ServletException, IOException {
		request.setAttribute("invalid_input", false);
		request.setAttribute("success_saved", false);
		System.out.print("()*)(");
		request.getRequestDispatcher("/WEB-INF/views/newquote.jsp").forward(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
								throws ServletException, IOException {

		String title = request.getParameter("quote_title");
		String body = request.getParameter("quote_body");
		String contributor = request.getParameter("quote_contributor");
		
		if (StringValidator.stringHasSpecialCharacter(body)
				|| StringValidator.stringHasSpecialCharacter(contributor)
				|| StringValidator.stringHasSpecialCharacter(title) ) {
			request.setAttribute("invalid_input", true);
		} else {
			request.setAttribute("invalid_input", false);
		}
		
		Quote newQuote = new Quote(title, body, contributor);
		
		this.quoteDAO.saveOne(newQuote);
		
		request.setAttribute("success_saved", true);
		
		request.getRequestDispatcher("/WEB-INF/views/newquote.jsp").forward(request, response);
	}
}
