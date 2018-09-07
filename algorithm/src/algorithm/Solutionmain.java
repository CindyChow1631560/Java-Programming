package algorithm;
import java.util.Scanner;
import java.math.BigInteger;
public class Solutionmain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        long n = in.nextInt();
        long m = in.nextInt();
        long p = in.nextInt();
        long sum=0;
        Long n1 = n;
        String s = n1.toString();
        BigInteger k= new BigInteger(s);
        System.out.println(k);
        long[] array = new long[N];
        array[0]=p;
        for(int i=1;i<array.length;i++){
        	array[i]=(array[i-1]+153)%p;
        }
        for(int i=1;i<=n;i++){
        	for(int j=1;j<=m;j++){
        		sum+=array[gcd(i,j)-1];
        	}
        }
        System.out.println(sum);
	}
	
	public static int gcd(int i, int j) {  
		      int k;   
		      while ((k=i%j) != 0) {            
		           i = j;  
		           j = k;  
		       }  
		      return j;  
		   }  
}
