package edu.iut.app;

public class Classroom {
	
	protected String classRoomNumber; // Exemple : "I202"
	/**
	 * 
	 * 
	 * constructeur de Classroom
	 * 
	 */
	public Classroom() {
		classRoomNumber="not affected";
	}
	/**
	 * 
	 * 
	 * @param classRoomNumber
	 * 				set le nom de la classe associé a la classe Classroom.
	 *
	 */
	public Classroom(String classRoomNumber) {
		this.classRoomNumber=classRoomNumber;
	}
	/**
	 * 
	 * 
	 * @param number
	 * 				change le nom de la classe associé a la classe Classroom.
	 *
	 */
	public void setClassroomNumber(String number) {
		this.classRoomNumber=number;
	}
	/**
	 * 
	 * 
	 * @return classRoomNumber
	 * 				retourne le numéro de la classe.
	 *
	 */
	public String getClassRoomNumber() {
		return classRoomNumber;
	}
}
