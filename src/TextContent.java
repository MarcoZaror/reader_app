/** 
* TextContent.java
*
* Class to show the text of each document in a pop up window
* 
* @version 1.1 December 2019
* 
*/

import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TextContent extends JFrame {
	
	// Declare instance fields
	private JTextArea textArea;
	private JScrollPane paneScrollPane;
	private JPanel bottom;
	private JButton goback;
	private JScrollPane scrollPane;
	private Dimension screenSize;
	private double width, height;

	public TextContent(ArrayList<String> text){

		// set initial configurations for the frame
		setTitle("Enjoy your text!");
		screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		width=screenSize.getWidth();
		height=screenSize.getHeight();
		int x = 500;
		int y = 600;
		setBounds((int) (width/2 - x/2), (int) (height/2  - y/2), x, y);

		// Display the text and add an scrollPane
		Container contentPane = this.getContentPane();
        textArea = new JTextArea(5, 50);
        for (String line : text){
			textArea.append(line + "\n");
		}
        textArea.setEditable(false);
        scrollPane = new JScrollPane(textArea);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        textArea.setCaretPosition(0);
        contentPane.add(scrollPane, BorderLayout.CENTER);

        // Add a new panel at the bottom with a return button (just to improve usability)
        bottom = new JPanel();
        bottom.setBackground(Color.white);
        goback = new JButton("Return");
        goback.setSize(50,50);
        popUpAction rturn = new popUpAction();
        goback.addActionListener(rturn);
        bottom.add(goback);
        contentPane.add(bottom, BorderLayout.SOUTH);

	}
	
	//Create an inner class implementing ActionListener, because the button only applies over this windows
	private class popUpAction implements ActionListener{

		public void actionPerformed(ActionEvent event) {
			Object source = event.getSource(); 
			if (source == goback) {
			dispose();
			}
		}		
	}

}
