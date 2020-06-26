
/** 
* Novel.java
*
* Subclass of Document, representing Novel documents
* 
* @version 1.1  December 2019
* 
*/

import java.util.ArrayList;

public class Novel extends Document {
	
	// Declare instance fields
    private int numChapters;
    private int year;

    // Call Document constructor and add two specific attributes for this class
	public Novel( String d, String t, String a, ArrayList<String> b, int c, int y){
		super(d, t, a, b);
		numChapters = c;
		year = y;
	}
	
	// Override getStats method to add more information
	@Override
	public ArrayList<String> getStats(){
		ArrayList<String> stats_p = new ArrayList<String>();
		stats_p.add("Document Type: " + super.getDocType());
		stats_p.add("Title: " + super.getTitle());
		stats_p.add("Author: " + super.getAuthor());
		stats_p.add("Number of Chapters: " + this.numChapters);
		stats_p.add("Year: " + this.year);
		return stats_p;
	}

	// Create accessing methods
	public Integer getNumChapters() { return numChapters; }
	public Integer getYear() { return year; }

}
