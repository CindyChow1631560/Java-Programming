
class Glyph{
	 final void draw(){System.out.println("Glyph.draw");}
	Glyph(){
		System.out.println("Glyph() before draw()");
	this.draw();
	System.out.println("Glyph() after draw()");
}
}
class RoundGlyph extends Glyph{
	private int radius=1;
	RoundGlyph(int r){
		radius=r;
		System.out.println("RoundGlyph.RoundGlyph(),radius="+radius);
	}
	//@Override void draw(){
	//	System.out.println("RoundGlyph.draw(),radius="+radius);
	//}
}
public class PolyConstructors {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
    new RoundGlyph(5);
	}
}