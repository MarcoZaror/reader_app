/** 
* Play.java
*
* Subclass of Document, representing Play documents
* 
* @version 1.1  December 2019
* 
*/
import java.util.ArrayList;

public class Play extends Document {
	
	// Declare instance fields
    private int numActs;
    private int numActors;
    private int year;

    // Call Document constructor and add three specific attributes for this class
	public Play( String d, String t, String a, ArrayList<String> b, int ac, int acs, int y){
		super(d, t, a, b);
		numActs = ac;
		numActors = acs;
		year = y;
	}

	// Override getStats method to add more information
	@Override
	public ArrayList<String> getStats(){
		ArrayList<String> stats_p = new ArrayList<String>();
		stats_p.add("Document Type: " + super.getDocType());
		stats_p.add("Title: " + super.getTitle());
		stats_p.add("Author: " + super.getAuthor());
		stats_p.add("Number of Acts: " + this.numActs);
		stats_p.add("Number of Actors: " + this.numActors);
		stats_p.add("Year: " + this.year);
		return stats_p;
	}
	
	// Create accessing methods
	public Integer getNumActs() { return numActs; }
	public Integer getNumActors() { return numActors; }
	public Integer getYear() { return year; }

}