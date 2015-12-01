package edu.iut.app;

import java.util.LinkedList;

public class Agenda extends LinkedList<ExamEvent> {
	
	private static final long serialVersionUID = 1L;

	public Agenda() {		
	}
	/**
	 * 
	 * 
	 * @param examEvent
	 * 				Ajoute un evenement a l'agenda.
	 *
	 */
	public void addCheckedEvent(ExamEvent examEvent) {
		this.add(examEvent);
	}
	
}
