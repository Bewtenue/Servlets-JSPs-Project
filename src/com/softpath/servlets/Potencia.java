package com.softpath.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.coyote.Response;
import org.apache.tomcat.util.codec.binary.StringUtils;

import com.softpath.classes.ClassServletTest;


@WebServlet("/Potencia")
public class Potencia extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter writer = response.getWriter();
		try
		{
			Double potencia = Double.parseDouble(request.getParameter("potencia"));
			Double base = Double.parseDouble(request.getParameter("base"));
			double resultado = base;
			for(int i = 2; i <= potencia; i++){
				resultado = resultado * base;
			}
			
			if((potencia  == null || base == null) || (potencia  == 0 || base == 0))
			{
				//writer.println("No se puede realizar la potencia con 0 o nulos");
				
			}
			else
			{
				//writer.println("<h3>La potencia de los numeros es : "+ Math.pow(base, potencia)+ "</h3>");
				writer.println("<h3>La potencia de los numeros es : "+ resultado + "</h3>");
			}
		}
		catch(NumberFormatException e)
		{
			writer.println("<h3>No puedes dejar espacios vacios o usar letras</h3>");
		}
		
		ClassServletTest test1 = new ClassServletTest("123","Jesus","Ley");
		writer.println("<h3>Este es el objeto con el Override a toString</h3>");
		writer.println("<h3>"+ test1 + "</h3>");
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
