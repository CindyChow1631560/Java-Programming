package fibonacci;
import java.io.IOException;
public class Fibonacci {
	int fib(int n) {
		if(n < 2) return 1;
		return (fib(n - 2) + fib(n - 1));
	}
	public static void main(String[] args) throws IOException {
		Fibonacci f = new Fibonacci();
		System.out.print("Enter a number:"); 
       int k = (int)System.in.read(); 
		System.out.println("First " + k + " Fibonacci number(s): ");
		for(int i = 0; i < k; i++)
			System.out.println(f.fib(i));
	}	
}
