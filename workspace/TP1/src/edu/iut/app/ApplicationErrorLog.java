package edu.iut.app;

import java.util.ArrayList;

public class ApplicationErrorLog extends AbstractApplicationLog {

	private ArrayList<IApplicationLogListener> listeners;
	/** Ajouter un tableau ou profiter de l'héritage ? */
	public ApplicationErrorLog() {
		super();
		listeners = new ArrayList<>();
	}
	
	@Override
	public void setMessage(String message) {
		this.message = message;
		super.fireMessage("[ERROR]", this.message);
		
		for(int i=0;i<listeners.size();i++)
		{
			listeners.get(i).newMessage("[ERROR]", message);
		}
	}

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IApplicationLogListener[] getpplicationLogListeners() {
		// TODO Auto-generated method stub
		return null;
	}

}
