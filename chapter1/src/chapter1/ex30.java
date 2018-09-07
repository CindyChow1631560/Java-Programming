package chapter1;

public class ex30 {
public static int gcd(int p,int q)
{
	if(q==0)
		return p;
	else
	{
		int r=p%q;
		p=q;
		q=r;
		return gcd(p,q);
	}
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
 boolean a[][]=new boolean[5][5];
 for(int i=0;i<5;i++)
	 for(int j=0;j<5;j++)
	 {
		 a[i][j]=gcd(i,j)==1;
		 System.out.println(a[i][j]);
	 }
	}

}
