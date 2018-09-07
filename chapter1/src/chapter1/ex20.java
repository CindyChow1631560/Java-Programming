package chapter1;

public class ex20 {
	public static double ln(int N) {
		if (N ==1) {
			return 0;
		} else {
			return Math.log(N) + ln(N - 1);
		}
	}
	
	public static void main(String[] args) {
		System.out.println(ln(10));
		//System.out.println(Math.log(8));
	}
	
	

}
