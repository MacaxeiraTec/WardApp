package com.macaxeiratec.app;

import java.util.ArrayList;
import java.util.List;

public class GerenciadorDeActions {
	List<Action> actions;
	GerenciadorDeHora gerenteH;
	public GerenciadorDeActions() {
		this.actions=new ArrayList<Action>();
		this.gerenteH=new GerenciadorDeHora();
		actions.add(new Action("Aluno Ouvindo"));
		actions.add(new Action("Professor falando"));
		actions.add(new Action("Aluno falando"));
	}
	public void playPauseAlunoOuvindo() {
		getAlunoOuvindo().startAndPause(gerenteH.getHoraAtual());
	}
	public void playPauseProfessorFalando() {
		getProfessorFalando().startAndPause(gerenteH.getHoraAtual());
	}
	public void playPauseAlunoFalando() {
		getAlunoFalando().startAndPause(gerenteH.getHoraAtual());
	}
	private Action getAlunoOuvindo() {
		return actions.get(0);
	}
	private Action getProfessorFalando() {
		return actions.get(1);
	}
	private Action getAlunoFalando() {
		return actions.get(2);
	}
	
}
