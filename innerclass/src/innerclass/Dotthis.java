package innerclass;

public class Dotthis {
void f(){
	System.out.println("Dotthis.f()");
}
public class Inner{
	public Dotthis outer(){
		return Dotthis.this;
	}
}
public Inner inner(){
	return new Inner();
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
Dotthis dt=new Dotthis();
Dotthis.Inner dti = dt.new Inner();
dti.outer().f();
	}

}
