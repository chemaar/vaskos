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
	public void testReject_12() throws IOException {
		String rdfFile = "skos/test/sources/rejected/rejected-12.ttl";
		String[] sparqlFiles = new String []{"src/test/resources/skos/sparql/test/rules/s13.sparql"};
		SKOSValidatorSPARQLImpl validator = new SKOSValidatorSPARQLImpl(sparqlFiles);
		Assert.assertFalse(validator.validate(rdfFile));
	}
	
	@Test
	public void testReject_13() throws IOException {
		String rdfFile = "skos/test/sources/rejected/rejected-13.ttl";
		String[] sparqlFiles = new String []{"src/test/resources/skos/sparql/test/rules/s13.sparql"};
		SKOSValidatorSPARQLImpl validator = new SKOSValidatorSPARQLImpl(sparqlFiles);
		Assert.assertFalse(validator.validate(rdfFile));
	}
	
	@Test
	public void testReject_14() throws IOException {
		String rdfFile = "skos/test/sources/rejected/rejected-14.ttl";
		String[] sparqlFiles = new String []{"src/test/resources/skos/sparql/test/rules/s13.sparql"};
		SKOSValidatorSPARQLImpl validator = new SKOSValidatorSPARQLImpl(sparqlFiles);
		Assert.assertFalse(validator.validate(rdfFile));
	}
	
	@Test
	public void testReject_15() throws IOException {
		String rdfFile = "skos/test/sources/rejected/rejected-15.ttl";
		String[] sparqlFiles = new String []{"src/test/resources/skos/sparql/test/rules/s13.sparql"};
		SKOSValidatorSPARQLImpl validator = new SKOSValidatorSPARQLImpl(sparqlFiles);
		Assert.assertFalse(validator.validate(rdfFile));
	}
	
	
	@Test
	public void testAccept_S14() throws IOException {
		String rdfFile = "skos/test/sources/accepted/s14.ttl";
		String[] sparqlFiles = new String []{"src/test/resources/skos/sparql/test/rules/s14.sparql"};
		SKOSValidatorSPARQLImpl validator = new SKOSValidatorSPARQLImpl(sparqlFiles);
		Assert.assertTrue(validator.validate(rdfFile));
	}
	
	@Test
	public void testReject_S14() throws IOException {
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
	
	@Test
	public void testAccept_Consistent_16() throws IOException {
		String rdfFile = "skos/test/sources/accepted/consistent-16.ttl";
		String[] sparqlFiles = new String []{"src/test/resources/skos/sparql/test/rules/s13.sparql"};
		SKOSValidatorSPARQLImpl validator = new SKOSValidatorSPARQLImpl(sparqlFiles);
		Assert.assertTrue(validator.validate(rdfFile));
	}
	
	@Test
	public void testAccept_Consistent_17() throws IOException {
		String rdfFile = "skos/test/sources/accepted/consistent-17.ttl";
		String[] sparqlFiles = new String []{"src/test/resources/skos/sparql/test/rules/s13.sparql"};
		SKOSValidatorSPARQLImpl validator = new SKOSValidatorSPARQLImpl(sparqlFiles);
		Assert.assertTrue(validator.validate(rdfFile));
	}
	
	
	@Test
	public void testAccept_Consistent_18() throws IOException {
		String rdfFile = "skos/test/sources/accepted/consistent-18.ttl";
		String[] sparqlFiles = new String []{"src/test/resources/skos/sparql/test/rules/s13.sparql"};
		SKOSValidatorSPARQLImpl validator = new SKOSValidatorSPARQLImpl(sparqlFiles);
		Assert.assertTrue(validator.validate(rdfFile));
	}
	
	
	@Test
	public void testAccept_Consistent_19() throws IOException {
		String rdfFile = "skos/test/sources/accepted/consistent-19.ttl";
		String[] sparqlFiles = new String []{"src/test/resources/skos/sparql/test/rules/s13.sparql"};
		SKOSValidatorSPARQLImpl validator = new SKOSValidatorSPARQLImpl(sparqlFiles);
		Assert.assertTrue(validator.validate(rdfFile));
	}
}
