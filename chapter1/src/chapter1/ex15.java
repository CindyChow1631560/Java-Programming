package chapter1;

public class ex15 {
public static int[] histogram(int a[],int M)
{
	int[] denote=new int[M];
	int count=0;
	for(int i=0;i<a.length;i++)
		{
			if (a[i]>=0&&a[i]<M)
			denote[a[i]]++;
		}
	return denote;
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
int[] test={1,2,3,1,4,6,7,2,4,8,9,1,8,1,9,0,5,2};
int result[]=histogram(test,10);
for (int i = 0; i < result.length; i++) 
	System.out.printf("%3d", result[i]);
	}

}
