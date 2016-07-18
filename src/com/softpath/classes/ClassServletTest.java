package com.softpath.classes;

public class ClassServletTest {
	public String id;
	public String nombre;
	public String apellido;
	
	public ClassServletTest(String id, String nombre, String apellido){
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
	}
	
	@Override
	public String toString(){
		return "ID : " + this.id + " NOMBRE : " + this.nombre + " APELLIDO : " +this.apellido;
	}
	
}
