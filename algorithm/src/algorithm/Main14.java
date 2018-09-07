package algorithm;

import java.util.Scanner;

public class Main14 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		Scanner in2 = new Scanner(System.in);
		int n = in.nextInt();
		int[] a = new int[n];
		int[] b = new int[n];
		String str1 = in2.nextLine();
		String str2 = in2.nextLine();
		String[] a1 = str1.trim().split(" ");
		String[] b1 =str2.trim().split(" ");
		for(int i=0;i<n;i++){
			a[i]=Integer.parseInt(a1[i]);
			b[i]=Integer.parseInt(b1[i]);
		}
		int count=0;
		for(int i=0;i<n;i++){
			for(int j=i;j<n;j++){
				if(Getmax(a,i,j)<Getmin(b,i,j)){
					count++;
				}
			}
		}
		System.out.println(count);
	}
	
	static int Getmax(int[] a,int i, int j){
		int max=a[i];
		for(int m=i;m<=j;m++){
			if(a[m]>max)
				max=a[m];
	}
		return max;
	}
	static int Getmin(int[] a,int i, int j){
		int min=a[i];
		for(int m=i;m<=j;m++){
				if(a[m]<min)
					min=a[m];
		}
		return min;
	}
}
