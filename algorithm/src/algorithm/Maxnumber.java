package algorithm;

import java.util.*;
public class Maxnumber
    {
    public static void main(String[] args)
        {
        Scanner in=new Scanner(System.in);
        while(in.hasNext()){
            int n= in.nextInt();
            int[] list= new int[n];
            for (int i=0;i<n;i++)
                list[i]=in.nextInt();
            list=order(list);
            for(int i=0;i<n;i++)
               System.out.print(list[i]);
            System.out.println();
        }
    }

	private static int[] order(int[] number) {
		// TODO Auto-generated method stub
		 for(int i=0;i<number.length;i++)
             for(int j=i+1;j<number.length;j++)
                 {
                 if(number[i]<number[j])
                     {
                     int m=number[i];
                     number[i]=number[j];
                     number[j]=m;
                 }
             }
         return number;
	}
}