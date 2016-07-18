package com.softpath.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.softpath.classes.Calculadora;


//@WebServlet("/InitCalculadora")
public class InitCalculadora extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Double numero1 = Double.parseDouble(this.getServletConfig().getInitParameter("numero1"));
		Double numero2 = Double.parseDouble(this.getServletConfig().getInitParameter("numero2"));
		Calculadora calc = new Calculadora(numero1,numero2);
		PrintWriter out = response.getWriter();
		out.println(calc.addition());
		out.println(calc.subtraction());
		out.println(calc.multiplication());
		out.println(calc.division());
		
	}

	

}
