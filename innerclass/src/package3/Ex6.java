package package3;
import package1.*;
import package2.*;
public class Ex6 extends Ex6Base{
	Ex6Tnterface getBaseInner(){
	return this.new Ex6BaseInner();
	}
	public static void main(String[] args) {
		Ex6 ex = new Ex6();
		System.out.println(ex.getBaseInner().say());
	}	
}
