package edu.iut.app;

import java.util.ArrayList;
/**
 * 
 * 
 * @author Marceau Pheulpin & Paul Chaumeil
 *
 */
public class CriteriaClassroom implements Criteria{

	private ArrayList<String> batiments;
	private int classMin;
	private int classMax;
	
	public CriteriaClassroom(ArrayList<String> batiments, int classMin, int classMax)
	{
		super();
		this.batiments = batiments;
		this.classMin = classMin;
		this.classMax = classMax;
	}

	@Override
	/**
	 * 
	 * 
	 * @param exams
	 * 				On regarde si la Classroom de cet exams est bien conforme.
	 * @return les exams valides.
	 * 	
	 */
	public Agenda meetCriteria(Agenda exams) {
		
		Agenda examOK = new Agenda();

		
		for(ExamEvent exam : exams)
		{			
			if(exist(exam.getClassroom().getClassRoomNumber().charAt(0))
					&& Integer.parseInt(exam.getClassroom().getClassRoomNumber().substring(1))>=classMin
					&& Integer.parseInt(exam.getClassroom().getClassRoomNumber().substring(1))<=classMax)
			{
				examOK.add(exam);
			}
		}
		
		return examOK;
	}
	/**
	 * 
	 * 
	 * @param c
	 * 				le nom d'une salle.
	 * @return si la salle a été trouvée.
	 */
	private boolean exist(char c)
	{
		boolean trouve=false;
		int i=0;
		while(!trouve && i<batiments.size())
		{
			trouve = batiments.get(i).charAt(0)==c;
			i++;
		}
		return trouve;
	}

}
