package chapter1;
import java.util.*;
public class ex3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] number=new int[3];
Scanner input= new Scanner(System.in);
System.out.println("Input 3 numbers");
for(int i=0;i<number.length;i++)
	number[i]=input.nextInt();
if(number[0]==number[1]&&number[1]==number[2])
	System.out.println("equal");
else System.out.println("not equal");
	}

}
