package algorithm;

import java.util.Scanner;

public class Main6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      int c =0;
      int number =1;
      Scanner in = new Scanner(System.in);
      int b= in.nextInt();
      while(true){
    	  if(number==1||number%2==0||number%3==0||number%5==0||(number%2)%3==0||(number%2)%5==0||(number%3)%5==0||((number%2)%3)%5==0){
    		  c++;
    		  if(c==b){
    			  number++;
    		  }
    			  System.out.println(number);
    	  }
      }
	}

}
