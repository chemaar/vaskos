package main;


import java.io.IOException;

import es.inf.uc3m.kr.vaskos.SKOSValidator;
import es.inf.uc3m.kr.vaskos.impl.SKOSValidatorCoreBasicImpl;
import es.inf.uc3m.kr.vaskos.impl.SKOSValidatorSPARQLImpl;
import es.inf.uc3m.kr.vaskos.impl.SKOSValidatorShexImpl;
import es.inf.uc3m.kr.vaskos.to.MessageTO;
import es.inf.uc3m.kr.vaskos.to.MessageType;
import es.inf.uc3m.kr.vaskos.to.ValidationContext;


public class ValidatorAppServ {

	public ValidationContext fullValidation (ValidationContext context){

		try {
			SKOSValidator coreValidator = new SKOSValidatorCoreBasicImpl();
			SKOSValidator shexValidator = new SKOSValidatorShexImpl();
			SKOSValidator sparqlValidator = new SKOSValidatorSPARQLImpl();
			coreValidator.setSuccessor(shexValidator);
			shexValidator.setSuccessor(sparqlValidator);
			return coreValidator.validate(context);
		} catch (IOException e) {
			MessageTO error = new MessageTO(e.getMessage(), MessageType.ERROR);
			context.getMessenger().getErrors().add(error );
			context.setValid(Boolean.FALSE);
		}
		return context;

	}
	
	public ValidationContext simpleValidation (ValidationContext context){

		try {
			SKOSValidator shexValidator = new SKOSValidatorShexImpl();
			SKOSValidator sparqlValidator = new SKOSValidatorSPARQLImpl();
			shexValidator.setSuccessor(sparqlValidator);
			return shexValidator.validate(context);
		} catch (IOException e) {
			MessageTO error = new MessageTO(e.getMessage(), MessageType.ERROR);
			context.getMessenger().getErrors().add(error );
			context.setValid(Boolean.FALSE);
		}
		return context;

	}

}
