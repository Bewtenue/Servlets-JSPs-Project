package com.softpath.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SessionServlet
 */
//@WebServlet(urlPatterns ="/SessionServlet",
//initParams = {@WebInitParam(name="param", value = "Hello from init method")})
public class SessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//esto es para sobreescribir el metodo init en la parte donde dice WebServlet
		//String initParam = this.getServletConfig().getInitParameter("param");
		//esto es para sobreescribir el metodo init en la parte del web.XML
		String initParam = this.getServletConfig().getInitParameter("TakingFromXML");
		
		System.out.println(initParam);
		
		
		response.setContentType("text/html");
		String username = request.getParameter("username");
		PrintWriter out = response.getWriter();
		
		out.println("User name saved in request Object : " + username +"<br>");
		
		////////////////VARIABLE DE SESSION////
		/*Solo residen mientras el navegador siga abierto
		 * */
		HttpSession session = request.getSession();
		
		if(username != "" && username != null)
		{
			session.setAttribute("usernameSessionScope", username);
		}
		
		out.println("User name saved in Session scope : " + session.getAttribute("usernameSessionScope")+"<br>");
		
		////////////VARIABLES DE APLICACION///
		/*Residen para el alcance de toda la aplicacion aunque se cierre el navegador
		 * */
		ServletContext context = request.getServletContext();
		
		if(username != "" && username != null)
		{
			context.setAttribute("usernameContextScope", username);
		}
		out.println("User name saved in Context Scope : " + context.getAttribute("usernameContextScope") + "");
		
		
		
	}

}
