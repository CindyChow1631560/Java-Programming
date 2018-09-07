package innerclass;

public class Outer1 {
	class Inner { 
		Inner() { System.out.println("Inner()"); }
	}
	Outer1() { System.out.println("Outer1()"); }
	// make an Inner from within a non-static method of outer class:
	Inner makeInner() {
		return new Inner();
	}
	public static void main(String[] args) {
		Outer1 o = new Outer1();
		Outer1.Inner i = o.makeInner();
	}
}