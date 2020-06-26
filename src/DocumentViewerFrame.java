/** 
* DocumentViewerFrame.java
*
* This class contains the main frame of the application.
* 
* @version 1.1  December 2019
* 
*/

import javax.swing.*;
import java.awt.*;

public class DocumentViewerFrame extends JFrame  {
	
	// Set the main features and call the class DocumentViewerPanel, which extends JPanel
	public DocumentViewerFrame(){
		setTitle(" reader app for COM6515 ");
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		double width=screenSize.getWidth();
		double height=screenSize.getHeight();
		int x = 700;
		int y = 300;
		// Set a size relevant to the task 
		setBounds((int) (width/2 - x/2), (int) (height/2  - y/2), x, y); 
		Container contentPane = this.getContentPane();
		DocumentViewerPanel generalPanel = new DocumentViewerPanel();
		contentPane.add(generalPanel);
	}
}
