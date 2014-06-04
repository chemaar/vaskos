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
			context.setStartTime(System.nanoTime());
			SKOSValidator coreValidator = new SKOSValidatorCoreBasicImpl();
			SKOSValidator shexValidator = new SKOSValidatorShexImpl();
			SKOSValidator sparqlValidator = new SKOSValidatorSPARQLImpl();
			coreValidator.setSuccessor(shexValidator);
			shexValidator.setSuccessor(sparqlValidator);
			ValidationContext endContext = coreValidator.validate(context);
			endContext.setEndTime(System.nanoTime());
			return endContext;
		} catch (IOException e) {
			MessageTO error = new MessageTO(e.getMessage(), MessageType.ERROR);
			context.getMessenger().getErrors().add(error );
			context.setValid(Boolean.FALSE);
		}
		return context;

	}
	
	public ValidationContext simpleValidation (ValidationContext context){
		try {
			context.setStartTime(System.currentTimeMillis());
			SKOSValidator shexValidator = new SKOSValidatorShexImpl();
			SKOSValidator sparqlValidator = new SKOSValidatorSPARQLImpl();
			shexValidator.setSuccessor(sparqlValidator);
			ValidationContext endContext = shexValidator.validate(context);
			endContext.setEndTime(System.currentTimeMillis());
			return endContext;
		} catch (IOException e) {
			MessageTO error = new MessageTO(e.getMessage(), MessageType.ERROR);
			context.getMessenger().getErrors().add(error );
			context.setValid(Boolean.FALSE);
		}
		return context;

	}

}
