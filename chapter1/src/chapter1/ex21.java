package chapter1;
import java.util.*;
public class ex21 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Scanner input=new Scanner(System.in);
System.out.println("Please input the number of datus");
int n=input.nextInt();
String[] name=new String[n];
int[] data1=new int[n];
int[] data2=new int[n];
for(int i=0;i<n;i++){
	name[i]=input.next();
	data1[i]=input.nextInt();
	data2[i]=input.nextInt();
}
for(int i=0;i<n;i++)
System.out.printf("|%4s|%4d|%4d|%6.3f|\n",name[i],data1[i],data2[i],(float)(data1[i]/data2[i]));
	}

}
