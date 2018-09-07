
public class FindNumsAppearOnce {
     public void FindNumsAppearOnceMain(int [] array,int num1[] , int num2[]) {
    	 if(array==null||array.length<=1)
    		 return;
    	 int res = 0;
    	 int index=0;
    	 for(int i=0;i<array.length;i++){
    		 res^=array[i];
    	 }
    	 for(int i=0;i<32;i++){
    		 if((res & (1<<i)) ==1){
    			 index=i;
    			 break;
    		 }
    	 }
    	 for(int i=0;i<array.length;i++){
    		 if((array[i] & (1<<index))==1){
    			 num1[0]^=array[i];
    		 }else
    			 num2[0]^=array[i];
    	 }
        
    }

}
