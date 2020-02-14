import java.util.LinkedList;

public class Client extends Thread {

	private static Buffer buffer;
	private int numberMessages;
	private LinkedList<Message> messages;
	
	public Client(int numberMessages, Buffer buffer) {
		this.numberMessages = numberMessages;
		this.buffer = buffer;
		messages = new LinkedList<Message>();
	}
	
	public void run() {
		for(int i = 0; i < numberMessages; i++) {
			Message m = new Message(i);
			messages.add(m);
		}
		buffer.saveMessages(this);
		try {
			wait();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public LinkedList<Message> getMessages() {
		return messages;
	}
	
	
	
}
