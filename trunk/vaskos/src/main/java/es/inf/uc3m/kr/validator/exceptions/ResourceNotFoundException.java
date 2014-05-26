package es.inf.uc3m.kr.validator.exceptions;

import java.io.FileNotFoundException;
import java.io.IOException;

public class ResourceNotFoundException extends RuntimeException {

	public ResourceNotFoundException(IOException e) {
		super(e);
	}

	public ResourceNotFoundException(FileNotFoundException e, String message) {
		super(message);
	}

}
