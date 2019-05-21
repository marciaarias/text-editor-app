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
import java.io.FileReader;
import java.io.FileWriter;

public class TextEditorApp {

	private JFrame frmTextEditor;
	private JTextArea textArea;
	Utilities utilities = new Utilities();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TextEditorApp window = new TextEditorApp();
					window.frmTextEditor.setVisible(true);
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
		
		//Implement windowClosing event.
		
		frmTextEditor.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				
				utilities.showConfirmClosingWindow(frmTextEditor, textArea);
				
			}
		});
		frmTextEditor.setTitle("Text Editor");
		frmTextEditor.setResizable(false);
		frmTextEditor.setBounds(100, 100, 520, 682);
		frmTextEditor.setLocationRelativeTo(null);
		frmTextEditor.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frmTextEditor.getContentPane().setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 514, 22);
		frmTextEditor.getContentPane().add(menuBar);
		
		JMenu menuFile = new JMenu("File");
		menuBar.add(menuFile);
		
		//Implement menuItem "New".
		
		JMenuItem menuItemNew = new JMenuItem("New");
		menuItemNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(!textArea.getText().equals("")) {
					int clickedOption = JOptionPane.showConfirmDialog(null, "Any changes will be discarded.\nCreate new document?", "Confirm New", JOptionPane.YES_NO_OPTION);
				    if(clickedOption == JOptionPane.YES_OPTION){
				    	textArea.setText("");
				    }
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

	            JFileChooser fileChooser = new JFileChooser("C:/Users/arias/Desktop"); 
	  
	            int selectedOption = fileChooser.showSaveDialog(null); 
	  
	            if (selectedOption == JFileChooser.APPROVE_OPTION) { 
	                File file = new File(fileChooser.getSelectedFile().getAbsolutePath()); 
	  
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
				
			}
		});
		menuItemSave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
		menuFile.add(menuItemSave);
		
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
		
		JMenuItem menuItemFind = new JMenuItem("Find...");
		menuItemFind.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F, InputEvent.CTRL_MASK));
		menuEdit.add(menuItemFind);
		
		JMenuItem menuItemReplace = new JMenuItem("Replace...");
		menuItemReplace.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, InputEvent.CTRL_MASK));
		menuEdit.add(menuItemReplace);
		
		menuEdit.add(new JSeparator());
		
		JMenuItem menuItemSelectAll = new JMenuItem("Select All");
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
		
		JMenuItem menuItemFont = new JMenuItem("Font...");
		menuFormat.add(menuItemFont);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(3, 23, 498, 617);
		frmTextEditor.getContentPane().add(scrollPane);
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
	}
}
