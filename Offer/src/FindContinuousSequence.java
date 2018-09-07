import java.util.ArrayList;
public class FindContinuousSequence {
	public static void main(String[] args){
		int sum=100;
		ArrayList<ArrayList<Integer> > result = FindContinuousSequenceMain(sum);
		for(int i=0;i<result.size();i++){
			System.out.println(result.get(i).toString());
		}
	}
	 public static ArrayList<ArrayList<Integer> > FindContinuousSequenceMain(int sum) {
	       int small =1;
	       int big = 2;
	       int end = (sum+1)/2;
	       //int cursum=small+big;
	       ArrayList<ArrayList<Integer>> res = new ArrayList<>();
	       
        while(small<big){
        	int cursum = (small+big)*(big-small+1)/2;
        	if(cursum==sum){
        		ArrayList<Integer> temp = new ArrayList<>();
        	  for(int i=small;i<=big;i++){
  	    		   temp.add(i);
  	    	   }
  	    	   res.add(temp);
  	    	   big++;
        	}else if(cursum>sum){
                small++;
	       }else{

	    	   big++;
	       }
        }
	       return res;
	 }
}
