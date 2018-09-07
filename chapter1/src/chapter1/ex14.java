package chapter1;

public class ex14 {
	public static int lg(int N){
		int i,n;
	for(i=0,n=1;n<=N;i++)
	{
		n*=2;
	}
	return i-1;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
System.out.println(lg(16));
	}

}
