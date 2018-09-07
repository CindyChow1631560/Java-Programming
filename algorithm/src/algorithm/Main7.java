package algorithm;

import java.util.Scanner;

public class Main7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		Scanner line = new Scanner(System.in);
	      int n= in.nextInt();
	      for (int i=0;i<n;i++){
	    	  String str = line.nextLine();
	    	  String[] sque = str.trim().split(" "); 
	    	  int len=sque.length;
	    	  //long[] num =new long[(sque.length-1)*(sque.length-2)/2];//fenzi
	    	 // long[] den =new long[(sque.length-1)*(sque.length-2)/2];//fenmu
	    	 // double[] list = new double[num.length];
	    	  long k = Long.parseLong(sque[0]);
	    	  int count=1;
	    	  if(k==1){
	    		  System.out.println(sque[1]+" "+sque[len-1]);
	    	  }
	    	  else{
	    		  for(int l=len-1;l>2;l++){
	    			  double b=Long.parseLong(sque[l])/Long.parseLong(sque[l-1]);
	    			  for(int j=2;Long.parseLong(sque[j])<b;j++){
	    				  count++;
	    				  if(count==k){
	    					  System.out.println(sque[j]+" "+sque[l]);
	    				  }
	    			  }
	    			  count++;
	    			  if(count==k){ 
	    				  System.out.println(sque[1]+" "+sque[l-1]);
	    				  break;
	    			  }
	    		  }
	    	  }
	  
	    
	      }
		
	}

}
