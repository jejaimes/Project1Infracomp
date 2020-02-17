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
	
	public int currentClients(){
		return clients.size();
	}
	
	public synchronized void releaseClient(Client c){
		System.out.println("Removing client "+c.getNum()+" from the Buffer");
		clients.remove(c);
	}
	
	public synchronized void saveMessages(Client c) {
		if(messages.size() == size) {
			try {
				c.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			System.out.println("Adding client "+c.getNum()+" to the buffer...");
			clients.add(c);
			LinkedList<Message> clientMessages = c.getMessages();
			for (Message message : clientMessages) {
				messages.add(message);	
				if(messages.size() == size) {
					try {
						c.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}			
		}
	}
	
	public synchronized Message sendMessage() {
		if(messages.size() == 0){
			return null;
		}
		else {
			if(messages.size() == size){
				notifyAll();
			}
			Message m = messages.removeFirst();
			return m;
		}
	}
}
