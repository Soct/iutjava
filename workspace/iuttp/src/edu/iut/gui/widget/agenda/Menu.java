package edu.iut.gui.widget.agenda;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Menu extends JMenuBar {
	
	
	private static final long serialVersionUID = 1L;
	
	private JMenu file = new JMenu("File");
		private JMenuItem load = new JMenuItem("Load");
		private JMenuItem save = new JMenuItem("Save");
		private JMenuItem quit = new JMenuItem("Quit");
		
	private JMenu edit = new JMenu("Edit");
		private JMenu view = new JMenu("View");
			private JMenuItem month = new JMenuItem("Month");
			private JMenuItem week = new JMenuItem("Week");
			private JMenuItem day = new JMenuItem("Day");
			
	private JMenu help = new JMenu("Help");
		private JMenuItem display = new JMenuItem("Display");
		private JMenuItem about = new JMenuItem("About");
	
	
	
	public Menu() {
		
		add(file);
			file.add(load);
			file.add(save);
			file.add(quit);
		
		add(edit);
			edit.add(view);
				view.add(month);
				view.add(week);
				view.add(day);
		
		add(help);
			help.add(display);
			help.add(about);
			
		month.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		week.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		day.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
	}

}
