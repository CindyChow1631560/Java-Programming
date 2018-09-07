package chapter2;
import java.util.*;
public class select_order {
	private static boolean less(Comparable v,Comparable w)
	{
		return v.compareTo(w)<0;
	}
	private static void exch(Comparable[] a, int i, int j)
	{
		Comparable t=a[i];
		a[i]=a[j];
		a[j]=t;
	}
public static void sort(Comparable[] a)
{
	int n=a.length;
	for(int i=0;i<n;i++){
		int min=i;
		for(int j=i+1;j<n;j++)
		{
			if(less(a[j],a[min])) min=j;
			
		}
		exch(a,i,min);
	}
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
Comparable [] a={1,3,7,2,4,9,0,5,6,8};
sort(a);
for(int m=0;m<a.length;m++)
	System.out.print(a[m]+" ");
	}

}
