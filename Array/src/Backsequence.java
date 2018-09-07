import java.util.*;
public class Backsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random r=new Random();
Integer[] a=new Integer[30];
for(int i=0;i<30;i++)
	a[i]=r.nextInt(20);
System.out.println(Arrays.toString(a));
Arrays.sort(a, Collections.reverseOrder());
System.out.println(Arrays.toString(a));
	}

}
