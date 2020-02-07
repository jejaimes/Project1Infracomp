

public class Client extends Thread {

	private static Buffer buffer;
	private int numberMessages;
	
	public Client(int numberMessages) {
		this.numberMessages = numberMessages;
	}
	
	public void run() {
		for(int i = 0; i < numberMessages; i++) {
			Message message = new Message(i);
		}
	}
}
