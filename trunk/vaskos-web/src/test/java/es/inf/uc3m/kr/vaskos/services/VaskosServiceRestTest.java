package es.inf.uc3m.kr.vaskos.services;

import static org.junit.Assert.*;

import java.io.IOException;

import junit.framework.Assert;
import main.ValidatorAppServ;

import org.junit.Test;

import es.inf.uc3m.kr.vaskos.exception.VaskosModelException;
import es.inf.uc3m.kr.vaskos.to.ValidationContext;
import es.inf.uc3m.kr.vaskos.utils.SPARQLRulesLoader;

public class VaskosServiceRestTest {

	private static ValidationContext createValidationContext(String urlFile,
			String[] sparqlFiles) {
		ValidationContext vc = new ValidationContext();
		vc.setUriFile(urlFile);
		try {
			vc.setSparqlFiles(sparqlFiles);
		} catch (IOException e) {
			throw new VaskosModelException(e);
		}
		return vc;
	}
	
	@Test
	public void testSimpleValidateHTTPS() {
		String urlFile = "https://raw.githubusercontent.com/chemaar/vaskos/master/trunk/vaskos/src/test/resources/skos/sparql/test/accepted/mountain-bike-simple.ttl";
		String[] sparqlFiles = SPARQLRulesLoader.getSPARQLRuleFiles();
		ValidationContext vc = createValidationContext(urlFile, sparqlFiles);
		ValidatorAppServ validator = new ValidatorAppServ();
		Assert.assertTrue(validator.simpleValidation(vc).isValid());
	}


}
