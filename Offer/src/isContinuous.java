import java.util.Arrays;
//import java.util.Collections;

public class isContinuous {
	public boolean isContinuousMain(int [] numbers) {
      int len=numbers.length;
      if(len==0)
    	  return false;
      int numberOf0=0;
      Arrays.sort(numbers);
      for(int i=0;i<len;i++){
    	  if(numbers[i]==0){
    		  numberOf0++;
    	  }
      }
      
      int gap=0;
      for(int i=numberOf0;i<len-1;i++){
      int g1 = i;
      int g2=g1+1;
      if(numbers[g1]==numbers[g2])
    	  return false;
      gap+=(numbers[g2]-numbers[g1])-1;
      }
      if(gap>numberOf0)
    	  return false;
      return true;
    }
}
