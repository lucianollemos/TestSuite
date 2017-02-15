package view;

import java.awt.Button;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TestsConfigWindow {

	private JFrame window;
	private JLabel label;
	private Button button;
	private JPanel labelPanel, comboPanel, buttonPanel, mainPanel;
	private JComboBox comboBrowser;
	private String[] optionsBrowser = {"Firefox","Chrome"};
	
	public TestsConfigWindow(ActionListener listener) {
		
		label = new JLabel("Selecione o browser para a realização do teste");
		
		labelPanel = new JPanel();
		labelPanel.setSize(540,100);
		labelPanel.add(label);

		comboBrowser = new JComboBox(optionsBrowser);
		comboBrowser.setSelectedIndex(0);
				
		comboPanel = new JPanel();
		comboPanel.setSize(540,200);
		comboPanel.add(comboBrowser);
		
		button = new Button("Iniciar");
		button.addActionListener(listener);

		buttonPanel = new JPanel();
		buttonPanel.add(label);
		buttonPanel.add(button);
				
		mainPanel = new JPanel();
		mainPanel.add(labelPanel);
		mainPanel.add(comboPanel);
		mainPanel.add(buttonPanel);
		
		window = new JFrame("Argentum");
		window.add(mainPanel);
		window.setSize(540, 150);
		window.setVisible(true);
	}
	
	public JFrame getWindow(){
		return window;
	}
	
	public int getSelectedBrowser(){
		return comboBrowser.getSelectedIndex();
	}
	
	public Button getButton(){
		return button;
	}
}
