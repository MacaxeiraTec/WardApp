package com.macaxeiratec.app;

import java.util.ArrayList;
import java.util.List;

public class GerenciadorDeHora {
	private int iSeg,iMin,iHora,fSeg,fMin,fHora;
	//Criar classe HoraFlexivel para acomodar essas vari�veis abaixo e formatalas corretamente;
	private int horas=0;
	private int minutos=0;
	private int segundos=0;
	
	public Hora getHoraAtual() {
		return new Hora();
	}
	public String toString() {
		return horas+" "+" "+minutos+" " + segundos;
	}
	//Calcula a diferen�a entre duas horas
	public void diferen�aEntreHora(Hora horaInicio,Hora horaFim) {
		inicializaHorario(horaInicio, horaFim);
		calculaSegundos();
		calculaMinutos();
		calculaHoras();
			
	}
	//Inicializa as vari�veis para fazer os c�lculos
	private void inicializaHorario(Hora horaInicio, Hora horaFim) {
		iSeg=horaInicio.getSegundos();
		iMin= horaInicio.getMinutos();
		iHora=horaInicio.getHora();
		fSeg=horaFim.getSegundos();
		fMin= horaFim.getMinutos();
		fHora=horaFim.getHora();
		
	}
	// Calcula os segundos
	private void calculaSegundos() {
		if(fSeg<iSeg) {
			
			this.segundos+=fSeg+60-iSeg;
			iMin++;
			iHora+=iMin/60;
			iHora=iHora%24;
			iMin=iMin%60;
			
		}else this.segundos+=fSeg-iSeg;
	}
	//Calcula os minutos
	private void calculaMinutos() {
		if(fMin<iMin) {
			this.minutos+=fMin+60-iMin;
			iHora++;
			iHora=iHora%24;
			
		}else this.minutos+=fMin-iMin;
	}
	//Calcula as horas
	private void calculaHoras() {
		if(fHora<iHora) {
			
			this.horas+=fHora+24-iHora;
			
		}else this.horas+=fHora-iHora;
	}

}
