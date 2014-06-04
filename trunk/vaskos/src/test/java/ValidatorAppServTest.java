import static org.junit.Assert.*;

import java.io.IOException;

import junit.framework.Assert;
import main.ValidatorAppServ;

import org.junit.Test;

import es.inf.uc3m.kr.vaskos.to.ValidationContext;
import es.inf.uc3m.kr.vaskos.utils.SPARQLRulesLoader;
import es.inf.uc3m.kr.vaskos.utils.SPARQLStatisticsLoader;


public class ValidatorAppServTest {

	public static ValidationContext createValidationContext(String urlFile,
			String[] sparqlFiles,
			String[] sparqlStatisticFiles) {
		ValidationContext vc = new ValidationContext();
		vc.setUriFile(urlFile);
		try {
			vc.setSparqlFiles(sparqlFiles);
			vc.setSparqlStatisticFiles(sparqlStatisticFiles);
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
		String [] sparqlStatsFiles = SPARQLStatisticsLoader.getSPARQLStatisticsFiles();
		ValidationContext vc = createValidationContext(urlFile, sparqlFiles,sparqlStatsFiles);
		ValidatorAppServ validator = new ValidatorAppServ();
		Assert.assertTrue(validator.fullValidation(vc).isValid());
	}

	@Test
	public void testSimpleValidate() {
		String urlFile = "file:///G://repositories/github/vaskos/trunk/vaskos/src/test/resources/skos/sparql/test/accepted/mountain-bike-simple.ttl";
		String[] sparqlFiles = SPARQLRulesLoader.getSPARQLRuleFiles();
		String [] sparqlStatsFiles = SPARQLStatisticsLoader.getSPARQLStatisticsFiles();
		ValidationContext vc = createValidationContext(urlFile, sparqlFiles,sparqlStatsFiles);
		ValidatorAppServ validator = new ValidatorAppServ();
		Assert.assertTrue(validator.simpleValidation(vc).isValid());
	}
	
	@Test
	public void testSimpleValidateHTTPS() {
		String urlFile = "https://raw.githubusercontent.com/chemaar/vaskos/master/trunk/vaskos/src/test/resources/skos/sparql/test/accepted/mountain-bike-simple.ttl";
		String[] sparqlFiles = SPARQLRulesLoader.getSPARQLRuleFiles();
		String [] sparqlStatsFiles = SPARQLStatisticsLoader.getSPARQLStatisticsFiles();
		ValidationContext vc = createValidationContext(urlFile, sparqlFiles,sparqlStatsFiles);
		ValidatorAppServ validator = new ValidatorAppServ();
		Assert.assertTrue(validator.simpleValidation(vc).isValid());
	}


}
