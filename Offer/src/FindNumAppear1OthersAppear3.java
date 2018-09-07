
import java.util.*;
public class FindNumAppear1OthersAppear3 {
	public static void main(String[] args){
		int[] test = {1,2,1,1,3,3,3};
		int result=find1From3(test);
		System.out.println(result);
		
	}
		public static int find1From3(int[] a){
			   int result=0; 
		       int[] bits = new int[32];
		       for(int i=0;i<32;i++){
		    	   for(int j=0;j<a.length;j++){
		    		   bits[i] = bits[i]+(a[j] & (1<<i));
		    	   }
		       }
		       for(int i=0;i<32;i++){
		    	   if(bits[i]%3!=0){
		    		   result = result | (1<<i);
		    	   }
		       }
		       return result;
		}
}
