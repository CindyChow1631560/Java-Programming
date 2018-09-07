import java.util.*;
public class AddingGroups {
public static void main(String[] args){
	Collection<Integer> collection=new ArrayList<Integer>(Arrays.asList(1,2,3,4,5));
	Integer[] moreints={6,7,8,9};
	collection.addAll(Arrays.asList(moreints));
	Collections.addAll(collection, moreints);
	List<Integer> list=Arrays.asList(16,17,18,19);
	List<Integer> list2=new ArrayList<Integer>(Arrays.asList(16,17,18,19));
	list.set(1,45);
	list2.set(3,12);
	for(Integer c:collection)
		System.out.print(c+" ");
		System.out.println();
	
	for(Integer a:list)
		System.out.print(a+" ");
		System.out.println();
	
	for(Integer a2:list2)
		System.out.print(a2+" ");
		System.out.println();
	
		
	
}
}
