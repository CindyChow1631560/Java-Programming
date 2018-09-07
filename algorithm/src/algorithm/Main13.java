package algorithm;

import java.util.Scanner;
import java.util.*;
public class Main13 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		
		int[][] xy =new int[n][2];
		String[] str = new String[n];
		for(int i=0;i<n;i++){
			Scanner in2 = new Scanner(System.in);
			str[i] = in2.nextLine();//ÊäÈëÒ»ÐÐ×Ö·û´®
		}
		for(int i=0;i<n;i++){
			String[] c = str[i].trim().split(" ");
			xy[i][0]= Integer.parseInt(c[0]);
			xy[i][1]= Integer.parseInt(c[1]);
		}
		
		int a=0,b=0,sum=0;
		for(int i=0;i<n;i++){
			a+=xy[i][0];
			int res=sum;
			sum+=xy[i][1];
			for(int j=0;j<n;){
			  if(j!=i){
				if(b!=a){
					b+=xy[j][0];
					sum+=xy[j][1];
					j++;
					if (j==n-1)
						break;
				}	
			  }
			}
			sum=Math.max(res, sum);
		}
	}

}
