import java.util.LinkedHashMap;
public class FirstNotRepeatingChar {
	public static void main(String[] args){
		String test = "ababczz";
		int position = FirstNotRepeatingCharMian(test);
		System.out.println(position);
	}
	 public static int FirstNotRepeatingCharMian(String str) {
		 int position=0;
	        char[] string = str.toCharArray();
	        if(string.length<=2)
	        return 0;
	        LinkedHashMap<Character,Integer> map = new LinkedHashMap();
	        for(int i=0;i<string.length;i++){
	        	Integer num = map.get(string[i]);
	        	map.put(string[i], num==null?1:num+1);
	        }
	       for(int i=0;i<string.length;i++){
	    	   if(map.get(string[i])==1){
	    		  position=i+1;
	    		   break;
	    	   }
	    	  
	       }
	       return position;
	    }
}
