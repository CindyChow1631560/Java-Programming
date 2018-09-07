package algorithm;
import java.util.*;
public class Euclid {
	static ArrayList stampa= new ArrayList();
	static ArrayList stampb= new ArrayList();
public static long gcd(long a, long b){
	stampa.add(a);
	stampb.add(b);
if (b==0) return a;
long r=a%b;
a=b;
b=r;
//stampa.add(a);
//stampb.add(r);
return gcd(a,b);
		
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(gcd(105,24));
		 System.out.println("a:");
		for(int i=0;i<stampa.size();i++)
      System.out.print(stampa.get(i)+" ");
		System.out.println();
		 System.out.println("b:");
		for(int i=0;i<stampb.size();i++)
		      System.out.print(stampb.get(i)+" ");
	}
	
	}


