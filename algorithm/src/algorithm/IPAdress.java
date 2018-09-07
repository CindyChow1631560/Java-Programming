package algorithm;

import java.util.Scanner;
import java.util.regex.Pattern;

public class IPAdress {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
        String str = sc.next();
        Pattern pattern = Pattern.compile("^((([0-9A-Fa-f]{1,4}:){7}[0-9A-Fa-f]{1,4})|(([0-9A-Fa-f]{1,4}:){1,7}:)|(([0-9A-Fa-f]{1,4}:){6}:[0-9A-Fa-f]{1,4})|(([0-9A-Fa-f]{1,4}:){5}(:[0-9A-Fa-f]{1,4}){1,2})|(([0-9A-Fa-f]{1,4}:){4}(:[0-9A-Fa-f]{1,4}){1,3})|(([0-9A-Fa-f]{1,4}:){3}(:[0-9A-Fa-f]{1,4}){1,4})|(([0-9A-Fa-f]{1,4}:){2}(:[0-9A-Fa-f]{1,4}){1,5})|([0-9A-Fa-f]{1,4}:(:[0-9A-Fa-f]{1,4}){1,6})|(:(:[0-9A-Fa-f]{1,4}){1,7})|(([0-9A-Fa-f]{1,4}:){6}(\\d|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])(\\.(\\d|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])){3})|(([0-9A-Fa-f]{1,4}:){5}:(\\d|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])(\\.(\\d|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])){3})|(([0-9A-Fa-f]{1,4}:){4}(:[0-9A-Fa-f]{1,4}){0,1}:(\\d|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])(\\.(\\d|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])){3})|(([0-9A-Fa-f]{1,4}:){3}(:[0-9A-Fa-f]{1,4}){0,2}:(\\d|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])(\\.(\\d|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])){3})|(([0-9A-Fa-f]{1,4}:){2}(:[0-9A-Fa-f]{1,4}){0,3}:(\\d|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])(\\.(\\d|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])){3})|([0-9A-Fa-f]{1,4}:(:[0-9A-Fa-f]{1,4}){0,4}:(\\d|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])(\\.(\\d|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])){3})|(:(:[0-9A-Fa-f]{1,4}){0,5}:(\\d|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])(\\.(\\d|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])){3}))$"); 
        if(!pattern.matcher(str).matches()){
        	System.out.println("Error");
       
        }
        str = str.replace(":", "");
       // int b=Integer.parseInt(str,16);
        //String strbinary = Integer.toBinaryString(b);
       
        
        String str1=str.substring(0,4);
        int i=Integer.parseInt(str1,16);
        String str2=Integer.toBinaryString(i);
        
       // System.out.println(str2);
        String str3 = str.substring(0,10);
        char[] data = new char[128];
        for(int j=0;j<data.length;j++)
        	data[j]='0';
        String Unspecified = new String(data);
        /*if(strbinary.equals(Unspecified)){
        	System.out.println("Unspecified");
        	aa="Unspecified";
        }
        String strloop=strbinary.substring(0,127)+'1';
        if(strbinary.equals(strloop)){
        	System.out.println("Loopback");
        	aa="Loopback";
        }*/
        if(str3.equals("1111111010")){
        	System.out.println("LinkLocal");
        	
        }else
        if(str3.equals("1111111011")){
        	System.out.println("SiteLocal");
        
        }
       /* String Multistr = strbinary.substring(0,8);
        if (Multistr.equals("11111111"))
        {
        	System.out.println("Multicast");
        	aa="Multicast";
        }*/
       
        	System.out.println("GlobalUnicast");
        
	}
	
}
