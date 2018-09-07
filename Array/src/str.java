import java.util.*;
public class str {
public static void main(String[] args)
{
	 Scanner in =new Scanner(System.in);
     String str=in.nextLine();
    StringBuffer buf=new StringBuffer();
    char[] ary=str.toCharArray();
    for(int i=0;i<ary.length;i++)
    {
    	 if((ary[i]+"").matches("[a-zA-Z]"))
         {
             //buf.append(ary[i]);
             System.out.println("yes");
         }
    	 else
    		 System.out.println("no");
    }
    System.out.println(buf);
   
    
}
}
