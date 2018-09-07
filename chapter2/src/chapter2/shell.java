package chapter2;

public class shell {
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
		int h=1;
		while(h<N/5)h=h*5+1;
		while(h>=1)
		{
			for(int i=h;i<N;i++)
				for(int j=i;j>=h&&less(a[j-h],a[j]);j-=h)//½µÐò
					exch(a,j,j-h);
			h=h/5;
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
