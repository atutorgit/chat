package fr.tutornet.struts.model.javabeans;

public class Chat {

	public static Chat instance;
	
	private Chat() {
		// Private constructor
	}
	
	public static Chat getInstance() {
		if (instance == null)
			instance = new Chat();
		return instance;
	}

	private String messages = "";

	public String getMessages() {
		return messages;
	}

	public void setMessages(String messages) {
		this.messages = messages;
	}
}
