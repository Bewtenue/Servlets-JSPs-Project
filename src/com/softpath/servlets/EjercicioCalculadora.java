package com.softpath.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.softpath.classes.Calculadora;


@WebServlet("/ejercicioCalculadora")
public class EjercicioCalculadora extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//System.out.println("Entrando al metodo doPost");
		PrintWriter writer = response.getWriter();
		
		try{
			Double number1 = Double.parseDouble(request.getParameter("number1"));
			Double number2 = Double.parseDouble(request.getParameter("number2"));
			Calculadora calc = new Calculadora(number1,number2);
			String metodo = request.getParameter("metodo");
			
			switch(metodo){
			case "radio":
				String operacion = request.getParameter("operation");
				switch(operacion){
				case "addition":
					writer.println(calc.addition());
					break;
				case "subtraction":
					writer.println(calc.subtraction());
					break;
				case "multiplication":
					writer.println(calc.multiplication());
					break;
				case "division":					
					writer.println(calc.division());
					break;
				case "power":
					writer.println(calc.power());
					break;
				}
				break;
			case "select":
				String arrayParameters[] = request.getParameterValues("operation");
				for(String op: arrayParameters){
					switch(op){
					case "addition":
						writer.println(calc.addition());
						break;
					case "subtraction":
						writer.println(calc.subtraction());
						break;
					case "multiplication":
						writer.println(calc.multiplication());
						break;
					case "division":						
						writer.println(calc.division());
						break;
					case "power":
						writer.println(calc.power());
						break;
					}
				}
				break;
			}
			
		}
		catch(NumberFormatException e){
			e.getMessage();
		}
	}

}
