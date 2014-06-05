package es.inf.uc3m.kr.vaskos.services;

import static org.junit.Assert.*;

import java.io.IOException;

import junit.framework.Assert;
import main.ValidatorAppServ;

import org.junit.Test;

import es.inf.uc3m.kr.vaskos.exception.VaskosModelException;
import es.inf.uc3m.kr.vaskos.to.ValidationContext;
import es.inf.uc3m.kr.vaskos.utils.SPARQLRulesLoader;
import es.inf.uc3m.kr.vaskos.utils.SPARQLStatisticsLoader;

public class VaskosServiceRestTest {

	private static ValidationContext createValidationContext(String urlFile){
		ValidationContext vc = new ValidationContext();
		vc.setUriFile(urlFile);
		return vc;
		
	}
	
	@Test
	public void testSimpleValidateHTTPS() throws IOException {
		String urlFile = "https://raw.githubusercontent.com/chemaar/vaskos/master/trunk/vaskos/src/test/resources/skos/sparql/test/accepted/mountain-bike-simple.ttl";
		ValidationContext vc = createValidationContext(urlFile);
		ValidatorAppServ validator = new ValidatorAppServ();
		Assert.assertTrue(validator.simpleValidation(vc).isValid());
	}


}
