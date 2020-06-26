/** 
* Document.java
*
* Document parent class representing all three types of documents.
* Provides methods to obtain stats of the document, to count its words and to acces its instance fields.
* 
* @version 1.1  December 2019
* 
*/

import java.util.*;

public class Document {
	
	// Declare instance fields
	private String doc_type;
	private String title; 
	private String author;
	private ArrayList<String> body;
			
	//Two constructors to allow	creation of a Document object without arguments (to be filled later)
	public Document(){
		this.doc_type = "default";
		this.title = "default";
		this.author = "default";
		this.body = new ArrayList<String>();
	}
	
	public Document( String d, String t, String a, ArrayList<String> b){
		this.doc_type = d;
		this.title = t;
		this.author = a;
		this.body = b;
	}

	// Method to provide stats of the document, will be override by each subclass adding its particular information
	public ArrayList<String> getStats(){
		ArrayList<String> stats = new ArrayList<String>();
		stats.add("Document Type: " + this.doc_type);
		stats.add("Title: " + this.title);
		stats.add("Author: " + this.author);
		return stats;
	}

	// Method to obtain info about words (count and frequency)
	public ArrayList<String> getWordsInfo(){
		List<String> words = new LinkedList<String>();
		String wd;
		StringTokenizer st;

		// Split sentences into tokens, add to LinkedList and sorted
        for (String line : body){
        	// Only the space and punctuation signs were defined as a separators 
        	st = new StringTokenizer(line," .,:?;[]()");  
			while (st.hasMoreTokens()) {
				wd = st.nextToken();
				words.add(wd);
			}
        }
		Collections.sort(words, String.CASE_INSENSITIVE_ORDER); 
		
		//Create a HashMap to store pairs <word, count>
		HashMap<String, Integer> pair = new HashMap<String, Integer>();
		
		// Count words and store it in the HashMap
		String previous = null;
		String current;
		int counter = 0;
		Iterator<String> i1 = words.iterator();
		while (i1.hasNext()) {
			current = i1.next();
			if (current.equalsIgnoreCase(previous)) {
				counter +=1;
			} else {
				if (previous != null) {
					pair.put(previous,counter);
				}
				previous = current;
				counter = 1;
			}
		}

		// Create a TreeMap with a pre-defined comparator to compare words by its count
		Comparator<String> comparator = new CompareCounts(pair);
		TreeMap<String, Integer> pairs = new TreeMap<String, Integer>(comparator);
		pairs.putAll(pair);
		// Store 10 most frequent words with its values in an ArrayList
		ArrayList<String> wds = new ArrayList<String>();
		wds.addAll(pairs.keySet());
		ArrayList<Integer> val = new ArrayList<Integer>();
		val.addAll(pairs.values());
		// Obtain number of total words in the document 
		int wordsTotal = 1; //Start with 1 to add the count of the initial word 'Text:', because it is not in the body
		for (int values: val){
			wordsTotal += values;
		}
		// Put all the information in an ArrayList
		ArrayList<String> wordCount = new ArrayList<String>();
		String wordsTotal_str = String.valueOf(wordsTotal); 
		wordCount.add("Total number of words in document: " + wordsTotal_str);
		wordCount.add("\n");
        wordCount.add("10 most frequent words");
		for (int a = 0; a < 11; a++){
			String v = String.valueOf(val.get(a));
			wordCount.add("Word: " +"'" +wds.get(a)+"'" + ",  freq: " + v);
		}
	return wordCount;
	}
	
	// Create accessing methods
	public String getDocType(){ return doc_type;}
	public String getTitle() { return title; }
	public String getAuthor() { return author; }
	public ArrayList<String> getBody(){return body;}

}


