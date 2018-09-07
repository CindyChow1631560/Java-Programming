
public class replaceSpace {
     public String replaceSpaceMain(StringBuffer str) {
    	char[]  ch= str.toString().toCharArray();
    	StringBuffer buffer=new StringBuffer();
    	for(int i=0;i<ch.length;i++){
    	     if(ch[i]==' ')
    	    	 buffer.append("%20");
    	     else
    	    	 buffer.append(ch[i]);
    	}
        
        return buffer.toString();
       }
}
