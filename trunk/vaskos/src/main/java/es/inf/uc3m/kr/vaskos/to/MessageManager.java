package es.inf.uc3m.kr.vaskos.to;

import java.util.LinkedList;
import java.util.List;

public class MessageManager {

	protected List<MessageTO> info;
	protected List<MessageTO> warnings;
	protected List<MessageTO> errors;
	protected List<MessageTO> suggestions;
	public List<MessageTO> getInfo() {
		return info;
	}
	public void setInfo(List<MessageTO> info) {
		this.info = info;
	}
	public List<MessageTO> getWarnings() {
		return warnings;
	}
	public void setWarnings(List<MessageTO> warnings) {
		this.warnings = warnings;
	}
	public List<MessageTO> getErrors() {
		return errors;
	}
	public void setErrors(List<MessageTO> errors) {
		this.errors = errors;
	}
	public List<MessageTO> getSuggestions() {
		return suggestions;
	}
	public void setSuggestions(List<MessageTO> suggestions) {
		this.suggestions = suggestions;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((errors == null) ? 0 : errors.hashCode());
		result = prime * result + ((info == null) ? 0 : info.hashCode());
		result = prime * result
				+ ((suggestions == null) ? 0 : suggestions.hashCode());
		result = prime * result
				+ ((warnings == null) ? 0 : warnings.hashCode());
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
		MessageManager other = (MessageManager) obj;
		if (errors == null) {
			if (other.errors != null)
				return false;
		} else if (!errors.equals(other.errors))
			return false;
		if (info == null) {
			if (other.info != null)
				return false;
		} else if (!info.equals(other.info))
			return false;
		if (suggestions == null) {
			if (other.suggestions != null)
				return false;
		} else if (!suggestions.equals(other.suggestions))
			return false;
		if (warnings == null) {
			if (other.warnings != null)
				return false;
		} else if (!warnings.equals(other.warnings))
			return false;
		return true;
	}
	public MessageManager(List<MessageTO> info, List<MessageTO> warnings,
			List<MessageTO> errors, List<MessageTO> suggestions) {
		super();
		this.info = info;
		this.warnings = warnings;
		this.errors = errors;
		this.suggestions = suggestions;
	}
	public MessageManager() {
		super();
		this.info = new LinkedList<MessageTO>();
		this.warnings = warnings = new LinkedList<MessageTO>();
		this.errors = errors = new LinkedList<MessageTO>();
		this.suggestions = suggestions = new LinkedList<MessageTO>();
	}
	
	
}
