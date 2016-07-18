package com.softpath.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//ahora hay que mapearlo en el web.xml que esta en WEB-INF
//@WebServlet(description = "Este servlet solo ejecuta hola mundo", urlPatterns = "/HelloWorldFromServlet")
public class HelloWorldFromServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		System.out.println("Hola Mundo");//salida a consola
		
		PrintWriter writer = response.getWriter();
		writer.println("<html>");
		writer.println("<body>");
		writer.println("<h1>Hello World from servlet</h1>");
		writer.println("<h3>Hello Writer from servlet</h3>");
		writer.println("</body>");
		writer.println("</html>");*/
		/**
		 * se le puede pasar parametros a la URL y con la variable
		 * request y el metodo getParameter se obtiene lo que hay en el
		 * nombre de la variable
		 * 
		 * */
		System.out.println("Entrando al metodo doGet");
		PrintWriter writer = response.getWriter();
		String nombre = request.getParameter("username");
		String lastName = request.getParameter("fullName");
		System.out.println(nombre);
		System.out.println(lastName);
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.setContentType("text/html");
		System.out.println("Entrando al metodo doPost");
		PrintWriter writer = response.getWriter();
		String nombre = request.getParameter("username");
		String lastName = request.getParameter("fullName");
		
		String prof = request.getParameter("prof");
		
		String arrayParameters[] = request.getParameterValues("location");
		
		System.out.println(nombre);
		System.out.println(lastName);
		writer.println(prof);
		for(String loc: arrayParameters)
		{
			System.out.println(loc);
		}
		
	}

}
