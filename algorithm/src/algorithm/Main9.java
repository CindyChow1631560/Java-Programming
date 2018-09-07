package algorithm;
import java.util.ArrayList;

import java.util.Scanner;
public class Main9 {
	public static void mian(String[] args){
		ArrayList<Integer> array  = new ArrayList<>();
	Scanner sc = new Scanner(System.in);
	int n = sc.nextInt();
	for(int i=0;i<n;i++){
		int k = sc.nextInt();
		if(k==1){
			System.out.println(2);
		    continue;
		}
		QQ:
		for(int j=2;j<=100000;j++){
			for(int m=2;m<j;m++){
				if(j%m==0)
					break QQ;
				else
					array.add(j);
			}
		}
		System.out.println(array.get(k-1));
	}
	}

}
