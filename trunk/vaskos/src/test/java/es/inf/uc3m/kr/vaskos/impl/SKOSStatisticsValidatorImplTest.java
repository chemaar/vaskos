package es.inf.uc3m.kr.vaskos.impl;

import static org.junit.Assert.*;

import java.io.IOException;

import junit.framework.Assert;

import org.junit.Test;

import es.inf.uc3m.kr.vaskos.to.MessageTO;
import es.inf.uc3m.kr.vaskos.to.ValidationContext;
import es.inf.uc3m.kr.vaskos.utils.SPARQLRulesLoader;
import es.inf.uc3m.kr.vaskos.utils.SPARQLStatisticsLoader;

public class SKOSStatisticsValidatorImplTest {

	@Test
	public void test() {
		SKOSStatisticsValidatorImpl stats = new SKOSStatisticsValidatorImpl();
		String urlFile = "https://raw.githubusercontent.com/chemaar/vaskos/master/trunk/vaskos/src/test/resources/skos/sparql/test/accepted/mountain-bike-simple.ttl";
		String[] sparqlFiles = SPARQLRulesLoader.getSPARQLRuleFiles();
		String [] sparqlStatsFiles = SPARQLStatisticsLoader.getSPARQLStatisticsFiles();
		ValidationContext context = createValidationContext(urlFile, sparqlFiles,sparqlStatsFiles);
		stats.validate(context);
		for(MessageTO message: context.getMessenger().getInfo()){
			System.out.println(message);
		}
		Assert.assertTrue(sparqlStatsFiles.length==context.getMessenger().getInfo().size());
		
	}

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
	
}
