package es.inf.uc3m.kr.validator.exception;

import java.io.IOException;
import java.net.URISyntaxException;

public class VaskosModelException extends RuntimeException {

	public VaskosModelException(IOException e, String string) {
		// TODO Auto-generated constructor stub
		super(e);
	}

	public VaskosModelException(URISyntaxException e, String string) {
		super(e);
	}

	public VaskosModelException(Exception e) {
		super(e);
	}

}
