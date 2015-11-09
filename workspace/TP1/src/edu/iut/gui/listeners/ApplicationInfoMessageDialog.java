package edu.iut.gui.listeners;

import javax.swing.JOptionPane;

public class ApplicationInfoMessageDialog extends
		AbstractApplicationMessageDialog {

	@Override
	protected void showMessage(String message) {
		/** UTILISER l'AIDE FORUNIR DANS L'ENNONCE */
		JOptionPane.showMessageDialog(null, message, "Information", JOptionPane.INFORMATION_MESSAGE);
	}
}
