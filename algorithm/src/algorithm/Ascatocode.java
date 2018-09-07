package algorithm;
import java.util.Scanner;
public class Ascatocode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Scanner input = new Scanner(System.in);
		   System.out.println("Enter an ASCII code:");
		   int number=input.nextInt();
		   char ch=(char)number;
		   System.out.println("The character for ASCII code "+number+ " is "+ch);
	}

}
