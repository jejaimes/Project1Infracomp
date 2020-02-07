
public class Buffer {

	private int size;
	private Message[] messages;
	
	public Buffer(int size) {
		this.size = size;
		messages = new Message[size];
	}
}
