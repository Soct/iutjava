package edu.iut.app;

import java.util.ArrayList;

public abstract class AbstractApplicationLog implements IApplicationLog {

	protected String message;
	protected ArrayList<IApplicationLogListener> listeners;
	
	public AbstractApplicationLog() {
		message = null;
		listeners = new ArrayList<IApplicationLogListener>();
	}
	
	@Override
	/**
	 * 
	 * 
	 * @param message
	 * 				Permet de set un nouveau message.
	 *
	 */
	public abstract void setMessage(String message);

	@Override
	/**
	 * Retourne un message
	 * 
	 * @return un message qui correspond au cas.
	 *
	 */
	public String getMessage() {
		return message;
	}

	@Override
	/**
	 * 
	 * 
	 * @param listener
	 * 				Ajoute listener à la l'ArrayList listeners.
	 *
	 */
	public void addListener(IApplicationLogListener listener) {
		listeners.add(listener);

	}
	@Override
	/**
	 * 
	 * 
	 * @return Change l'appliccation log en ArrayList
	 *
	 */
	public IApplicationLogListener[] getApplicationLogListeners() {
		return (IApplicationLogListener[])listeners.toArray();
	}
	/**
	 * 
	 * 
	 * @param level
	 * 				set le nouveau level du message
	 * @param message
	 * 				set le nouveau message de la pop-up
	 *
	 */
	
	protected void fireMessage(String level, String message) {
		for (IApplicationLogListener listener_i : listeners) {
			listener_i.newMessage(level, message);
		}
	}
}
