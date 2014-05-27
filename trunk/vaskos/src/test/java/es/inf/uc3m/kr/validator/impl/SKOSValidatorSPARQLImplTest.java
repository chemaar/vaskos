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
	public void testAccept_Consistent_8() throws IOException {
		String rdfFile = "skos/test/sources/accepted/consistent-8.ttl";
		String[] sparqlFiles = new String []{"src/test/resources/skos/sparql/test/rules/consistent-8.sparql"};
		SKOSValidatorSPARQLImpl validator = new SKOSValidatorSPARQLImpl(sparqlFiles);
		Assert.assertTrue(validator.validate(rdfFile));
	}

	@Test
	public void testAccept_Consistent_9() throws IOException {
		String rdfFile = "skos/test/sources/accepted/consistent-9.ttl";
		String[] sparqlFiles = new String []{"src/test/resources/skos/sparql/test/rules/consistent-9.sparql"};
		SKOSValidatorSPARQLImpl validator = new SKOSValidatorSPARQLImpl(sparqlFiles);
		Assert.assertTrue(validator.validate(rdfFile));
	}
	
	@Test
	public void testAccept_S14() throws IOException {
		String rdfFile = "skos/test/sources/accepted/s14.ttl";
		String[] sparqlFiles = new String []{"src/test/resources/skos/sparql/test/rules/s14.sparql"};
		SKOSValidatorSPARQLImpl validator = new SKOSValidatorSPARQLImpl(sparqlFiles);
		Assert.assertTrue(validator.validate(rdfFile));
	}
	
	@Test
	public void testReject_14() throws IOException {
		String rdfFile = "skos/test/sources/rejected/rejected-s14.ttl";
		String[] sparqlFiles = new String []{"src/test/resources/skos/sparql/test/rules/s14.sparql"};
		SKOSValidatorSPARQLImpl validator = new SKOSValidatorSPARQLImpl(sparqlFiles);
		Assert.assertFalse(validator.validate(rdfFile));
	}
	
	@Test
	public void testAccept_Consistent_10() throws IOException {
		String rdfFile = "skos/test/sources/accepted/consistent-10.ttl";
		String[] sparqlFiles = new String []{"src/test/resources/skos/sparql/test/rules/s14.sparql"};
		SKOSValidatorSPARQLImpl validator = new SKOSValidatorSPARQLImpl(sparqlFiles);
		Assert.assertTrue(validator.validate(rdfFile));
	}
	
	@Test
	public void testAccept_Consistent_11() throws IOException {
		String rdfFile = "skos/test/sources/accepted/consistent-11.ttl";
		String[] sparqlFiles = new String []{"src/test/resources/skos/sparql/test/rules/s14.sparql"};
		SKOSValidatorSPARQLImpl validator = new SKOSValidatorSPARQLImpl(sparqlFiles);
		Assert.assertTrue(validator.validate(rdfFile));
	}
}
