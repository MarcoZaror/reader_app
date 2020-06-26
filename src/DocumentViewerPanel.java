/** 
* DocumentViewerPanel.java
*
* Class containing the components of the main window and its functionality
* 
* @version 1.1  December 2019
* 
*/

import java.io.*;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.EmptyBorder;

public class DocumentViewerPanel extends JPanel implements ActionListener{

	private JButton loadButton, displayButton, statsButton;;
	private JTextField inputFile;
	private Document doc;
	private boolean loaded = false;
	private JPanel p_left, p_mid, p_right, p_top, p_bottom;
	private JLabel title, details,image2;


	public DocumentViewerPanel() {
		setBackground(new Color(0,0,0,0)); // Set it translucent
		//setBackground(Color.red);
		setLayout(new BorderLayout());
		
		// Top panel with a title
		p_top = new JPanel();
		p_top.setBackground(new Color(0,0,0,0));
		p_top.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
		title = new JLabel("Welcome to you reader app");
		title.setFont(new Font("Arial", Font.PLAIN, 24));
		title.setForeground(Color.black);
		p_top.add(title);
		ImageIcon image = new ImageIcon("book.png");
		JLabel image2 = new JLabel(image);
		p_top.add(image2);
		this.add(p_top, BorderLayout.NORTH);

		// Bottom panel with details
		p_bottom = new JPanel();
		p_bottom.setBackground(new Color(0,0,0,0));
		details = new JLabel("Software developed by Marco Zaror for COM6515.");
		p_bottom.add(details);
		this.add(p_bottom, BorderLayout.SOUTH);

		// Panel at the left with a load file button
		p_left = new JPanel();
		p_left.setBorder(BorderFactory.createEmptyBorder(30,5,5,5)); //top, left, bottom, right
		p_left.setBackground(new Color(0,0,0,0));
		inputFile = new JTextField(20);
		p_left.add(inputFile);
		loadButton = makeJButton("Load document",this); 
		p_left.add(loadButton);
		this.add(p_left, BorderLayout.WEST);

		// Panel at the center with a show document button
		p_mid = new JPanel();
		p_mid.setBorder(BorderFactory.createEmptyBorder(30,5,5,5));
		p_mid.setBackground(new Color(0,0,0,0));
		displayButton = makeJButton("Show document", this);
		p_mid.add(displayButton);
		this.add(p_mid, BorderLayout.CENTER);

		// Panel at the right with a show stats button
		p_right = new JPanel();
		p_right.setBorder(BorderFactory.createEmptyBorder(30,5,5,5));
		p_right.setBackground(new Color(0,0,0,0));
		statsButton = makeJButton("Show statistics", this);
		p_right.add(statsButton);
		this.add(p_right, BorderLayout.EAST);
        
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;

        int w = getWidth();
        int h = getHeight(); 
        GradientPaint gp = new GradientPaint(
                0, 0, Color.blue,
                0, h, Color.white);

        g2.setPaint(gp);
        g2.fillRect(0, 0, w, h);
	}

	// Method to create buttons
	private JButton makeJButton(String s, ActionListener a){
		JButton b = new JButton(s);
		b.addActionListener(a);
		return b;
	}
	public void actionPerformed(ActionEvent event) {
		Object source = event.getSource(); 
	// If loadButton is pressed, read the file and create a Document object with its information
	if (source == loadButton) {
		loaded = true;
		String file_name = inputFile.getText();
		DocumentLoader dv = new DocumentLoader();
		File file = new File(file_name);
		if (!file.exists()){
			JOptionPane.showMessageDialog(null, "We cannot find your file", "File not found", JOptionPane.WARNING_MESSAGE);	
			loaded = false;
		} else{
			JOptionPane.showMessageDialog(null, "Success! File correctly loaded", "File loaded", JOptionPane.INFORMATION_MESSAGE);
		}
		doc = dv.readDoc(file_name); //read the file and create a document object
			
	} else if (source == displayButton){
		// check that the file is loaded
		if (loaded == true){
			ArrayList<String> b = doc.getBody(); //Use the Document object method getBody to obtain the text
			JFrame frm = new TextContent(b); // Call the class TextContent to display the document
			frm.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
			frm.setVisible(true);		
		} else {
			JOptionPane.showMessageDialog(null, "You need to upload a file to display", "No file uploaded", JOptionPane.WARNING_MESSAGE);
	
		}
	// check that the file is loaded	
	} else if (source == statsButton){
		if (loaded == true){
			//Use the Document object methods getStats and getWordsInfo to obtain al the information about the text
			ArrayList<String> s = doc.getStats(); 
			ArrayList<String> wc = doc.getWordsInfo();
			// Combine both in one ArrayList to be displayed 
			ArrayList<String> st = new ArrayList<String>();
			st.addAll(s);
			st.addAll(wc);
			// Display the information calling the Stats class
			JFrame stats = new Stats(st); 
			stats.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
			stats.setVisible(true);		
		} else {
			JOptionPane.showMessageDialog(null, "You need to upload a file to show stats", "No file uploaded", JOptionPane.WARNING_MESSAGE);
		}
	} 
	}
}