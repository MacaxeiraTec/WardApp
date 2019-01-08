package com.macaxeiratec.app;

import java.util.ArrayList;
import java.util.List;

public class GerenciadorDeHora {
	int iSeg,iMin,iHora,fSeg,fMin,fHora;
	List<Hora> list=new ArrayList<Hora>();
	//Criar classe HoraFlexivel para acomodar essas variáveis abaixo e formatalas corretamente;
	int horas=0;
	int minutos=0;
	int segundos=0;
	
	public Hora getHoraAtual() {
		return new Hora();
	}
	//Calcula a diferença entre duas horas
	public void diferençaEntreHora(Hora horaInicio,Hora horaFim) {
		inicializaHorario(horaInicio, horaFim);
		calculaSegundos();
		calculaMinutos();
		calculaHoras();
			
	}
	//Inicializa as variáveis para fazer os cálculos
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
