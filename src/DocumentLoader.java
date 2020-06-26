/** 
* DocumentLoader.java
*
* Class to read documents and create Novel, Poem or Play objects depending on the document's content
* Provides a principal method to load the document(considering its internal structure) and classify it into Poem, Play or Novel
*
* @version 1.1  December 2019
* 
*/

import java.util.*;
import java.io.*;

public class DocumentLoader {
	
	//Method to read a file and classify it into Poem, Play or Novel
	public Document readDoc( String doc_name){
		
		Document p = null;
		String doc_type,title,author;
		String line;
		Scanner file = null;
		
		try {
			file = new Scanner(new File (doc_name), "UTF-8");
			
			// Read and store first 3 lines, they are the same for all documents
			doc_type = getStringAfterDots(file.nextLine());
			title = getStringAfterDots(file.nextLine());
			author = getStringAfterDots(file.nextLine());
			
			//Depending on type of document, load the values and create the object
			if (doc_type.equals("Poem")){

				// Read and store specific data of Poem
				String numVerses = getStringAfterDots(file.nextLine());
				int numVerses_int = Integer.parseInt(numVerses);
				String year = getStringAfterDots(file.nextLine());
				int year_int = Integer.parseInt(year);
				
				ArrayList<String> body = new ArrayList<String>();
				file.nextLine(); // Skip two first lines (Blank line and "Text:")
				file.nextLine();
				while (file.hasNextLine()){
					line = file.nextLine();
					body.add(line);
				}
				// Finally, create the subclass object
				p = new Poem(doc_type,title,author,body, numVerses_int, year_int);
			} else if (doc_type.equals("Novel")){

				// Read and store specific data of Novel
				String numChapters = getStringAfterDots(file.nextLine());
				int numChapters_int = Integer.parseInt(numChapters);
				String year = getStringAfterDots(file.nextLine());
				int year_int = Integer.parseInt(year);

				ArrayList<String> body = new ArrayList<String>();
				file.nextLine(); // Skip two first lines (Blank line and "Text:")
				file.nextLine();
				while (file.hasNextLine()){
					line = file.nextLine();
					body.add(line);
				}
				// Finally, create the subclass object
				p = new Novel(doc_type,title,author,body, numChapters_int, year_int);

			} else if (doc_type.equals("Play")){

				// Read and store specific data of Play
				String numActs = getStringAfterDots(file.nextLine());
				int numActs_int = Integer.parseInt(numActs);
				String numActors = getStringAfterDots(file.nextLine());
				int numActors_int = Integer.parseInt(numActors);
				String year = getStringAfterDots(file.nextLine());
				int year_int = Integer.parseInt(year);

				ArrayList<String> body = new ArrayList<String>();
				file.nextLine(); // Skip two first lines (Blank line and "Text:")
				file.nextLine();
				while (file.hasNextLine()){
					line = file.nextLine();
					body.add(line);
				}
				// Finally, create the subclass object
				p = new Play(doc_type,title,author,body, numActs_int,numActors_int, year_int);
			}
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		finally{
			file.close();
		}
	return p;
	}

	// Method to extract only the part after the ":"
	public String getStringAfterDots(String text){
		StringTokenizer st;
		st = new StringTokenizer(text,":");
		//Get the string before and after the colon
		String before_c = st.nextToken();
		String after_c = st.nextToken();

	return after_c.strip();
	}
}