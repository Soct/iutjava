package edu.iut.app;

import java.util.ArrayList;

public class ApplicationWarningLog extends AbstractApplicationLog {

	private ArrayList<IApplicationLogListener> listeners;
	
	/** Ajouter un tableau ou profiter de l'héritage ? */
	public ApplicationWarningLog() {
		super();
		listeners = new ArrayList<>();
	}
	
	@Override
	public void setMessage(String message) {
		this.message = message;
		super.fireMessage("[WARNING]", this.message);
		 for(int i=0;i<listeners.size();i++)
			{
				listeners.get(i).newMessage("[WARNING]", message);
			}
	}

	@Override
	public String getMessage() {
		return this.message;
	}

	@Override
	public IApplicationLogListener[] getpplicationLogListeners() {
		// TODO Auto-generated method stub
		return null;
	}
}
