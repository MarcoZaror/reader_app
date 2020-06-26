/** 
* DocumentViewer.java
*
* Class containing the main method to start the application
* 
* @version 1.1  December 2019
* 
*/

import javax.swing.*;

public class DocumentViewer extends JFrame  {
	
	public static void main(String args[]) { 

		JFrame frm = new DocumentViewerFrame();
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frm.setResizable(false);
		frm.setVisible(true);
	}
}