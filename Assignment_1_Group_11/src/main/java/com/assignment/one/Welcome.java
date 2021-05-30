package com.assignment.one;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class Welcome
 */
@WebServlet("/Welcome")
public class Welcome extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Welcome() {}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		HttpSession session = request.getSession();
		boolean isLoggedIn = (boolean) session.getAttribute("isLoggedIn");
		String username = (String) session.getAttribute("userName");
		
		if(!isLoggedIn) {
			RequestDispatcher rd = request.getRequestDispatcher("/index.html");
			rd.include(request, response);
			out.print("<p class='error'>Please Login First!</p>");
		}else {
			out.print("<p style='text-align:center;margin-top: 20px;'>Welcome " + username+"</p>");
			RequestDispatcher rd = request.getRequestDispatcher("/welcome.html");
			rd.include(request, response);
		}
		
	}

}
