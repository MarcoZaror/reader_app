/** 
* CompareCounts.java
*
* Class that allows to compare count of words (so the most frequent words can be selected) 
*
* @version 1.1  December 2019
* 
*/

import java.util.*;

class CompareCounts implements Comparator<String>{
 
	HashMap<String, Integer> map = new HashMap<String, Integer>();
 
	public CompareCounts(HashMap<String, Integer> map){
		this.map.putAll(map);
	}
 
 	// Do the comparison using the values and not the keys
	@Override
	public int compare(String s1, String s2) {
		if(map.get(s1) >= map.get(s2)){
			return -1;
		}else{
			return 1;
		}	
	}
}
