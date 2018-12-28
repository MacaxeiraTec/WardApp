package com.macaxeiratec.app;

import java.util.Scanner;

public class Testes {

	public static void main(String[] args) {
		Hora hora=new Hora(23,59,59);
		Hora hora2=new Hora(00,01,03);
		GerenciadorDeHora g=new GerenciadorDeHora();
		g.diferençaEntreHora(hora, hora2);
		System.out.println(g.horas+":"+g.minutos+":"+g.segundos);
		
		/*GerenciadorDeHora g=new GerenciadorDeHora();
		Hora hora=new Hora();
		Scanner scan= new Scanner(System.in);
		scan.nextLine();
		Hora hora2=new Hora();
		g.diferençaEntreHora(hora, hora2);
		System.out.println(g.horas+":"+g.minutos+":"+g.segundos);
		scan.close();
		*/
		
	}

}
