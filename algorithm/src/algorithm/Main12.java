package algorithm;
import java.util.*;
public class Main12 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=0;
		int k=0;
		 Scanner in = new Scanner(System.in);
		 String str =in.nextLine();
		 String[] input=str.trim().split(" ");
		 n=Integer.parseInt(input[0]);
		 k=Integer.parseInt(input[1]);
	        int[] inter=new int[n];
		    int[] awake=new int[n];
	        for(int i=0;i<n;i++){
	        	inter[i]=in.nextInt();
		        awake[i]=in.nextInt();
	        }
	        
	        int total_tmp=0;
	        int total_interest = 0;
	        for (int i = 0; i < n - k; i ++)
	        {
	            total_tmp = 0;
	            for (int j = 0; j < k; j ++)
	            {
	                total_tmp += inter[i + j];
	            }
	            int backward_i = i - 1;
	            while ((awake[backward_i]>=0) && backward_i >= 0)
	            {
	                total_tmp += inter[backward_i];
	                backward_i --;
	            }
	            if (total_tmp > total_interest) total_interest = total_tmp;
	        }
	        System.out.println(total_tmp);
	}

}
