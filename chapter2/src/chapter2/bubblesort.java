package chapter2;

public class bubblesort {
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
		int N=a.length;
		for(int j=N;j>0;j--)
		{
			for(int i=0;i<N-1;i++)
				if(!less(a[i],a[i+1]))
					exch(a,i,i+1);
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
