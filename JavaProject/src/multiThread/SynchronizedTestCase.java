package multiThread;

public class SynchronizedTestCase {
	
	synchronized public void method(){
		
	}
	
	public void method2(){
		synchronized (this) {
			
		}
	}
}
