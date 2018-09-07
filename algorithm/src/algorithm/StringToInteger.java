package algorithm;

public class StringToInteger {
	public int myAtoi(String str) {
        if(str.length()==0) return 0;
        int i=0,sign=1,total=0;
        while(str.charAt(i)==' '){
            i++;
            if(i==str.length())
            	return sign*total;//exists situation that str=" "
        }
        if(str.charAt(i)=='+'||str.charAt(i)=='-'){
            sign=str.charAt(i)=='+'?1:-1;
            i++;
        }
        while(i<str.length()){
            if((str.charAt(i)-'0')<0||(str.charAt(i)-'0')>9)
                break;
            if(total>Integer.MAX_VALUE/10||total==Integer.MAX_VALUE/10&&(str.charAt(i)-'0')>Integer.MAX_VALUE%10)
                return sign==1?Integer.MAX_VALUE:Integer.MIN_VALUE;
            total=total*10+(str.charAt(i)-'0');
            i++;
        }
        return total*sign;
        
    }
}
