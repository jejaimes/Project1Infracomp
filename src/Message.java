
public class Message {

	private int message;
	
	public Message(int i){
		message = i;
	}

	public int getMessage() {
		return message;
	}

	public void setMessage(int message) {
		this.message = message;
	}
	
	public void answerMessage(){
		message++;
		System.out.println("Responding message "+(message-1)+" to: "+message);
	}
	


}
