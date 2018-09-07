package chapter2;

public class Heap {
public static void sort(Comparable[] a)
{
	int N=a.length;
	for(int k=N/2;k>=1;k--)
	{
		sink(a,k,N);
	}
	while(N>1)
	{
		exch(a,1,N--);
		sink(a,1,N);
	}
} 
private static void sink(Comparable[] pq,int k,int n)
{
	while(2*k<=n)
	{
		int j=2*k;
		if(j<n&&less(pq,j,j+1)) j++;
		if(!less(pq,k,j)) break;
		exch(pq,k,j);
		k=j;
	}
}
private static boolean less(Comparable[] pq, int i, int j) {
	return pq[i - 1].compareTo(pq[j - 1]) < 0;
}
private static void exch(Object[] pq, int i, int j) {
	Object swap = pq[i - 1];
	pq[i - 1] = pq[j - 1];
	pq[j - 1] = swap;
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer [] a={1,3,7,2,4,9,0,5,6,8};
		sort(a);
		for(int m=0;m<a.length;m++)
			System.out.print(a[m]+" ");
	}

}
