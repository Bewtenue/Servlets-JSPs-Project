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
 * el flujo de ejecucion de un servlet es con Init() el cual TomCat se encarga de inicializar
 * luego el metodo service() revisa si se requiere un doGet() o un doPost()
 */

//se puede sobreescribir el metodo init con una notacion como aqui abajo o dentro de un xml
@WebServlet(urlPatterns = "/despliegaInformacion",
initParams = {@WebInitParam(name="param", value = "Hello from init method")})

public class DespliegaInformacion extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String form = (String) request.getParameter("submit");
		HttpSession session = request.getSession();
		//session.setMaxInactiveInterval(20);//sirve para indicar el tiempo de expiracion del objeto session en segundos
		switch(form){
		case "Datos":
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			String username = request.getParameter("username");
			String location = request.getParameter("location");
			
			if((name != "" && name != null) || (email != "" && email !=null) || (username !="" && username != null) || (location != "" && location != null))
			{
				session.setAttribute("nameSession", name);
				session.setAttribute("emailSession", email);
				session.setAttribute("usernameSession", username);
				session.setAttribute("locationSession", location);
			}
			
			response.sendRedirect("formularioGustos.html");
			break;
		case "Gustos":
		
			response.setContentType("text/html");
			String gustos = request.getParameter("gustos");
			String disgustos = request.getParameter("disgustos");
			String deporte = request.getParameter("deporte");
			PrintWriter out = response.getWriter();
			
			
			out.println("Tu nombre es : " + session.getAttribute("nameSession") + "<br>");
			out.println("Tu correo es : " + session.getAttribute("emailSession") + "<br>");
			out.println("Tu username es : " + session.getAttribute("usernameSession") + "<br>");
			out.println("Tu ubicacion es : "+ session.getAttribute("locationSession")+"<br>");
			out.println("Tus gustos son :" + gustos + "<br>");
			out.println("Tus disgutos son :" + disgustos + "<br>");
			out.println("Tu deporte favorito es :" + deporte + "<br>");
			break;
			
		}
	}

	

}
