package edu.iut.app;
/**
 * Criteria est l'interface qui permet de v�rifier qu'un objet 
 * est bien valide lorsqu'on l'instancie
 * 
 * @author Marceau Pheulpin & Paul Chaumeil
 *
 */

public interface Criteria {
	public Agenda meetCriteria(Agenda exams);
}
