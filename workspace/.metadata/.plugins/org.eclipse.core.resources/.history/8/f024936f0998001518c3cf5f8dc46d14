package edu.iut.app;

import java.util.Date;

public class CriteriaDate implements Criteria {
	
	private Date start;
	private Date end;
	
	public CriteriaDate(Date start, Date end) {
		super();
		this.start = start;
		this.end = end;
	}
	
	public Agenda meetCriteria(Agenda exams)
	{
		Agenda examInDate = new Agenda();
		
		for(ExamEvent exam : exams)
		{
			if(exam.getExamDate().compareTo(start)>0 && exam.getExamDate().compareTo(end)<0)
			{
				examInDate.add(exam);
			}
		}
		
		return examInDate;
	}
	
}
