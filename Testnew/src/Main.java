import java.util.Scanner;
import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in =new Scanner(System.in);
        String str=in.nextLine();
       // StringBuffer buf=new StringBuffer();
        char[] stringarray=str.toCharArray();
       int n=stringarray.length;
       Map<Character,Integer> map=new HashMap<Character,Integer>();
       for (int i=0;i<n;i++)
       {
    	   if(map.containsKey(stringarray[i])){
    		   int temp=map.get(stringarray[i]);
    		   map.put(stringarray[i], temp+1);
    	   } else{
    		   map.put(stringarray[i], 1);
    	   }
       }
       Collection<Integer> count=map.values();
       int minCount=Collections.min(count);
       int minNumber=0;
       for(Map.Entry<Character, Integer> entry : map.entrySet()){
    	   if (minCount==entry.getValue()){
    		   if(entry.getValue()=='0')
    			   minNumber=entry.getKey()+1;
    		   minNumber=entry.getKey();//出现次数最少的数字minNUmber
    	   }
    	   if (minNumber==0)
    		   System.out.println('1'+minNumber); 
    	   else 
    		   System.out.println();
       }
    	   
	}

}
