import java.util.LinkedList;

public class Buffer {

	private int size;
	private LinkedList<Message> messages;
	private LinkedList<Client> clients;
	
	
	public Buffer(int size) {
		this.size = size;
		messages = new LinkedList<Message>();
		clients = new LinkedList<Client>();
	}
	
	public synchronized void saveMessages(Client c) {
		if(clients.size() < size) {
			clients.add(c);
			LinkedList<Message> clientMessages = c.getMessages();
			for (Message message : clientMessages) {
				messages.add(message);		
				}
			clients.remove(c);
			try {
				c.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		else {
			Thread.yield();
		}
		
	}
	
	public synchronized Message sendMessage() {
		Message m = messages.pop();
		return m;
	}
}
