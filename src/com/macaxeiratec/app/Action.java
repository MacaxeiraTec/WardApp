package com.macaxeiratec.app;

import java.util.ArrayList;
import java.util.List;

public class Action {
	private List<Hora> horas;
	private String name;
	private boolean run;
	private boolean play;
	public Action(String name) {
		this.name=name;
		this.horas =new ArrayList<Hora>();
		
	}
	public void startAndPause(Hora hora) {
		if(play) {
			if(!run) {
				
				run=true;
			}else  run=false;
			this.horas.add(hora);
		}
		
	}
	public List<Hora> getHorasEmAcao(){
		return this.horas;
	}
	public void stop(Hora hora) {
		if(run) {
			this.horas.add(hora);
		}
		this.play=false;
	}
	public String relatorio() {
		return "Relatorio:\n\n"+name.toUpperCase();
	}

}
