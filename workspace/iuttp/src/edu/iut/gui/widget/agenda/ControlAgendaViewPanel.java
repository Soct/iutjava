package edu.iut.gui.widget.agenda;

import java.awt.*;

import javax.swing.*;

public class ControlAgendaViewPanel extends JPanel {

	static final long serialVersionUID = 1L;
	
	CardLayout agendaViewLayout;
	JPanel contentPane;
	
	int selectedYear;
	int selectedMonth;
	int selectedDay;
	
	public ControlAgendaViewPanel(CardLayout layerLayout, final JPanel contentPane) {

		this.agendaViewLayout = layerLayout;
		this.contentPane = contentPane;
		
		
		
		/** EX3: REMPLACEMENT DU BOUTON NEXT */
	}
	
	public int getYear() {
		return selectedYear;
	}
	public int getMonth() {
		return selectedMonth;
	}
	public int getDay() {
		return selectedDay;
	}
	
}
