package text_editor_app;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFileChooser;
import javax.swing.KeyStroke;
import javax.swing.UIManager;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.EventQueue;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;

import java.util.Formatter;
import java.awt.Toolkit;

public class TextEditorApp {

	private JFrame frmTextEditor;
	private JTextArea textArea;
	private String fileName;
	Utilities utilities = new Utilities();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		try { 
		    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
		    e.printStackTrace();
		}
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TextEditorApp window = new TextEditorApp();
					window.frmTextEditor.setVisible(true);
					window.textArea.requestFocus();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TextEditorApp() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings("deprecation")
	private void initialize() {
		frmTextEditor = new JFrame();
		frmTextEditor.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\arias\\eclipse-workspace\\text-editor-app\\resources\\text-editor.png"));
		
		//Implement windowClosing event.
		
		frmTextEditor.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				
				utilities.showConfirmClosingWindow(frmTextEditor, textArea);
				
			}
		});
		frmTextEditor.setTitle("Untitled - Text Editor");
		frmTextEditor.setResizable(false);
		frmTextEditor.setBounds(100, 100, 520, 682);
		frmTextEditor.setLocationRelativeTo(null);
		frmTextEditor.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frmTextEditor.getContentPane().setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(3, 0, 500, 22);
		frmTextEditor.getContentPane().add(menuBar);
		
		JMenu menuFile = new JMenu("File");
		menuBar.add(menuFile);
		
		//Implement menuItem "New".
		
		JMenuItem menuItemNew = new JMenuItem("New");
		menuItemNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(!frmTextEditor.getTitle().equals("Untitled - Text Editor")) {
					int clickedOption = JOptionPane.showConfirmDialog(null, "Any changes will be discarded.\nCreate new document?", "Confirm New", JOptionPane.YES_NO_OPTION);
				   
					if(clickedOption == JOptionPane.YES_OPTION) {
				    	textArea.setText("");
				    	utilities.setMainWindowTitle(frmTextEditor, "Untitled - Text Editor");
					}

				} else {
					utilities.setMainWindowTitle(frmTextEditor, "Untitled - Text Editor");
				}
				
			}
		});
		menuItemNew.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_MASK));
		menuFile.add(menuItemNew);
		
		//Implement menuItem "Open".
		
		JMenuItem menuItemOpen = new JMenuItem("Open...");
		menuItemOpen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
	            JFileChooser fileChooser = new JFileChooser("C:/Users/arias/Desktop"); 
	  
	            int selectedOption = fileChooser.showOpenDialog(null); 
	  
	            if (selectedOption == JFileChooser.APPROVE_OPTION) { 
	                File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
	                fileName = fileChooser.getSelectedFile().getAbsolutePath();
	                utilities.setMainWindowTitle(frmTextEditor, file, file.getName());
	  
	                try { 
	                    String stringReader1 = "", stringReader2 = ""; 
	                    FileReader fileReader = new FileReader(file); 
	                    BufferedReader bufferedReader = new BufferedReader(fileReader); 
	  
	                    stringReader2 = bufferedReader.readLine(); 
	  
	                    while ((stringReader1 = bufferedReader.readLine()) != null) { 
	                    	stringReader2 += "\n" + stringReader1; 
	                    } 
	  
	                    textArea.setText(stringReader2); 
	                    
	                    bufferedReader.close(); 
	                    
	                } catch (Exception exception) { 
	                    JOptionPane.showMessageDialog(frmTextEditor, exception.getMessage()); 
	                } 
	            } 
				
			}
		});
		menuItemOpen.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_MASK));
		menuFile.add(menuItemOpen);
		
		//Implement menuItem "Save".
		
		JMenuItem menuItemSave = new JMenuItem("Save");
		menuItemSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if(frmTextEditor.getTitle().equals("Untitled - Text Editor") && !textArea.getText().equals("")) {
		            JFileChooser fileChooser = new JFileChooser("C:/Users/arias/Desktop"); 
		      	  
		            int selectedOption = fileChooser.showSaveDialog(null); 
		  
		            if (selectedOption == JFileChooser.APPROVE_OPTION) { 
		                File file = new File(fileChooser.getSelectedFile().getAbsolutePath()); 
		                fileName = fileChooser.getSelectedFile().getAbsolutePath();
		                utilities.setMainWindowTitle(frmTextEditor, file, file.getName());
		                
		                try { 
		                    FileWriter fileWriter = new FileWriter(file, false); 
		                    BufferedWriter bufferedWriter = new BufferedWriter(fileWriter); 
		  
		                    bufferedWriter.write(textArea.getText()); 
		  
		                    bufferedWriter.flush(); 
		                    bufferedWriter.close(); 
		                    
		                } catch (Exception exception) { 
		                    JOptionPane.showMessageDialog(frmTextEditor, exception.getMessage()); 
		                } 
		            } 
		            
				} else {
					try {
				          Formatter formatter = new Formatter(new File(fileName));
				          formatter.format("%s", textArea.getText());
				          formatter.close();

					} catch (FileNotFoundException exception) {
						exception.printStackTrace();
					}
					
				}
				
			}
		});
		menuItemSave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
		menuFile.add(menuItemSave);
		
		//Implement menuItem "Save As...".
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Save As...");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				JFileChooser fileChooser = new JFileChooser("C:/Users/arias/Desktop"); 
				  
	            int selectedOption = fileChooser.showSaveDialog(null); 
	            
	            if (selectedOption == JFileChooser.APPROVE_OPTION) { 
	                File file = new File(fileChooser.getSelectedFile().getAbsolutePath()); 
	                fileName = fileChooser.getSelectedFile().getAbsolutePath();
	                
	                if(file.exists()) { 
	    				int clickedOption = JOptionPane.showConfirmDialog(null, "Are you sure you want to rewrite this file?", "Confirm Save As...", JOptionPane.YES_NO_OPTION);
	    			    
	    				if(clickedOption == JOptionPane.YES_OPTION) {
	    	                try { 
	    	                	utilities.setMainWindowTitle(frmTextEditor, file, file.getName());
	    	                    FileWriter fileWriter = new FileWriter(file, false); 
	    	                    BufferedWriter bufferedWriter = new BufferedWriter(fileWriter); 
	    	  
	    	                    bufferedWriter.write(textArea.getText()); 
	    	  
	    	                    bufferedWriter.flush(); 
	    	                    bufferedWriter.close(); 
	    	                    
	    	                } catch (Exception exception) { 
	    	                    JOptionPane.showMessageDialog(frmTextEditor, exception.getMessage()); 
	    	                } 
	    			    }
	    			    
	                } else {
    	                try { 
    	                	utilities.setMainWindowTitle(frmTextEditor, file, file.getName());
    	                    FileWriter fileWriter = new FileWriter(file, false); 
    	                    BufferedWriter bufferedWriter = new BufferedWriter(fileWriter); 
    	  
    	                    bufferedWriter.write(textArea.getText()); 
    	  
    	                    bufferedWriter.flush(); 
    	                    bufferedWriter.close(); 
    	                    
    	                } catch (Exception exception) { 
    	                    JOptionPane.showMessageDialog(frmTextEditor, exception.getMessage()); 
    	                } 
    	                
	                }
	                
	            } 
				
			}
		});
		menuFile.add(mntmNewMenuItem);
		
		menuFile.add(new JSeparator());
		
		//Implement menuItem "Exit".
		
		JMenuItem menuItemExit = new JMenuItem("Exit");
		menuItemExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				utilities.showConfirmClosingWindow(frmTextEditor, textArea);
				
			}
		});
		menuFile.add(menuItemExit);
		
		JMenu menuEdit = new JMenu("Edit");
		menuBar.add(menuEdit);
		
		//Implement menuItem "Cut".
		
		JMenuItem menuItemCut = new JMenuItem("Cut");
		menuItemCut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.CTRL_MASK));
		menuItemCut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				textArea.cut();
				
			}
		});
		menuEdit.add(menuItemCut);
		
		//Implement menuItem "Copy".
		
		JMenuItem menuItemCopy = new JMenuItem("Copy");
		menuItemCopy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_MASK));
		menuItemCopy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				textArea.copy();
				
			}
		});
		menuEdit.add(menuItemCopy);
		
		//Implement menuItem "Paste".
		
		JMenuItem menuItemPaste = new JMenuItem("Paste");
		menuItemPaste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, InputEvent.CTRL_MASK));
		menuItemPaste.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				textArea.paste();
				
			}
		});
		menuEdit.add(menuItemPaste);
		
		menuEdit.add(new JSeparator());
		
		//Implement menuItem "Select All".
		
		JMenuItem menuItemSelectAll = new JMenuItem("Select All");
		menuItemSelectAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				textArea.selectAll();
				
			}
		});
		menuItemSelectAll.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_MASK));
		menuEdit.add(menuItemSelectAll);
		
		JMenu menuFormat = new JMenu("Format");
		menuBar.add(menuFormat);
		
		//Implement menuItem "Word Wrap".
		
		JCheckBoxMenuItem chckbxMenuItemWordWrap = new JCheckBoxMenuItem("Word Wrap");
		chckbxMenuItemWordWrap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(chckbxMenuItemWordWrap.isSelected() == true) {
					textArea.setLineWrap(true);
				} else {
					textArea.setLineWrap(false);
				}
				
			}
		});
		menuFormat.add(chckbxMenuItemWordWrap);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(3, 23, 498, 617);
		frmTextEditor.getContentPane().add(scrollPane);
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
	}
}
