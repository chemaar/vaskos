

import java.io.IOException;

import es.inf.uc3m.kr.validator.SKOSValidator;
import es.inf.uc3m.kr.validator.impl.SKOSValidatorCoreBasicImpl;
import es.inf.uc3m.kr.validator.impl.SKOSValidatorSPARQLImpl;
import es.inf.uc3m.kr.validator.impl.SKOSValidatorShexImpl;
import es.inf.uc3m.kr.validator.to.MessageTO;
import es.inf.uc3m.kr.validator.to.MessageType;
import es.inf.uc3m.kr.validator.to.ValidationContext;


public class ValidatorAppServ {

	public ValidationContext validate (ValidationContext context){

		try {
			SKOSValidator coreValidator = new SKOSValidatorCoreBasicImpl();
			SKOSValidator shexValidator = new SKOSValidatorShexImpl();
			SKOSValidator sparqlValidator;
			sparqlValidator = new SKOSValidatorSPARQLImpl();
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

}
