package iteration;

	
public class maxsubsum {
	public static int maxSumRec(int[] a,int left,int right){
		int center=(left+right)/2;	
		int maxLeftSum =maxSumRec(a,left,center);	
	    int maxRightSum=maxSumRec(a,center+1,right);
		if(left==right){}
			if(a[left]>0)
				return a[left];
			else 
				return 0;
		
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a= new int[5];
		for(int i=0;i<5;i++)
			a[i]=i;
maxsubsum m=new maxsubsum();
m.maxSumRec(a, 0, 4);
	}

}
