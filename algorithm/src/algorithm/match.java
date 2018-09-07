package algorithm;
import java.util.*;
public class match
{
    public static void main(String[] args)
    {
        Scanner in =new Scanner(System.in);
        String str=in.nextLine();
       // StringBuffer buf=new StringBuffer();
        StringBuffer buf=new StringBuffer();
        //String str=buf.toString();
      
        //Pattern pattern=Pattern.compile("[a-zA-Z]");
         char[] stringarry=str.toCharArray();
        for(int i=0;i<stringarry.length;i++)
        {
        if((stringarry[i]+"").matches("[a-zA-Z]"))
        {
            buf.append(stringarry[i]);
        }
        }
        String str2=buf.toString();
        char[] string=str2.toCharArray();
        int[] c=new int[256];
        for(char s:string)
        {
            c[s]++;
            if(c[s]==3)
            {
            	  System.out.println(s);
                break;
            }
        }
      
    }
}
