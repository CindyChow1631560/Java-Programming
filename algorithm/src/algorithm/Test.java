package algorithm;

class Person{
	String name;
	int age;
}

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Person p =new Person();
        p.name="Ali";
        p.age=24;
        Person p2=p;
        System.out.println(p2.age);
        p2.age=13;
        System.out.println(p.age);
	}

}
