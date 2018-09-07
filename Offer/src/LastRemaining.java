
public class LastRemaining {
	 public int LastRemaining_Solution(int n, int m) {
	        if(n==0)
	        	return -1;
	        if(m==0)
	        	return 0;
	        return (LastRemaining_Solution(n-1,m)+m)%n;
	    }
}
