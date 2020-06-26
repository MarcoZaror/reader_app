/** 
* Poem.java
*
* Subclass of Document, representing Poem documents
* 
* @version 1.1  December 2019
* 
*/

import java.util.ArrayList;

public class Poem extends Document {
	
	// Declare instance fields
    private int numVerses;
    private int year;
    
    // Call Document constructor and add two specific attributes for this class
	public Poem( String d, String t, String a, ArrayList<String> b, int v, int y){
		super(d, t, a, b);
		this.numVerses = v;
		this.year = y;
	}

	// Override getStats method to add more information
	@Override
	public ArrayList<String> getStats(){
		ArrayList<String> stats_p = new ArrayList<String>();
		stats_p.add("Document Type: " + super.getDocType());
		stats_p.add("Title: " + super.getTitle());
		stats_p.add("Author: " + super.getAuthor());
		stats_p.add("Number of verses: " + this.numVerses);
		stats_p.add("Year: " + this.year);
		return stats_p;
	}
	
	// Create accessing methods
	public int getNumVerses(){ return numVerses;}
	public int getYear(){ return year;}

}
