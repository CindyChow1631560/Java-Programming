import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Comparator;
public class GetLeastKNumbers {
	 public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
		 ArrayList<Integer> result = new ArrayList<Integer>();
	        if(input.length==0||input.length<k)
	        	return result;
	        PriorityQueue<Integer> maxHeap  = new PriorityQueue<Integer>(k,new Comparator<Integer>(){
	        	public int compare(Integer o1, Integer o2){
	        		return o2.compareTo(o1);
	        	}
	        });
	        
	        for(int i=0;i<input.length;i++){
	        	if(maxHeap.size()<=k){
	        		maxHeap.offer(input[i]);
	        	}else if(maxHeap.peek()>input[i]){
	        		Integer temp = maxHeap.poll();
	        		temp=null;
	        		maxHeap.offer(input[i]);
	        	}
	        }
	        for(Integer i:maxHeap){
	        	result.add(i);
	        }
	        return result;
	    }
}
