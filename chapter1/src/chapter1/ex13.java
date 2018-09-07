package chapter1;
import java.util.*;
public class ex13 {
/*	public static int[][] trance(int a[][])
	{
		int k=a.length;
		int m=a[0].length;
		int[][] b=new int[k][m];
		for(int j=0;j<a[0].length;j++)
		for(int i=0;i<a.length;i++)	
			{
				b[i][j]=a[j][i];
			}
		return b;
	}*/
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*int[][] test=new int[5][5];
		Random random=new Random();
for(int k=0;k<5;k++)
	for(int m=0;m<5;m++)
	{
		test[k][m]=random.nextInt(10);
	}*/
		int[][] test={{1,2,3,4,5},{3,6,7,8,3},{6,7,8,9,1},{3,1,5,7,9},{2,4,3,8,0}};
for(int k=0;k<5;k++)
{
	for(int m=0;m<5;m++)
	{
		System.out.print(test[k][m]+" ");
	}
System.out.println();
}
	
//test=trance(test);
System.out.println();
for(int k=0;k<5;k++)
{
	for(int m=0;m<5;m++)
	{
 		System.out.print(test[m][k]+" ");
	}
System.out.println();
}
	}

}
