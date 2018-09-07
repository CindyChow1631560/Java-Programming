/*class Game{
	Game(){
		System.out.println("Game constructor");
	}
}*/
class BoardGame 	{
	BoardGame(int i){
		
		System.out.println("BoardGame constructor"+i);
	}
}
public class Chess extends BoardGame {
	 Chess(){super(1);}
     Chess(int i){
    	super(i);
    	 System.out.println("Chess constructor"+i);
     }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
Chess i=new Chess(3);
	}

}
