
public class Server extends Thread {
	
	private static Buffer buffer;
	

	public Server(Buffer buffer){
		this.buffer = buffer;
	}
	
	public void run(){
		Message m = buffer.sendMessage();
		while (m!=null){
		
		m.answerMessage();
		int answer = m.getMessage();
		notify();
		}
	}
}
