/*****************************************************
当模式中的第二个字符不是“*”时：
1、如果字符串第一个字符和模式中的第一个字符相匹配，那么字符串和模式都后移一个字符，然后匹配剩余的。
2、如果 字符串第一个字符和模式中的第一个字符相不匹配，直接返回false。

而当模式中的第二个字符是“*”时：
如果字符串第一个字符跟模式第一个字符不匹配，则模式后移2个字符，继续匹配。如果字符串第一个字符跟模式第一个字符匹配，可以有3种匹配方式：
1、模式后移2字符，相当于x*被忽略；
2、字符串后移1字符，模式后移2字符；
3、字符串后移1字符，模式不变，即继续匹配字符下一位，因为*可以匹配多位；
 * @author asus
 *
 */
public class match {
	public boolean matchMain(char[] str, char[] pattern)
    {
		 int strindex = 0;
	        int patindex = 0;
	        if(str==null||pattern==null){
	        	return false;
	        }
	       return matchstr(str,strindex,pattern,patindex);
	    }
	  public boolean matchstr(char[] str, int strindex, char[] pattern, int patindex){
		  if(strindex==str.length&&patindex==pattern.length)
			  return true;
		  if(strindex!=str.length&&patindex==pattern.length)
			  return false;
		  if(patindex+1<pattern.length&&pattern[patindex+1]=='*'){
			  if((strindex!=str.length&&str[strindex]==pattern[patindex])||(strindex!=str.length&&pattern[patindex]=='.')){
				  return matchstr(str,strindex,pattern,patindex+2)
						 ||matchstr(str,strindex+1,pattern,patindex+2)
						 ||matchstr(str,strindex+1,pattern,patindex);
			  }else{
				  return matchstr(str,strindex,pattern,patindex+2);
			  }
		  }
	      	if((strindex!=str.length&&str[strindex]==pattern[patindex])||(strindex!=str.length&&pattern[patindex]=='.'))
	      		return matchstr(str,strindex+1,pattern,patindex+1);
	      	return false;
      
    
  }
}
