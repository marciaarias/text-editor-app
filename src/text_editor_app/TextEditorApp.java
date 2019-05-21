package text_editor_app;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JCheckBoxMenuItem;

public class TextEditorApp {

	private JFrame frmTextEditor;

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
		
		JMenuItem menuItemUndo = new JMenuItem("Undo");
		menuEdit.add(menuItemUndo);
		
		JMenuItem menuItemRedo = new JMenuItem("Redo");
		menuEdit.add(menuItemRedo);
		
		JMenuItem menuItemCut = new JMenuItem("Cut");
		menuEdit.add(menuItemCut);
		
		JMenuItem menuItemCopy = new JMenuItem("Copy");
		menuEdit.add(menuItemCopy);
		
		JMenuItem menuItemPaste = new JMenuItem("Paste");
		menuEdit.add(menuItemPaste);
		
		JMenuItem menuItemDelete = new JMenuItem("Delete");
		menuEdit.add(menuItemDelete);
		
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
		
		JCheckBoxMenuItem chckbxMenuItemWordWrap = new JCheckBoxMenuItem("Word Wrap");
		menuFormat.add(chckbxMenuItemWordWrap);
		
		JMenuItem menuItemFont = new JMenuItem("Font...");
		menuFormat.add(menuItemFont);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(3, 23, 498, 617);
		frmTextEditor.getContentPane().add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
	}
}
