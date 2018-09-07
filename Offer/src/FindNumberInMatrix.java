
public class FindNumberInMatrix {
	 public boolean Find(int target, int [][] array) {
            int row=array.length;
            int colum=array[0].length;
            boolean flag=false;
            int j=0,i=row-1;
            while(j<colum&&i>=0){
            	if(target>array[i][j]){
            		j++;
            	} else if(target<array[i][j]){
            		i--;
            	} else{
                	flag=true;
                	break;
                }
            }
           
            	
            return flag;
	    }
}
