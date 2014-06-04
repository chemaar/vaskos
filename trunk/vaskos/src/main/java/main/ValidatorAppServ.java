package main;


import java.io.IOException;

import es.inf.uc3m.kr.vaskos.SKOSValidator;
import es.inf.uc3m.kr.vaskos.exception.VaskosModelException;
import es.inf.uc3m.kr.vaskos.impl.SKOSStatisticsValidatorImpl;
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
			SKOSValidator statsValidator = new SKOSStatisticsValidatorImpl();
			SKOSValidator coreValidator = new SKOSValidatorCoreBasicImpl();
			SKOSValidator shexValidator = new SKOSValidatorShexImpl();
			SKOSValidator sparqlValidator = new SKOSValidatorSPARQLImpl();
			statsValidator.setSuccessor(coreValidator);
			coreValidator.setSuccessor(shexValidator);
			shexValidator.setSuccessor(sparqlValidator);
			ValidationContext endContext = statsValidator.validate(context);
			endContext.setEndTime(System.nanoTime());
			return endContext;
		}catch (VaskosModelException e) {
			MessageTO error = new MessageTO(e.getMessage(), MessageType.ERROR);
			context.getMessenger().getErrors().add(error );
			context.setValid(Boolean.FALSE);
		}  
		catch (IOException e) {
			MessageTO error = new MessageTO(e.getMessage(), MessageType.ERROR);
			context.getMessenger().getErrors().add(error );
			context.setValid(Boolean.FALSE);
		}
		return context;

	}

	public ValidationContext simpleValidation (ValidationContext context){
		try {
			context.setStartTime(System.currentTimeMillis());
			SKOSValidator statsValidator = new SKOSStatisticsValidatorImpl();
			SKOSValidator shexValidator = new SKOSValidatorShexImpl();
			SKOSValidator sparqlValidator = new SKOSValidatorSPARQLImpl();
			statsValidator.setSuccessor(shexValidator);
			shexValidator.setSuccessor(sparqlValidator);
			//The validation must start in the first one
			ValidationContext endContext = statsValidator.validate(context);
			endContext.setEndTime(System.currentTimeMillis());
			return endContext;
		}catch (VaskosModelException e) {
			MessageTO error = new MessageTO(e.getMessage(), MessageType.ERROR);
			context.getMessenger().getErrors().add(error );
			context.setValid(Boolean.FALSE);
		} 
		catch (IOException e) {
			MessageTO error = new MessageTO(e.getMessage(), MessageType.ERROR);
			context.getMessenger().getErrors().add(error );
			context.setValid(Boolean.FALSE);
		}
		return context;

	}

}
