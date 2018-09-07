class Meal{
	Meal(){
		System.out.println("Meal()");
	}
}
class Bread{
	Bread(){
		System.out.println("Bread()");
	}
}
class Cheess{
	Cheess(){
		System.out.println("Chess()");
	}
}
class Lettuce{
	Lettuce(){
		System.out.println("Letture()");
	}
}
class Lunch extends Meal{
	Lunch(){
		System.out.println("Lunch()");
	}
}
class PortableLunch extends Lunch{
	PortableLunch(){
		System.out.println("PortableLunch()");
	}
}
public class Sandwich extends PortableLunch{
	public Sandwich(){System.out.println("Sandwich()");}
	private Bread b=new Bread();
	private Cheess c=new Cheess();
	private Lettuce l=new Lettuce();
	public static void main(String[] args){
		new Sandwich();
	}

}
