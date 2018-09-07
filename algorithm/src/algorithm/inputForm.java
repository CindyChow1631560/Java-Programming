package algorithm;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class inputForm {
	public void form1(){
		 Scanner input=new Scanner(System.in);
		    int n=input.nextInt();
		    int[] x=new int[n];
		    int[] y=new int[n];
		    for(int i=0;i<n;i++)
		        {
		        x[i]=input.nextInt();
		        y[i]=input.nextInt();
		    }
	}
	
	public void form2(){
		Scanner in = new Scanner(System.in);
        int num = in.nextInt();//输入的行数
        LinkedHashMap<Integer,Integer> map = new LinkedHashMap();
        ArrayList<Integer> list = new ArrayList();
        while (in.hasNext()) {//注意while处理多个case
        	for(int n=0;n<num;n++){
        		int a = in.nextInt();
        		list.add(a);
        	} 
        }
	}
	
	public void form3(){
		Scanner in = new Scanner(System.in);
		 String str = in.nextLine();//输入一行字符串
		 //str=str.trim();
		 String[] c = str.trim().split(" ");
	}
	
	public void form4(){
		Scanner in = new Scanner(System.in);
		Scanner line = new Scanner(System.in);
	      int n= in.nextInt();
	      for (int i=0;i<n;i++){   //输入多行字符串
	    	  String str = line.nextLine();
	    	  String[] sque = str.trim().split(" "); 
	      }
	}
	
	
	public void form5(){
		Scanner in = new Scanner(System.in);
		 
		        int m = Integer.parseInt(in.nextLine());
		 
		    //    ArrayList<Interval> input = new ArrayList<>();
		 
		         
		 
		        for(int i = 0; i < m; i++){
		 
		            String[] errorsClassifiedByEditors = in.nextLine().split(";");
		 
		            for(int j = 0; j < errorsClassifiedByEditors.length; j++){
		 
		                String[] errors = errorsClassifiedByEditors[j].split(",");
		 
		              //  input.add(new Interval(Integer.parseInt(errors[0]), Integer.parseInt(errors[1])));
		 
		            }
		 
		        }
		 
		        in.close();
	}

}
