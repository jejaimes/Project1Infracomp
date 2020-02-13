
public class Buffer {

	private int size;
	private Message[] messages;
	
	
	public Buffer(int size) {
		this.size = size;
		messages = new Message[size];
	}
	
	public synchronized void saveMessage(Message m) {
		if(size > 0) {
			size--;
			messages[size-1] = m;
			try {
				m.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		else {
			Thread.yield();
		}
		
	}
	
	public synchronized Message sendMessage() {
		Message m = messages[messages.length-1];
		size++;
		return m;
	}
}
