
public class Message {

	private int answer;
	private int query;
	
	public Message(int i) {
		this.query = i;
	}
	
	public int getQuery() {
		return query;
	}
	public void setQuery(int query) {
		this.query = query;
	}
	public int getAnswer() {
		return answer;
	}
	public void setAnswer(int answer) {
		this.answer = answer;
	}

}
