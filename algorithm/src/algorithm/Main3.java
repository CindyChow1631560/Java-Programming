package algorithm;
import java.util.Scanner;
import java.util.LinkedHashMap;
import java.util.ArrayList;
public class Main3 {

	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        LinkedHashMap<Integer,Integer> map = new LinkedHashMap();
        ArrayList<Integer> list = new ArrayList();
        while (in.hasNext()) {//ע��while������case
        	for(int n=0;n<num;n++){
        		int a = in.nextInt();
        		list.add(a);
        	} 
            int i;
            int j;
            for(int m=0;m<list.size();m++){
            for(i=1;i<=list.get(m);i=i+2){
            	for(j=2;j<=list.get(m);j=j+2){
            		if(i*j==list.get(m)){
            			map.put(i, j);	
            		}
            		
            	}
            }
           // System.out.println(i);
            int k = map.size()-1;
            LinkedHashMap mapKey = new LinkedHashMap<Integer, Integer>();
            LinkedHashMap<Integer, Integer> mapValue = new LinkedHashMap();
            for(java.util.Map.Entry<Integer, Integer> entry : map.entrySet()) {
            	 //��ԭ��MAP��VALUE�����µ�MAP��VALUE����
           mapKey.put(k, entry.getKey());
            	 //��ԭ��MAP��KEY�����µ�MAP��VALUE ����
           mapValue.put(k, entry.getValue());
            	
            	k--;
            }
            //k=map.size()-1;
            if(map.size()!=0){
        		System.out.println(mapKey.get(0)+" "+mapValue.get(0));
        	}
        	else
        		System.out.println("No");
            map.clear();
            }
            
        }
        
         
    }
}


