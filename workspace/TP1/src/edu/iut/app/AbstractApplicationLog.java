package edu.iut.app;

import java.util.ArrayList;

public abstract class AbstractApplicationLog implements IApplicationLog {

	protected String message;
	/** TP1 : Tableau au sens des collections **/
	protected ArrayList<IApplicationLogListener> listeners;
	
	public AbstractApplicationLog() {
		message = null;
		listeners = new ArrayList<>();
	}
	
    /** TP1 : Fonction venant de l'interface par héritage */


	/** Listener action */
	protected void fireMessage(String level, String message) {
		for (IApplicationLogListener listener_i : listeners) {
			listener_i.newMessage(level, message);
		}
	}
	
	public void setMessage(String s)
	{
		message=s;
	}
	
	public void addListener(IApplicationLogListener l)
	{
		listeners.add(l);
	}
	
	public ArrayList<IApplicationLogListener> getArrayListener()
	{
		return listeners;
	}
}
