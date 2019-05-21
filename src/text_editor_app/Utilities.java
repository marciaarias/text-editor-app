package text_editor_app;

import java.io.File;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class Utilities {
	
	public void showConfirmClosingWindow(JFrame frame, JTextArea textArea) {	
		
		if(textArea.getText().equals("") && frame.getTitle().equals("Untitled - Text Editor")) {
			frame.dispose();
			
		} else {
			int clickedOption = JOptionPane.showConfirmDialog(null, "Any changes will be discarded.\nAre you sure you want to exit?", "Confirm Exit", JOptionPane.YES_NO_OPTION);
		    if(clickedOption == JOptionPane.YES_OPTION){
		    	frame.dispose();
		    }
		}
		
	}
	
	public void setMainWindowTitle(JFrame frame, File file, String title) {
		frame.setTitle(file.getName() + " - Text Editor");
	}
	
	public void setMainWindowTitle(JFrame frame, String title) {
		frame.setTitle(title);
	}

}
