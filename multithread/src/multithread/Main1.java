package multithread;
class Thread2 implements Runnable{
	private String name;
	public Thread2(String name){
		this.name=name;
	}
	@Override
	public void run(){
		for(int i=0;i<5;i++)
			System.out.println(name+":"+i);
		/*try{
			Thread.sleep((int)Math.random()*10);
		}catch(InterruptedException e){
			e.printStackTrace();
		}*/
	}
}
public class Main1 {
	
public static void main(String[] args){
	new Thread(new Thread2("c")).start();
	new Thread(new Thread2("d")).start();
}
}