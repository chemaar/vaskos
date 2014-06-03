import static org.junit.Assert.*;

import java.io.IOException;

import junit.framework.Assert;

import org.junit.Test;

import es.inf.uc3m.kr.validator.to.ValidationContext;
import es.inf.uc3m.kr.validator.utils.SPARQLRulesLoader;


public class ValidatorAppServTest {

	private static ValidationContext createValidationContext(String urlFile,
			String[] sparqlFiles) {
		ValidationContext vc = new ValidationContext();
		vc.setUriFile(urlFile);
		try {
			vc.setSparqlFiles(sparqlFiles);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return vc;
	}
	@Test
	public void testFullValidate() {
		//FIXME: URIS
		String urlFile = "file:///G://repositories/github/vaskos/trunk/vaskos/src/test/resources/skos/sparql/test/accepted/mountain-bike-simple.ttl";
		String[] sparqlFiles = SPARQLRulesLoader.getSPARQLRuleFiles();
		ValidationContext vc = createValidationContext(urlFile, sparqlFiles);
		ValidatorAppServ validator = new ValidatorAppServ();
		Assert.assertTrue(validator.fullValidation(vc).isValid());
	}

	@Test
	public void testSimpleValidate() {
		String urlFile = "file:///G://repositories/github/vaskos/trunk/vaskos/src/test/resources/skos/sparql/test/accepted/mountain-bike-simple.ttl";
		String[] sparqlFiles = SPARQLRulesLoader.getSPARQLRuleFiles();
		ValidationContext vc = createValidationContext(urlFile, sparqlFiles);
		ValidatorAppServ validator = new ValidatorAppServ();
		Assert.assertTrue(validator.simpleValidation(vc).isValid());
	}

}
