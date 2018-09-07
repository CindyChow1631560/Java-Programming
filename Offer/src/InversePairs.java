
public class InversePairs {
	 public int InversePairsmain(int [] array) {
	     if(array==null||array.length<=1)
	    	 return 0;
	     int pairsnum=mergeSort(array,0,array.length-1)%1000000007;
	     return pairsnum;
	    }
	 public int mergeSort(int[] array, int left,int right){
		 if(left==right)
			 return 0;
		 int middle = (left+right)/2;
		 int leftSum=mergeSort(array,left,middle);
		 int rightSum = mergeSort(array,middle+1,right);
		 return Sort(array,left,middle,right)+leftSum+rightSum;
	 }
	 public int Sort(int[] array, int left, int middle, int right){
		 int p1 = middle;
		 int p2 = right;
		 int p3 = right-left;
		 int pairsum=0;
		 int[] aux = new int[right-left+1];
		 while(p1>=left&&p2>=middle+1){
		 if(array[p1]>array[p2]){
			 aux[p3--]=array[p1--];
			 pairsum=pairsum+(p2-middle);
		 }else{
			 aux[p3--]=array[p2--];
		 }
		 }
		 while(p1>=left){
			 aux[p3--]=array[p1--];
		 }
		 while(p2>=middle){
			 aux[p3--]=array[p2--];
		 }
		int i=0;
		while(left<=right){
			array[left++]=aux[i++];
		}
		return pairsum;
	 }
}
