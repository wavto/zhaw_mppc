package ch.dave.mppc.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import ch.dave.mppc.utilities.TitlePanel;

public class MemoryView extends JPanel{
	
	private static final long serialVersionUID = -4976705482061558691L;
	
	private JPanel programmViewPanel;
	private JPanel dataViewPanel;
	
	public MemoryView() {
		
		setLayout(new GridLayout(1, 2));
		
		// ProgrammPanel
		JPanel programmPanel = new JPanel();
		programmPanel.setLayout(new BorderLayout());
		add(programmPanel);
		
		programmPanel.add(new TitlePanel("Programm", 0, 1, 1, 1), BorderLayout.NORTH);
		
		JPanel programmViewHelpPanel = new JPanel();
		programmPanel.add(programmViewHelpPanel, BorderLayout.CENTER);
		
		programmViewPanel = new JPanel();
		programmViewPanel.setLayout(new BoxLayout(programmViewPanel, BoxLayout.Y_AXIS));
		programmViewHelpPanel.add(programmViewPanel);
		
		
		// DataPanel
		JPanel dataPanel = new JPanel();
		dataPanel.setLayout(new BorderLayout());
		add(dataPanel);
		
		dataPanel.add(new TitlePanel("Daten", 0, 0, 1, 0), BorderLayout.NORTH);
		
		JPanel dataViewHelpPanel = new JPanel();
		dataPanel.add(dataViewHelpPanel, BorderLayout.CENTER);
		
		dataViewPanel = new JPanel();
		dataViewPanel.setLayout(new BoxLayout(dataViewPanel, BoxLayout.Y_AXIS));
		dataViewHelpPanel.add(dataViewPanel);
	}
	
	public void setProgrammMemoryPanel(MemoryPanel memoryPanel){
		programmViewPanel.add(memoryPanel);
	}
	
	public void removeProgrammMemoryPanels(){
		programmViewPanel.removeAll();
	}
	
	public void setDataMemoryPanel(MemoryPanel memoryPanel){
		dataViewPanel.add(memoryPanel);
	}

}
