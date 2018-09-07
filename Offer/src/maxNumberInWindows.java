import java.util.*;
public class maxNumberInWindows {
	 public ArrayList<Integer> maxInWindows(int [] num, int size)
	    {
	        ArrayList<Integer> result = new ArrayList<>();
	        if(num==null)
	        	return result;
	        if(size<1||num.length<size)
	        	return result;
	        ArrayDeque<Integer> q = new ArrayDeque<>();
	        for(int i=0;i<size-1;i++){
	        	while(!q.isEmpty()&&num[i]>num[q.getLast()]){
	        		q.removeLast();
	        	}
	        	q.add(i);
	        }
	        for(int i=size-1;i<num.length;i++){
	        	while(!q.isEmpty()&&num[i]>num[q.getLast()]){
	        		q.removeLast();
	        	}
	        	q.add(i);
	        	if(i-q.getFirst()+1>size){
	        		q.removeFirst();
	        	}
	        	result.add(num[q.getFirst()]);
	        }
	     return result;   
	    }
}
