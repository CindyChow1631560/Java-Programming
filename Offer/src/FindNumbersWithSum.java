import java.util.ArrayList;
public class FindNumbersWithSum {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] test={1,3,4,5,6,7,8,9,10};
		int sum=9;
		ArrayList result = FindNumbersWithSumMain(test,sum);
		System.out.println(result.toString());

	}
    public static ArrayList<Integer> FindNumbersWithSumMain(int [] array,int sum) {
    	ArrayList<Integer> result = new ArrayList<>();
    	
    	int start = 0;
    	int end = array.length-1;
    	while(start<end){
        int cursum = array[start]+array[end];
    	if(cursum==sum){
    			int res1=array[start];
        		int res2 =array[end];
        		result.add(res1);
        		result.add(res2);
        		break;
    		
    	}
    	if(cursum<sum){
    		start++;
    	}
    	if(cursum>sum){
    		end--;
    	}
    	
    }
    	return result;
    }

}
