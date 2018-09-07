
public class GetNumberOfK {
	public static void main(String[] args){
		int[] test = {1,2,3,4,4,4,5,6};
		int num = GetNumberOfKMain(test,4);
		System.out.println(num);
	}
	 public static int GetNumberOfKMain(int [] array , int k) {
	       int len = array.length;
	       int result=0;
	        if(len==0){
	            return 0;
	        }
	       // int mid = array.length/2;
	        int first = getFirstK(array,k,0,len-1);
	        int last =  getLastK(array,k,0,len-1);
	        if(first!=-1&&last!=-1){
	            result= last-first+1;
	        }
	        return result;
	    }
	    public static int getFirstK(int[] array, int k, int start, int end){
	        if(end<start){
	        	return -1;
	        }
	        int firstPosition=0;
	        int mid = start+(end-start)/2;
	        if(array[mid]>k){
	        	firstPosition = getFirstK(array, k, start, mid-1);
	        }
	        else if(array[mid]<k){
	        	firstPosition = getFirstK(array,k,mid+1,end);
	        }else if(mid-1>=0&&array[mid-1]==k){
	        	firstPosition = getFirstK(array,k,start,mid-1);
	        }else{
	        	firstPosition = mid;
	        	}
	       return firstPosition;
	    }
	    public static int getLastK(int[] array, int k, int start, int end){
	    	if(end<start){
	        	return -1;
	        }
	    	 int lastPosition=0;
	    	 int mid = start+(end-start)/2;
	    	 if(array[mid]>k){
		        	lastPosition = getLastK(array, k, start, mid-1);
		        }
		        else if(array[mid]<k){
		        	lastPosition = getLastK(array,k,mid+1,end);
		        }else if(mid+1<=array.length-1&&array[mid+1]==k){
		        	lastPosition = getLastK(array,k,mid+1,end);
		        }else{
		        	lastPosition = mid;
		        	}
		       return lastPosition;
	    }
}
