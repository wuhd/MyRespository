package ResChain;

public abstract class Handler {
	
	private Handler nextHandler;
	
	public int maxDay;
	
	protected Handler(int maxDay) {
		this.maxDay = maxDay;
	} 
	
	public void setNextHandler(Handler handler){
		this.nextHandler = handler;
	}
	
	protected void handleRequest(int day){
		if(day <= maxDay){
			reply(day);
		}else{
			if(nextHandler != null){
				nextHandler.handleRequest(day);
			}else{
				System.out.println("û�и��ߵ��쵼������");
			}
		}
	}
	
	protected abstract void reply(int day);
}
