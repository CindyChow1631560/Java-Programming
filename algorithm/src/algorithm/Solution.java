package algorithm;

public class Solution {
    public void reOrderArray(int [] array) {
        int l=array.length;
        int[] copy=new int[l];
        int oddcount=0,oddstart=0;
        if(l==0|l==1)
            return; 
        for(int i=0;i<l;i++)
        {
            if(array[i]%2==1)
                oddcount++;
        }
    for(int i=0;i<l;i++)
    {
        if(array[i]%2==1)
        {
            copy[oddstart++]=array[i];
        }
        else
            copy[oddcount++]=array[i];
    }
    for(int i=0;i<l;i++)
        array[i]=copy[i];
}
}