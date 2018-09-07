package chapter2;
import java.math.*;
public class MergeBu {
	private static Comparable[] aux;
public static void sort(Comparable[] a)
{
	int N=a.length;
	aux=new Comparable[N];
	for(int sz=1;sz<N;sz=sz+sz)
	
		for(int lo=0;lo<N-sz;lo+=sz+sz)
		{
			merge(a,lo,lo+sz-1,Math.min(sz+sz+lo-1, N-1));
		}
	
}
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
public static void merge(Comparable[] a,int lo,int mid,int hi)
{
int i=lo,j=mid +1;
//int N=a.length;
//Comparable aux[]=new Comparable[N];
for(int k=lo;k<=hi;k++)
{
	aux[k]=a[k];
}
for(int k=lo;k<=hi;k++)
{
	if(i>mid) a[k]=aux[j++];
	else if(j>hi) a[k]=aux[i++];
	else if(less(aux[j],aux[i])) a[k]=aux[j++];
	else a[k]=aux[i++];
}
}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer [] a={1,3,7,2,4,9,0,5,6,8};
		sort(a);
		for(int m=0;m<a.length;m++)
			System.out.print(a[m]+" ");
	
	}

}
