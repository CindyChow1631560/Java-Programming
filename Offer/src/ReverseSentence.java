
public class ReverseSentence {
	public static void main(String[] args){
		String test = "student. a am I";
		String res = ReverseSentenceMain(test);
		System.out.println(res);
	}
	 public static String ReverseSentenceMain(String str) {
		        if(str.trim().equals(""))
	                return str;
	        String[] strArr=str.trim().split(" ");
	        StringBuffer result = new StringBuffer();
	        for(int i=0;i<strArr.length;i++){
	           result.append(strArr[strArr.length-i-1]);
	           result.append(" ");
	        }
	        result.deleteCharAt(result.length()-1);
	        String results = result.toString();
	        return results;
	    }
}
