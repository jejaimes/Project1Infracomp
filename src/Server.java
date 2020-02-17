
public class Server extends Thread {
	
	private static Buffer buffer;
	private int id;

	public Server(Buffer buffer, int id){
		this.buffer = buffer;
		this.id = id;
	}
	
	public void run(){
		while(buffer.currentClients()>0){
		Message m = buffer.sendMessage();
		if (m!=null){
		m.answerMessage();
		int answer = m.getMessage();
		synchronized(m){
			m.notify();
		}
		}
	}
		System.out.println("Yielding server " + id);
		this.yield();
	}
	
	public int getNum(){
		return id;
	}
}
