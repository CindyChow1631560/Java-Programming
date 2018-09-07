package algorithm;

import java.util.Scanner;
import java.util.*;
public class KL {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner line = new Scanner(System.in);
		String p = line.nextLine();
		String q = line.nextLine();
		String[] p1 = p.trim().split(" "); 
		String[] q1 = q.trim().split(" ");
		HashMap<Integer,Integer> pre = new HashMap<>();
		HashMap<Integer,Integer> qre = new HashMap<>();
		int[] p11 = new int[p1.length];
		int[] q11 = new int[q1.length];
		for(int i=0;i<p1.length;i++){
			p11[i]=Integer.parseInt(p1[i]);
		}
		for(int i=0;i<q1.length;i++){
			q11[i]=Integer.parseInt(q1[i]);
		}
		 for(int str:p11){
	    	  Integer num= str;
	    	  pre.put(str, num==null?1:num+1);
	      }
		 for(int str:q11){
	    	  Integer num= str;
	    	  qre.put(str, num==null?1:num+1);
	      }
		float[] p_x = new float[pre.size()];
		float[] q_x = new float[qre.size()];
		
		 Set<Integer> s = pre.keySet();
		 Set<Integer> sq = pre.keySet();
		 ArrayList<Integer> kp = new ArrayList();
		 ArrayList<Integer> kq = new ArrayList();
		//进行键的集合的遍历
		for(Integer key : s){
		 //根据得到的键，获取对应的值
		Integer zhi = pre.get(key);
		kp.add(zhi);
		 }
		for(Integer key : sq){
			 //根据得到的键，获取对应的值
			Integer zhi = qre.get(key);
			kq.add(zhi);
			 }
		for(int i=0;i<p_x.length;i++){
			p_x[i]=(float)kp.get(i)/p1.length;
		}
		for(int i=0;i<q_x.length;i++){
			q_x[i]=(float)kq.get(i)/q1.length;
		}
		
		float result=0;
		for(int i=0;i<p_x.length;i++){
			result+=p_x[i]*Math.log(p_x[i])/q_x[i];
			
		}
		System.out.println(String.format("%2.2f", result));
	}

}
