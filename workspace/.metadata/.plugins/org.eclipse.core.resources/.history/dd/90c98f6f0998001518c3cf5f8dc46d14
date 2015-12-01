package edu.iut.app;

public class CriteriaPerson implements Criteria {

	@Override
	public Agenda meetCriteria(Agenda exams) {
		
		Agenda examOK = new Agenda();
		
		for(ExamEvent exam : exams)
		{
			if(exam.getStudent().getPhone().length()==10)
			{
				examOK.add(exam);
			}
		}
		
		return examOK;
	}

}
