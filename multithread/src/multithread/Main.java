package multithread;
class Thread1 extends Thread{
	private String name;
	public Thread1(String name){
		this.name=name;
	}
	public void run(){
		for (int i=0;i<5;i++)
			System.out.println(name+":"+i);
		try{
			sleep((int)Math.random()*10);
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}
}

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Thread.currentThread().getName()+": the main thread starts to run");
Thread1 mTh1=new Thread1("A");
Thread1 mTh2=new Thread1("B");
mTh1.start();
mTh2.start();
try{
	mTh1.join();
}catch(InterruptedException e){
	e.getStackTrace();
}
try{
	mTh2.join();
}catch(InterruptedException e){
	e.getStackTrace();
}
System.out.println(Thread.currentThread().getName()+ ": the mian thread ended");  
	}

}
