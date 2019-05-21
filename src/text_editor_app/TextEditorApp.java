package text_editor_app;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;
import javax.swing.undo.UndoManager;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JCheckBoxMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TextEditorApp {

	private JFrame frmTextEditor;
	private JTextArea textArea;

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
	private void initialize() {
		frmTextEditor = new JFrame();
		frmTextEditor.setTitle("Text Editor");
		frmTextEditor.setResizable(false);
		frmTextEditor.setBounds(100, 100, 520, 682);
		frmTextEditor.setLocationRelativeTo(null);
		frmTextEditor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTextEditor.getContentPane().setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 514, 22);
		frmTextEditor.getContentPane().add(menuBar);
		
		JMenu menuFile = new JMenu("File");
		menuBar.add(menuFile);
		
		JMenuItem menuItemNew = new JMenuItem("New");
		menuFile.add(menuItemNew);
		
		JMenuItem menuItemOpen = new JMenuItem("Open...");
		menuFile.add(menuItemOpen);
		
		JMenuItem menuItemSave = new JMenuItem("Save");
		menuFile.add(menuItemSave);
		
		JMenuItem menuItemSaveAs = new JMenuItem("Save As...");
		menuFile.add(menuItemSaveAs);
		
		menuFile.add(new JSeparator());
		
		JMenuItem menuItemExit = new JMenuItem("Exit");
		menuFile.add(menuItemExit);
		
		JMenu menuEdit = new JMenu("Edit");
		menuBar.add(menuEdit);
		
		//Implement menuItem "Cut".
		
		JMenuItem menuItemCut = new JMenuItem("Cut");
		menuItemCut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				textArea.cut();
				
			}
		});
		menuEdit.add(menuItemCut);
		
		//Implement menuItem "Copy".
		
		JMenuItem menuItemCopy = new JMenuItem("Copy");
		menuItemCopy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				textArea.copy();
				
			}
		});
		menuEdit.add(menuItemCopy);
		
		//Implement menuItem "Paste".
		
		JMenuItem menuItemPaste = new JMenuItem("Paste");
		menuItemPaste.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				textArea.paste();
				
			}
		});
		menuEdit.add(menuItemPaste);
		
		menuEdit.add(new JSeparator());
		
		JMenuItem menuItemFind = new JMenuItem("Find...");
		menuEdit.add(menuItemFind);
		
		JMenuItem menuItemReplace = new JMenuItem("Replace...");
		menuEdit.add(menuItemReplace);
		
		menuEdit.add(new JSeparator());
		
		JMenuItem menuItemSelectAll = new JMenuItem("Select All");
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
