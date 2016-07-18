package com.softpath.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/SumaResta")
public class SumaResta extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int numero1 = 4;
		int numero2 = 2;
		PrintWriter writer = response.getWriter();
		writer.println("<html>");
		writer.println("<body>");
		writer.println("<h1>El resultado de la suma es : "+(numero1 + numero2) +" </h1>");
		writer.println("<h1>El resultado de la resta es : "+(numero1 - numero2) +"</h1>");
		writer.println("</body>");
		writer.println("</html>");
		
		System.out.println(numero1+numero2);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
