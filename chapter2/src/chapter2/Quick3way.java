package chapter2;

public class Quick3way {
	private static void exch(Comparable[] a, int i, int j)
	{
		Comparable t=a[i];
		a[i]=a[j];
		a[j]=t;
	}
public static void sort(Comparable[] a)
{
	sort(a,0,a.length-1);
}
public static void sort(Comparable[] a, int lo,int hi)
{
	if(hi<=lo) return;
	int it=lo,gt=hi,i=lo+1;
	Comparable v=a[lo];
	
	while(i<=gt)
	{
	int cmp=a[i].compareTo(v);
	if(cmp<0) exch(a,it++,i++);
	else if(cmp>0) exch(a,i,gt--);
	else i++;
	}
	sort(a,lo,it-1);
	sort(a,gt+1,hi);
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer [] a={1,3,7,2,4,9,0,5,6,8};
		sort(a);
		for(int m=0;m<a.length;m++)
			System.out.print(a[m]+" ");
	}

}
