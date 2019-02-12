package com.macaxeiratec.app;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Testes {

	public static void main(String[] args) {
		
		
		Date data=new Date();
		SimpleDateFormat d=new SimpleDateFormat();
		System.out.println(d.toString());
		
		System.out.println(data.toString());
		Hora h=new Hora();
		System.out.println(h.toString());
		Hora hora=new Hora(23,59,59);
		Hora hora2=new Hora(00,01,03);
		GerenciadorDeHora g=new GerenciadorDeHora();
		g.diferençaEntreHora(hora, hora2);
		List<Hora> horarios=new ArrayList<Hora>();
		horarios.add(hora);
		horarios.add(hora2);
		horarios.add(hora);
		horarios.add(hora2);
		h=g.somarHoras(g.horasAtivasDoAction(horarios));
		System.out.print(h.toString());
		
		
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
