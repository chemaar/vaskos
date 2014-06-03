import static org.junit.Assert.*;

import java.io.IOException;

import junit.framework.Assert;

import org.junit.Test;

import es.inf.uc3m.kr.validator.to.ValidationContext;
import es.inf.uc3m.kr.validator.utils.SPARQLRulesLoader;


public class ValidatorAppServTest {

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
	public void testValidate() {
		String rdfFile = "file:///G://repositories/github/vaskos/trunk/vaskos/src/test/resources/skos/sparql/test/accepted/mountain-bike-simple.ttl";
		String[] sparqlFiles = SPARQLRulesLoader.getSPARQLRuleFiles();
		ValidationContext vc = createValidationContext(rdfFile, sparqlFiles);
		ValidatorAppServ validator = new ValidatorAppServ();
		Assert.assertTrue(validator.validate(vc).isValid());
	}

}
