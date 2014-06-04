package es.inf.uc3m.kr.vaskos.services.to;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.List;


@XmlRootElement(name = "resultTO")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "resultTO", propOrder = {
    "errors",
    "info",
    "valid",
    "time",
    "nanotime"
})
public class ResultTO {

	private List<DisplayMessageTO> errors;
	private List<DisplayMessageTO> info;
	private boolean valid;
	private long time;
	private long nanotime;
	
	
	public ResultTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public boolean isValid() {
		return valid;
	}
	public void setValid(boolean valid) {
		this.valid = valid;
	}
	public long getTime() {
		return time;
	}
	public void setTime(long time) {
		this.time = time;
	}
	public long getNanotime() {
		return nanotime;
	}
	public void setNanotime(long nanotime) {
		this.nanotime = nanotime;
	}


	public List<DisplayMessageTO> getErrors() {
		return errors;
	}


	public void setErrors(List<DisplayMessageTO> errors) {
		this.errors = errors;
	}


	public List<DisplayMessageTO> getInfo() {
		return info;
	}


	public void setInfo(List<DisplayMessageTO> info) {
		this.info = info;
	}
	
	
	
}
