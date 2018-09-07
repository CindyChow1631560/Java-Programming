import java.util.PriorityQueue;
import java.util.Comparator;
public class GetMedianFromStream {
	PriorityQueue<Integer> minHeap =new PriorityQueue<Integer>();
	PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(11, new Comparator<Integer>(){
		public int compare(Integer o1,Integer o2){
			return o2.compareTo(o1);
		}
	});
	int count=0;
	public void Insert(Integer num) {
		count++;
		if((count & 1)==0){//count is even
			if(!maxHeap.isEmpty() && num<maxHeap.peek()){
				maxHeap.offer(num);
				num=maxHeap.poll();
			}
			minHeap.add(num);
		}else{
			if(!minHeap.isEmpty() && num>minHeap.peek()){
				minHeap.offer(num);
				num=minHeap.poll();
			}
			maxHeap.add(num);
		}
	    
    }

    public Double GetMedian() {
    	double result;
        if((count & 1)==1){
        	result = maxHeap.peek();
        }else{
        	result = (maxHeap.peek()+minHeap.peek())/2.0;
        }
        return result;
    }
}
