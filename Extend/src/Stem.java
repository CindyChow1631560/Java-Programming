class Component1 {
	Component1() { System.out.println("Component1()"); }
}

class Component2 {
	Component2() { System.out.println("Component2()"); }
}

class Component3 {
	Component3() { System.out.println("Component3()"); }
}

class Root { 
	Component1 c1root;
	Component2 c2root;
	Component3 c3root;
	Root() { System.out.println("Root()");
	c1root = new Component1();
	c2root = new Component2();
	c3root = new Component3();
	} 
	
}

public class Stem extends Root { 
    Component1 c1stem;
    Component2 c2stem;
	Component3 c3stem;
	
	Stem() { System.out.println("Stem()"); } 
	public static void main(String[] args) {
		Stem s = new Stem();
		
		//Component1 c1root;
	//s.c1root;		
	}
}