import java.util.List;
import java.util.Collections;
import java.util.ArrayList;
public class Solution {
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> res = new ArrayList<>();
       if(str!=null&&str.length()>0){
           PermutationHelper(str.toCharArray(),0,res);
           Collections.sort(res);
       }
        return res;
    }
    static void  PermutationHelper(char[] target, int label, ArrayList<String> list){
        if(label==target.length-1){
            String val = String.valueOf(target);
            if(!list.contains(val))
                list.add(val);
        }else{
            for(int j=label;j<target.length;j++){
                swap(target,label,j);
                PermutationHelper(target,label+1,list);
                swap(target,label,j);
            }
        }
       
    }
    static void swap(char[] array, int i, int j){
        char temp = array[i];
        array[i]=array[j];
        array[j]=temp;
    }
}