package es.inf.uc3m.kr.validator.impl;

import static org.junit.Assert.*;

import java.io.IOException;

import junit.framework.Assert;

import org.junit.Test;

public class SKOSValidatorSPARQLImplTest {

	@Test
	public void testAccept() throws IOException {
		String rdfFile = "skos/sparql/test/accepted/mountain-bike-simple.ttl";
		String[] sparqlFiles = new String []{"src/test/resources/skos/sparql/test/rules/s7.sparql"};
		SKOSValidatorSPARQLImpl validator = new SKOSValidatorSPARQLImpl(sparqlFiles);
		Assert.assertTrue(validator.validate(rdfFile));
	}

}
