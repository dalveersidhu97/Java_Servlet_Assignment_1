package com.assignment.one;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/Final")
public class Final extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public Final() {}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		// send back to login if its not a post request
		RequestDispatcher rd = request.getRequestDispatcher("/index.html");
		rd.include(request, response);
		out.print("<p class='error'>Please Login First!</p>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		final String subjects[] = {"Java EE", "Web Tech. III", "Mobile Development", "Database Programming", "Websites using ASP.NET"};
		int maxIndex=0, minIndex=0, total = 0;
		int maxMarks = Integer.parseInt(request.getParameter("0"));
		int minMarks = Integer.parseInt(request.getParameter("0"));
		
		HttpSession session = request.getSession();
		boolean isLoggedIn = (boolean) session.getAttribute("isLoggedIn");
		
		if(!isLoggedIn) {
			RequestDispatcher rd = request.getRequestDispatcher("/index.html");
			rd.include(request, response);
			out.print("<p class='error'>Please Login First!</p>");
		}else {
			
			// getting marks
			for(int i=0;i<5;i++) {
				int marks = Integer.parseInt(request.getParameter(Integer.toString(i)));
				
				if( marks > maxMarks) {
					maxMarks = marks;
					maxIndex = i;
				}
				if(marks < minMarks) {
					minMarks = marks;
					minIndex = i;
				}
				
				total += marks;
				
			}
			
			String fullName = request.getParameter("fullName");
			String maxSubject = subjects[maxIndex];
			String minSubject = subjects[minIndex];
			String average = (total/subjects.length) +"";
			
			session.setAttribute("fullName", request.getParameter("fullName"));
			session.setAttribute("maxMarks", maxMarks+"");
			session.setAttribute("maxSubject", subjects[maxIndex]);
			session.setAttribute("minMarks", minMarks +"");
			session.setAttribute("minSubject", subjects[minIndex] +"");
			session.setAttribute("average", (total/subjects.length) +"");
			session.setAttribute("subjects", subjects);
			response.sendRedirect("final.jsp");
		}
		
	}

}
