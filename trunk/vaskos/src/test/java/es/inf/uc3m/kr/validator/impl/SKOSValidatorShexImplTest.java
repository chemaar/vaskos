package es.inf.uc3m.kr.validator.impl;

import static org.junit.Assert.*;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import junit.framework.Assert;

import org.junit.Test;

import es.weso.rdfgraph.nodes.IRI;

public class SKOSValidatorShexImplTest {

//	@Test
	public void testSimpleAccept() throws URISyntaxException, IOException {
		URI iri = new URI("http://example.org/x");
		String shexFile = "src/test/resources/shex/test/rules/issue.shex";
		String rdfFile = "src/test/resources/shex/test/sources/accepted/issue.ttl";
		SKOSValidatorShexImpl validator = new SKOSValidatorShexImpl(shexFile, iri);
		Assert.assertTrue(validator.validate(rdfFile));
	}
	
//	@Test
	public void testSimpleReject() throws URISyntaxException, IOException {
		URI iri = new URI("http://example.org/x");
		String shexFile = "src/test/resources/shex/test/rules/issue.shex";
		String rdfFile = "src/test/resources/shex/test/sources/rejected/issue.ttl";
		SKOSValidatorShexImpl validator = new SKOSValidatorShexImpl(shexFile, iri);
		Assert.assertFalse(validator.validate(rdfFile));
	}
	
	@Test
	public void testAccept() throws URISyntaxException, IOException {
		URI iri = new URI("http://example.org/MyConcept");
		String shexFile = "src/test/resources/skos/test/shex/rules/skos-concept.shex";
		String [] rdfFiles = new String []{
				"src/test/resources/skos/test/sources/accepted/consistent-2.ttl",
				"src/test/resources/skos/test/sources/accepted/consistent-3.ttl",
				"src/test/resources/skos/test/sources/accepted/consistent-4.ttl",
				"src/test/resources/skos/test/sources/accepted/s2.ttl",
				"src/test/resources/skos/test/sources/accepted/s3.ttl",
				"src/test/resources/skos/test/sources/accepted/s4.ttl",
				"src/test/resources/skos/test/sources/accepted/s5.ttl",
				"src/test/resources/skos/test/sources/accepted/s6.ttl",
				//"src/test/resources/skos/test/sources/accepted/consistent-5.ttl", // Stackoverflow
				"src/test/resources/skos/test/sources/accepted/consistent-6.ttl",
				"src/test/resources/skos/test/sources/accepted/consistent-7.ttl",
				"src/test/resources/skos/test/sources/accepted/consistent-8.ttl"
		};
		SKOSValidatorShexImpl validator = new SKOSValidatorShexImpl(shexFile, iri);
		for(int i = 0; i<rdfFiles.length;i++){
			System.out.println("Validating "+rdfFiles[i]);
			Assert.assertTrue(validator.validate(rdfFiles[i]));
		}

	}

	//@Test
	public void testRejected_2() throws URISyntaxException, IOException {
		URI iri = new URI("http://example.org/MyConcept");
		String shexFile = "src/test/resources/skos/test/shex/rules/skos-concept.shex";
		String rdfFile = "src/test/resources/skos/test/sources/rejected/rejected-2.ttl";
		SKOSValidatorShexImpl validator = new SKOSValidatorShexImpl(shexFile, iri);
		Assert.assertFalse(validator.validate(rdfFile));
	}

}
