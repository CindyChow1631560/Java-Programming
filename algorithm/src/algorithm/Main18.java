package algorithm;

import java.util.Scanner;
import java.util.Stack;
import java.util.ArrayList;
public class Main18 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		 String str = in.nextLine();//ÊäÈëÒ»ĞĞ×Ö·û´®
		 char[] fuhao = str.toCharArray();
		 ArrayList<Character> res = new ArrayList();
		 for(int i=0;i<fuhao.length;i++){
			 res.add(fuhao[i]);
		 }
		 Stack<Character> ops = new Stack<Character>();
		 Stack<Integer> val = new Stack<Integer>();
		 for(int i=0;i<fuhao.length;i++){
			 if(fuhao[i]=='+'||fuhao[i]=='-') {
				 res.add(i-1,'(');
				res.add(i-1,'(');
				 res.add(i+4,')');
				 res.add(i+7,')');
			 }
				
		 }
		 System.out.println(res);
		 for(int i=0;i<res.size();i++){
			 if(res.get(i)=='(');
			 else if(res.get(i)=='+') ops.push(res.get(i));
			 else if(res.get(i)=='-') ops.push(res.get(i));
			 else if(res.get(i)=='*') ops.push(res.get(i));
			 else if(res.get(i)=='/') ops.push(res.get(i));
			 else if(res.get(i)==')'){
				 char op = ops.pop();
				 int v = val.pop();
				 if(op == '+') v=val.pop()+v;
				 else if (op == '-') v=val.pop()-v;
				 else if (op == '*') v=val.pop()*v;
				 else if(op == '/') v=val.pop()/v;
				 val.push(v);
			 }
			 else{
				 String s = String.valueOf(res.get(i));
				 
				 val.push(Integer.parseInt(s));
			 }
			 //else val.push(Integer.parseInt(res.get(i)));
		 }
		 System.out.println(val.pop());
		 
	}

}
