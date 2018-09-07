import java.util.*;
public class tt {
		// TODO Auto-generated method stu
			 private static void sortMapByValues(Map<String, Integer> aMap){
				 Set<Map.Entry<String,Integer>> mapEntries = aMap.entrySet();
			     System.out.println("Values and Keys before sorting "); 
			     for(Map.Entry<String,Integer> entry : mapEntries)
			    	 System.out.println(entry.getKey() + " - "+ entry.getValue()); 
			     //use LinkedList to sort, because insertion of elements in linked list is faster than ArrayList. 
			     List<Map.Entry<String,Integer>> aList = new LinkedList<Map.Entry<String,Integer>>(mapEntries); 
			     // sorting the List 
			     Collections.sort(aList, new Comparator<Map.Entry<String,Integer>>(){
			    	 @Override 
			         public int compare(Map.Entry<String, Integer> ele1, Map.Entry<String, Integer> ele2){
			    		 return ele1.getValue().compareTo(ele2.getValue()); 
			        }
			     }); 
			     // Storing the list into Linked HashMap to preserve the order of insertion. 
			     Map<String,Integer> aMap2 = new LinkedHashMap<String, Integer>();
			     for(Map.Entry<String,Integer> entry: aList){
			    	 aMap2.put(entry.getKey(), entry.getValue()); 
			     } 
			     // printing values after sorting of map 
			     System.out.println("Values and Keys after sorting "); 
			     for(Map.Entry<String,Integer> entry : aMap2.entrySet()){
			    	 System.out.println(entry.getKey() + " - " + entry.getValue()); 
			     } 
			} 
			
		


	

}
