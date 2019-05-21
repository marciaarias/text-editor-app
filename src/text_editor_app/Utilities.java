package text_editor_app;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Utilities {
	
	public void showConfirmClosingWindow(JFrame frame) {	
		int clickedOption = JOptionPane.showConfirmDialog(null, "Any changes will be discarded.\nAre you sure you want to exit?", "Confirm Exit", JOptionPane.YES_NO_OPTION);
	    if(clickedOption == JOptionPane.YES_OPTION){
	    	frame.dispose();
	    }
	}

}
