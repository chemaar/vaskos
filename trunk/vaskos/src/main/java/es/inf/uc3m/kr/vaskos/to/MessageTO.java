package es.inf.uc3m.kr.vaskos.to;

public class MessageTO {
	private String message;
	private MessageType level;
	
	public MessageTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MessageTO(String message, MessageType level) {
		super();
		this.message = message;
		this.level = level;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public MessageType getLevel() {
		return level;
	}
	public void setLevel(MessageType level) {
		this.level = level;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((level == null) ? 0 : level.hashCode());
		result = prime * result + ((message == null) ? 0 : message.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MessageTO other = (MessageTO) obj;
		if (level != other.level)
			return false;
		if (message == null) {
			if (other.message != null)
				return false;
		} else if (!message.equals(other.message))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "MessageTO [message=" + message + ", level=" + level + "]";
	}

}
