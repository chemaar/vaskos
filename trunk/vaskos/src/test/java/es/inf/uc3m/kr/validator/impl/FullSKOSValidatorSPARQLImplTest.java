package es.inf.uc3m.kr.validator.impl;

import static org.junit.Assert.*;

import java.io.IOException;

import junit.framework.Assert;

import org.junit.Test;

import es.inf.uc3m.kr.validator.to.ValidationContext;
import es.inf.uc3m.kr.validator.utils.SPARQLRulesLoader;

public class FullSKOSValidatorSPARQLImplTest {

	protected static final String SRC_TEST_RESOURCES = "src/test/resources/";
	private static ValidationContext createValidationContext(String rdfFile,
			String[] sparqlFiles) {
		ValidationContext vc = new ValidationContext();
		vc.setLocalFile(rdfFile);
		try {
			vc.setSparqlFiles(sparqlFiles);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return vc;
	}

	@Test
	public void testAccept() throws IOException {
		String rdfFile = SRC_TEST_RESOURCES+"skos/sparql/test/accepted/mountain-bike-simple.ttl";
		String[] sparqlFiles = SPARQLRulesLoader.getSPARQLRuleFiles();
		ValidationContext vc = createValidationContext(rdfFile, sparqlFiles);
		SKOSValidatorSPARQLImpl validator = new SKOSValidatorSPARQLImpl();
		Assert.assertTrue(validator.validate(vc).isValid());
	}


	
	
}
