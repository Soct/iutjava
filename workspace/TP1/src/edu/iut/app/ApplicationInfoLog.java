package edu.iut.app;

import java.util.ArrayList;

public class ApplicationInfoLog extends AbstractApplicationLog {

	private ArrayList<IApplicationLogListener> listeners;
	
	/** Ajouter un tableau ou profiter de l'héritage ? */
	public ApplicationInfoLog() {
		super();
		listeners = new ArrayList<>();
	}
	
	@Override
	public void setMessage(String message) {
		this.message = message;
        super.fireMessage("[INFO]", this.message);
        for(int i=0;i<listeners.size();i++)
		{
			listeners.get(i).newMessage("[INFO]", message);
		}
	}

	@Override
	public String getMessage() {
		return this.message;
	}

	@Override
	public IApplicationLogListener[] getpplicationLogListeners() {
		return null;
	}

}
