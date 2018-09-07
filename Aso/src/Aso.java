

class Doc {	
	void intubate() {
		System.out.println("prepare patient");
		Aso();
		this.Aso();	
	}
	void Aso() {
		System.out.println("use laryngoscope");
	}	
}	
public class Aso {
	public static void main(String[] args) {
		new Doc().intubate();
	}
}