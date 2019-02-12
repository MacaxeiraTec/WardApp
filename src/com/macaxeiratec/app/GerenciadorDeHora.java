package com.macaxeiratec.app;

import java.util.ArrayList;
import java.util.List;

public class GerenciadorDeHora {
	private int iSeg,iMin,iHora,fSeg,fMin,fHora;
	//Criar classe HoraFlexivel para acomodar essas variáveis abaixo e formatalas corretamente;
	private int horas=0;
	private int minutos=0;
	private int segundos=0;
	
	public Hora getHoraAtual() {
		return new Hora();
	}
	public String toString() {
		return horas+" "+" "+minutos+" " + segundos;
	}
	
	private void zerarContadores() {
		this.horas=0;
		this.minutos=0;
		this.segundos=0;
	}
	public List<Hora> horasAtivasDoAction(List<Hora> horarios){
		List<Hora> lista=new ArrayList<Hora>();
		for(int x=0;x<horarios.size();x+=2) {
			Hora h=this.diferençaEntreHora(horarios.get(x), horarios.get(x+1));
			lista.add(h);
		}
		
		return lista;
	}
		
	public Hora somarHoras(List<Hora> lista){
		
		zerarContadores();
		for(Hora h:lista) {
			int x=h.getSegundos()+this.segundos;
			this.segundos=x%60;
			this.minutos+=x/60;
			x=h.getMinutos()+this.minutos;
			this.minutos=x%60;
			this.horas+=x/60;
			this.horas+=h.getHora();
		}
		return new Hora(this.horas,this.minutos,this.segundos);
		
	}
	public void somarDuasHoras(Hora h1,Hora h2){
		
		zerarContadores();
		int x=h1.getSegundos()+h2.getSegundos();
		this.segundos+=x%60;
		this.minutos+=x/60;
		x=h1.getMinutos()+h2.getMinutos();
		this.minutos+=x%60;
		this.horas+=x/60;
		this.horas+=h1.getHora()+h2.getHora();

	}
	
	//Calcula a diferença entre duas horas
	public Hora diferençaEntreHora(Hora horaInicio,Hora horaFim) {
		zerarContadores();
		inicializaHorario(horaInicio, horaFim);
		calculaSegundos();
		calculaMinutos();
		calculaHoras();
		return new Hora(this.horas,this.minutos,this.segundos);
			
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
	public String getGraficoDaAtividade(Action a) {
		String message="";
		List<Hora> lista=a.getHorasEmAcao();
		for(int x=0;x<lista.size();x+=2) {
			message+= lista.get(x).toString()+" <--> "+lista.get(x+1).toString()+"\n";
		}
		return message;
	}

}
