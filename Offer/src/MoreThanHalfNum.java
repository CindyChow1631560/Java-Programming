import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.LinkedHashMap;
import java.util.Comparator;
import java.util.Map.Entry;
public class MoreThanHalfNum {
	public static void main(String[] args){
		int[] array2={1,2,3,2,2,2,5,4,2};
		System.out.println(MoreThanHalfNum_Solution(array2));
	}
	 static int MoreThanHalfNum_Solution(int [] array) {
	        LinkedHashMap<Integer,Integer> map = new LinkedHashMap();
	        for(int i=0;i<array.length;i++){
	            Integer num = map.get(array[i]);
	            map.put(array[i], num==null?1:num+1);
	        }
	        List<Map.Entry<Integer,Integer>> list = new ArrayList<>(map.entrySet());
	        Collections.sort(list, new Comparator<Map.Entry<Integer,Integer>>(){
	        	public int compare(Entry<Integer,Integer> o1, Entry<Integer,Integer> o2){
	        		return o1.getValue().compareTo(o2.getValue());
	        	}
	        });
	        int number =list.get(list.size()-1).getKey();
	        int times = list.get(list.size()-1).getValue();
	        if(times>array.length/2)
	        	return number;
	        else
	        	return 0;
	    }
}
