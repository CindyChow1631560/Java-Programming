package algorithm;
import java.util.*;

public class inverse {
public static void main(String[] args)
{
	Scanner in= new Scanner(System.in);
	while(in.hasNext())
	{
		String str=in.nextLine();
		System.out.println(inv(str));
	}
}
public static String inv(String str)
{
	String[] numberarray=str.split(" ");
	 StringBuffer res = new StringBuffer();
	 int i;
	for (i=0;i<numberarray.length-1;i++)
	{
		res.append(numberarray[numberarray.length-i-1]+" ");
	}
	res.append(numberarray[numberarray.length-i-1]);
	return res.toString();
}
}
