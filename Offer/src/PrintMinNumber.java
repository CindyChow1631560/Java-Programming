import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
public class PrintMinNumber {
	public static void main(String[] args){
		int[] numbers={3,32,321};
		String result = PrintMinNumberOfArray(numbers);
		System.out.println(result);
	}
	public static String PrintMinNumberOfArray(int [] numbers) {
        ArrayList<String> list = new ArrayList<>();
       for(int i=0;i<numbers.length;i++){
           list.add(String.valueOf(numbers[i]));
       }
       Collections.sort(list,new Comparator<String>(){
           public int compare(String l1,String l2){
               String s1 = l1+l2;
               String s2 = l2+l1;
               return s1.compareTo(s2);
           }
       });
       String result="";
       for(String i: list){
           result+=i;
       }
       return result;
   }

}
