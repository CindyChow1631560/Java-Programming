/*****************************************************
��ģʽ�еĵڶ����ַ����ǡ�*��ʱ��
1������ַ�����һ���ַ���ģʽ�еĵ�һ���ַ���ƥ�䣬��ô�ַ�����ģʽ������һ���ַ���Ȼ��ƥ��ʣ��ġ�
2����� �ַ�����һ���ַ���ģʽ�еĵ�һ���ַ��಻ƥ�䣬ֱ�ӷ���false��

����ģʽ�еĵڶ����ַ��ǡ�*��ʱ��
����ַ�����һ���ַ���ģʽ��һ���ַ���ƥ�䣬��ģʽ����2���ַ�������ƥ�䡣����ַ�����һ���ַ���ģʽ��һ���ַ�ƥ�䣬������3��ƥ�䷽ʽ��
1��ģʽ����2�ַ����൱��x*�����ԣ�
2���ַ�������1�ַ���ģʽ����2�ַ���
3���ַ�������1�ַ���ģʽ���䣬������ƥ���ַ���һλ����Ϊ*����ƥ���λ��
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
