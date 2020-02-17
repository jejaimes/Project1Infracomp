import java.util.LinkedList;

public class Client extends Thread {

	private static Buffer buffer;
	private int numberMessages;
	private LinkedList<Message> messages;
	private int id;
	
	public Client(int numberMessages, Buffer buffer, int id) {
		this.numberMessages = numberMessages;
		this.buffer = buffer;
		messages = new LinkedList<Message>();
		this.id = id;
		for(int i = 0; i < numberMessages; i++) {
			Message m = new Message(i);
			messages.add(m);
		}
	}
	
	public void run() {
		
		buffer.saveMessages(this);
		try {
			synchronized(this){
				this.wait();

			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		buffer.releaseClient(this);
		System.out.println("Yielding client "+id);
		yield();
	}

	public LinkedList<Message> getMessages() {
		return messages;
	}
	
	public int getNum(){
		return id;
	}
	
	
	
}
