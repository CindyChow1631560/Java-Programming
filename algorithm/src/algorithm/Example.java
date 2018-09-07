package algorithm;
import java.util.*;
public class Example
{
	public static void main(String args[]) {
		int[] a={10,11,9,8,12,13,9,9,};
		Arrays.sort(a);
		int b[]=new int[a.length];
		int c[]=new int[a.length];
        int d[]=new int[a.length];
		int emp=0;
		int dmp=0;
		int count=0;
		b[0]=a[a.length-1];
		c[0]=a[a.length-2];
		for(int i=0;i<a.length-2;i++){
			emp+=b[i];
			dmp+=c[i];
			if(emp>dmp){
				c[i+1]=a[i];
			}else{
				b[i+1]=a[i];
			}
		}
		for(int i=0;i<b.length;i++){
			if(b[i]==0){
				count++;
			}else{
					d[i]=b[i];
					System.out.println(d[i]);

				}
				}
				

	}
}