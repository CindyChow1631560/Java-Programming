package algorithm;

import java.util.Scanner;

public class Main5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      int a;
      Scanner in = new Scanner(System.in);
      int b= in.nextInt();
      a = Math.abs(b);
      System.out.println(walk(a));
	}
	static int walk(int n){
		if(n<=1)
			return 1;
		else{
			if(n%2==0)
				return walk(n/2)+1;
			else
				return walk(n-1)+1;
		}
	}

}
