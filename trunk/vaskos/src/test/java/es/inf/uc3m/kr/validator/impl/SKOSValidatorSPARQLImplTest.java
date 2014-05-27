package es.inf.uc3m.kr.validator.impl;

import static org.junit.Assert.*;

import java.io.IOException;

import junit.framework.Assert;

import org.junit.Test;

public class SKOSValidatorSPARQLImplTest {


	public void testAccept() throws IOException {
		String rdfFile = "skos/sparql/test/accepted/mountain-bike-simple.ttl";
		String[] sparqlFiles = new String []{"src/test/resources/skos/sparql/test/rules/s7.sparql"};
		SKOSValidatorSPARQLImpl validator = new SKOSValidatorSPARQLImpl(sparqlFiles);
		Assert.assertTrue(validator.validate(rdfFile));
	}
	
	@Test
	public void testAccept_8() throws IOException {
		String rdfFile = "skos/test/sources/accepted/consistent-8.ttl";
		String[] sparqlFiles = new String []{"src/test/resources/skos/sparql/test/rules/consistent-8.sparql"};
		SKOSValidatorSPARQLImpl validator = new SKOSValidatorSPARQLImpl(sparqlFiles);
		Assert.assertTrue(validator.validate(rdfFile));
	}

	@Test
	public void testAccept_9() throws IOException {
		String rdfFile = "skos/test/sources/accepted/consistent-9.ttl";
		String[] sparqlFiles = new String []{"src/test/resources/skos/sparql/test/rules/consistent-9.sparql"};
		SKOSValidatorSPARQLImpl validator = new SKOSValidatorSPARQLImpl(sparqlFiles);
		Assert.assertTrue(validator.validate(rdfFile));
	}
}
