package algorithm;

import java.util.*;
//import java.util.Scanner;

public class Max {

	  public static void main(String[] args)
      {
      Scanner in=new Scanner(System.in);
      while(in.hasNext()){
          int n= in.nextInt();
          ArrayList<Integer> list= new ArrayList<>();
          for (int i=0;i<n;i++)
              list.add(in.nextInt());
         Collections.sort(list,new Comparator<Integer>(){
        	 public int compare(Integer o1, Integer o2)
        	 {
        		 String s1=String.valueOf(o1);
        		 String s2=String.valueOf(o2);
        		 return (s2+s1).compareTo(s1+s2);
        	 }
        		 });
         for(int i=0;i<list.size();i++)
         {
        	 System.out.print(list.get(i));
         }
         System.out.println();
      }
  }
}
