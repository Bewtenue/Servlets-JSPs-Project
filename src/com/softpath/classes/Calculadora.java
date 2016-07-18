package com.softpath.classes;

public class Calculadora {
	public double number1;
	public double number2;
	
	public Calculadora(double number1,double number2){
		this.number1 = number1;
		this.number2 = number2;
	}
	
	public String addition(){
		return "<h3>El resultado de la suma es : " + (this.number1 + this.number2+"</h3>");
	}
	
	public String subtraction(){
		return "<h3>El resultado de la resta es : " + (this.number1 - this.number2+"</h3>");
	}
	
	public String multiplication(){
		return "<h3>El resultado de la multiplicacion es : " + (this.number1 * this.number2+"</h3>");
	}
	
	public String division(){
		if((this.number2 == 0)){
			return "<h3>No se puede dividir entre 0</h3>";
		} else if((this.number1 == 0))
		{
			return "<h3>El resultado de la division es : 0</h3>";
		}else{
			return "<h3>El resultado de la division es : " + (this.number1 / this.number2)+"</h3>";
		}
		
	}
	
	public String power(){
		double resultado=this.number1;
		if((this.number1 == 0) || this.number2 == 0){
			return "<h3>El resultado de la potencia es : 0</h3>";
		}else{
			for(int i = 2; i <= this.number2; i++){
				resultado = resultado * this.number1;
			}
			return "<h3>El resultado de la potencia es : " + (resultado)+"</h3>";
		}
	}
	
	
}
