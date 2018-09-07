package algorithm;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class Main4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Scanner in = new Scanner(System.in);
		 
		 String str = in.nextLine();
		 String[] c = str.split(" ");
		 int sum=0;
	        for(int i=1;i<c.length;i++){
		        sum = sum+Integer.parseInt(c[i]);
		        }
		        int sumObj = (1+Integer.parseInt(c[0]))*Integer.parseInt(c[0])/2;
		        int b= sumObj-sum;
		        System.out.println(b);	
	        
	}

}
