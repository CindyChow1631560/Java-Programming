package algorithm;

import java.util.Collections;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
public class Main17 {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		 String str = in.nextLine();//ÊäÈëÒ»ĞĞ×Ö·û´®
		 //str=str.trim();
		 String[] c = str.trim().split(" ");
		 int[] p =new int[c.length];
		 for(int i=0;i<c.length;i++){
			 p[i]=Integer.parseInt(c[i]);
	}
		 int n= in.nextInt();
		 List<Integer> cp = new ArrayList<Integer>();
		 for(int cc : p){
			 cp.add(cc);
		 }
		 Collections.sort(cp);
		 int min= cp.get(0);
		 int max =cp.get(cp.size()-1);
		// System.out.println(min);
		 List<Integer> record = new ArrayList<Integer>();
		 for (int i=min;i<=max;i++){
			 int sum=0;
			 for(int j=0;j<p.length;j++){
				 
					 sum+=Math.ceil((float)p[j]/i); 
				// System.out.println(i+":"+(float)p[j]/i+1);
				// System.out.println(i+"ceil: "+Math.ceil((float)p[j]/i));
			 }
			 if(sum<=n){
				 record.add(i);
			 }
		 }
		 Collections.sort(record);
		// System.out.println(record);
		 System.out.println(record.get(0));
		 
}
}
