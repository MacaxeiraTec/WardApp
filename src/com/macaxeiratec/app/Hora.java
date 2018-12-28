package com.macaxeiratec.app;

import java.text.SimpleDateFormat;
import java.util.Date;

//Classe captura o tempo

public class Hora {
	private Date data;
	private SimpleDateFormat format;
	private int horas;
	private int minutos;
	private int segundos;
	
	public Hora(int hora, int minuto, int segundo) {
		
		this.horas=hora;
		this.minutos=minuto;
		this.segundos=segundo;
		
	}
	
	public Hora() {
		this.data=new Date();
		this.format=new SimpleDateFormat("HHmmss");
		formatation(format);
	}
	
	private void formatation(SimpleDateFormat format) {
		String s=format.format(data);
		this.horas=Integer.parseInt(s.substring(0, 2));
		this.minutos=Integer.parseInt(s.substring(2, 4));
		this.segundos=Integer.parseInt(s.substring(4, 6));
		
	}
	
	public String getHorario() {
		//CONSERTAR: string sai mal formatado se qaualquer elementos tiver apenas 1 digito
		return horas+":"+minutos+":"+segundos; 
	}
	
	public int getSegundos() {
		return this.segundos;
	}
	
	public int getMinutos() {
		return this.minutos;
	}
	
	public int getHora() {
		return this.horas;
	}

}
