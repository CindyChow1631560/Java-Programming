package Access;
import Anewaccess.*;
public class AccessTest {
	public static void main(String[] args) {
		Fourways fw = new  Fourways();
		//fw.showa();
		fw.showb();
		//fw.showc();
		//fw.a = 10;
		fw.b = 20;
		//fw.c = 30;
		//fw.showa();
		fw.showb();
		//fw.showc();
	   // fw.showd(); // private access, compiler can't touch
	}	
}
