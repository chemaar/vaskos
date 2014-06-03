package es.inf.uc3m.kr.validator.impl;

import static org.junit.Assert.*;

import java.io.IOException;

import junit.framework.Assert;

import org.junit.Test;

import es.inf.uc3m.kr.validator.to.ValidationContext;

public class SKOSValidatorSPARQLImplTest {

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

	public void testAccept() throws IOException {
		String rdfFile = "skos/sparql/test/accepted/mountain-bike-simple.ttl";
		String[] sparqlFiles = new String []{"skos/sparql/rules/s7.sparql"};
		ValidationContext vc = createValidationContext(rdfFile, sparqlFiles);
		SKOSValidatorSPARQLImpl validator = new SKOSValidatorSPARQLImpl();
		Assert.assertTrue(validator.validate(vc).isValid());
	}


	
	@Test
	public void testAccept_Consistent_8() throws IOException {
		String rdfFile = "skos/test/sources/accepted/consistent-8.ttl";
		String[] sparqlFiles = new String []{"skos/sparql/rules/consistent-8.sparql"};
		ValidationContext vc = createValidationContext(rdfFile, sparqlFiles);
		SKOSValidatorSPARQLImpl validator = new SKOSValidatorSPARQLImpl();
		Assert.assertTrue(validator.validate(vc).isValid());
	}

	@Test
	public void testAccept_Consistent_9() throws IOException {
		String rdfFile = "skos/test/sources/accepted/consistent-9.ttl";
		String[] sparqlFiles = new String []{"skos/sparql/rules/consistent-9.sparql"};
		ValidationContext vc = createValidationContext(rdfFile, sparqlFiles);
		SKOSValidatorSPARQLImpl validator = new SKOSValidatorSPARQLImpl();
		Assert.assertTrue(validator.validate(vc).isValid());
	}
	
	@Test
	public void testReject_12() throws IOException {
		String rdfFile = "skos/test/sources/rejected/rejected-12.ttl";
		String[] sparqlFiles = new String []{"skos/sparql/rules/s13.sparql"};
		ValidationContext vc = createValidationContext(rdfFile, sparqlFiles);
		SKOSValidatorSPARQLImpl validator = new SKOSValidatorSPARQLImpl();
		Assert.assertFalse(validator.validate(vc).isValid());
	}
	
	@Test
	public void testReject_13() throws IOException {
		String rdfFile = "skos/test/sources/rejected/rejected-13.ttl";
		String[] sparqlFiles = new String []{"skos/sparql/rules/s13.sparql"};
		ValidationContext vc = createValidationContext(rdfFile, sparqlFiles);
		SKOSValidatorSPARQLImpl validator = new SKOSValidatorSPARQLImpl();
		Assert.assertFalse(validator.validate(vc).isValid());
	}
	
	@Test
	public void testReject_14() throws IOException {
		String rdfFile = "skos/test/sources/rejected/rejected-14.ttl";
		String[] sparqlFiles = new String []{"skos/sparql/rules/s13.sparql"};
		ValidationContext vc = createValidationContext(rdfFile, sparqlFiles);
		SKOSValidatorSPARQLImpl validator = new SKOSValidatorSPARQLImpl();
		Assert.assertFalse(validator.validate(vc).isValid());
	}
	
	@Test
	public void testReject_15() throws IOException {
		String rdfFile = "skos/test/sources/rejected/rejected-15.ttl";
		String[] sparqlFiles = new String []{"skos/sparql/rules/s13.sparql"};
		ValidationContext vc = createValidationContext(rdfFile, sparqlFiles);
		SKOSValidatorSPARQLImpl validator = new SKOSValidatorSPARQLImpl();
		Assert.assertFalse(validator.validate(vc).isValid());
	}
	
	
	@Test
	public void testAccept_S14() throws IOException {
		String rdfFile = "skos/test/sources/accepted/s14.ttl";
		String[] sparqlFiles = new String []{"skos/sparql/rules/s14.sparql"};
		ValidationContext vc = createValidationContext(rdfFile, sparqlFiles);
		SKOSValidatorSPARQLImpl validator = new SKOSValidatorSPARQLImpl();
		Assert.assertTrue(validator.validate(vc).isValid());
	}
	
	@Test
	public void testReject_S14() throws IOException {
		String rdfFile = "skos/test/sources/rejected/rejected-s14.ttl";
		String[] sparqlFiles = new String []{"skos/sparql/rules/s14.sparql"};
		ValidationContext vc = createValidationContext(rdfFile, sparqlFiles);
		SKOSValidatorSPARQLImpl validator = new SKOSValidatorSPARQLImpl();
		Assert.assertFalse(validator.validate(vc).isValid());
	}
	

	
	@Test
	public void testAccept_Consistent_10() throws IOException {
		String rdfFile = "skos/test/sources/accepted/consistent-10.ttl";
		String[] sparqlFiles = new String []{"skos/sparql/rules/s14.sparql"};
		ValidationContext vc = createValidationContext(rdfFile, sparqlFiles);
		SKOSValidatorSPARQLImpl validator = new SKOSValidatorSPARQLImpl();
		Assert.assertTrue(validator.validate(vc).isValid());
	}
	
	@Test
	public void testAccept_Consistent_11() throws IOException {
		String rdfFile = "skos/test/sources/accepted/consistent-11.ttl";
		String[] sparqlFiles = new String []{"skos/sparql/rules/s14.sparql"};
		ValidationContext vc = createValidationContext(rdfFile, sparqlFiles);
		SKOSValidatorSPARQLImpl validator = new SKOSValidatorSPARQLImpl();
		Assert.assertTrue(validator.validate(vc).isValid());
	}
	
	@Test
	public void testAccept_Consistent_16() throws IOException {
		String rdfFile = "skos/test/sources/accepted/consistent-16.ttl";
		String[] sparqlFiles = new String []{"skos/sparql/rules/s13.sparql"};
		ValidationContext vc = createValidationContext(rdfFile, sparqlFiles);
		SKOSValidatorSPARQLImpl validator = new SKOSValidatorSPARQLImpl();
		Assert.assertTrue(validator.validate(vc).isValid());
	}
	
	@Test
	public void testAccept_Consistent_17() throws IOException {
		String rdfFile = "skos/test/sources/accepted/consistent-17.ttl";
		String[] sparqlFiles = new String []{"skos/sparql/rules/s13.sparql"};
		ValidationContext vc = createValidationContext(rdfFile, sparqlFiles);
		SKOSValidatorSPARQLImpl validator = new SKOSValidatorSPARQLImpl();
		Assert.assertTrue(validator.validate(vc).isValid());
	}
	
	
	@Test
	public void testAccept_Consistent_18() throws IOException {
		String rdfFile = "skos/test/sources/accepted/consistent-18.ttl";
		String[] sparqlFiles = new String []{"skos/sparql/rules/s13.sparql"};
		ValidationContext vc = createValidationContext(rdfFile, sparqlFiles);
		SKOSValidatorSPARQLImpl validator = new SKOSValidatorSPARQLImpl();
		Assert.assertTrue(validator.validate(vc).isValid());
	}
	
	
	@Test
	public void testAccept_Consistent_19() throws IOException {
		String rdfFile = "skos/test/sources/accepted/consistent-19.ttl";
		String[] sparqlFiles = new String []{"skos/sparql/rules/s13.sparql"};
		ValidationContext vc = createValidationContext(rdfFile, sparqlFiles);
		SKOSValidatorSPARQLImpl validator = new SKOSValidatorSPARQLImpl();
		Assert.assertTrue(validator.validate(vc).isValid());
	}
	
//	@Test
//	public void testAccept_S25() throws IOException {
//		String rdfFile = "skos/test/sources/accepted/s25.ttl";
//		String[] sparqlFiles = new String []{"skos/sparql/rules/s25.sparql"};
//		SKOSValidatorSPARQLImpl validator = new SKOSValidatorSPARQLImpl();
//		Assert.assertTrue(validator.validate(vc).isValid());
//	}
//	

	

	

	@Test
	public void testReject_S26() throws IOException {
		String rdfFile = "skos/test/sources/rejected/rejected-s26.ttl";
		String[] sparqlFiles = new String []{"skos/sparql/rules/s26.sparql"};
		SKOSValidatorSPARQLImpl validator = new SKOSValidatorSPARQLImpl();
		ValidationContext vc = createValidationContext(rdfFile, sparqlFiles);
		Assert.assertFalse(validator.validate(vc).isValid());
	}
	
	@Test
	public void testReject_S26_1() throws IOException {
		String rdfFile = "skos/test/sources/rejected/rejected-s26-1.ttl";
		String[] sparqlFiles = new String []{"skos/sparql/rules/s26-1.sparql"};
		ValidationContext vc = createValidationContext(rdfFile, sparqlFiles);
		SKOSValidatorSPARQLImpl validator = new SKOSValidatorSPARQLImpl();
		Assert.assertFalse(validator.validate(vc).isValid());
	}
	
	
	@Test
	public void testReject_S26_2() throws IOException {
		String rdfFile = "skos/test/sources/rejected/rejected-s26-2.ttl";
		String[] sparqlFiles = new String []{"skos/sparql/rules/s26-2.sparql"};
		ValidationContext vc = createValidationContext(rdfFile, sparqlFiles);
		SKOSValidatorSPARQLImpl validator = new SKOSValidatorSPARQLImpl();
		Assert.assertFalse(validator.validate(vc).isValid());
	}
	
	
	
	@Test
	public void testReject_S26_3() throws IOException {
		String rdfFile = "skos/test/sources/rejected/rejected-s26-3.ttl";
		String[] sparqlFiles = new String []{"skos/sparql/rules/s26-3.sparql"};
		ValidationContext vc = createValidationContext(rdfFile, sparqlFiles);
		SKOSValidatorSPARQLImpl validator = new SKOSValidatorSPARQLImpl();
		Assert.assertFalse(validator.validate(vc).isValid());
	}
	
	
	
	@Test
	public void testReject_S27() throws IOException {
		String rdfFile = "skos/test/sources/rejected/rejected-s27.ttl";
		String[] sparqlFiles = new String []{"skos/sparql/rules/s27.sparql"};
		ValidationContext vc = createValidationContext(rdfFile, sparqlFiles);
		SKOSValidatorSPARQLImpl validator = new SKOSValidatorSPARQLImpl();
		Assert.assertFalse(validator.validate(vc).isValid());
	}
	

	@Test
	public void testReject_S27_1() throws IOException {
		String rdfFile = "skos/test/sources/rejected/rejected-s27-1.ttl";
		String[] sparqlFiles = new String []{"skos/sparql/rules/s27-1.sparql"};
		ValidationContext vc = createValidationContext(rdfFile, sparqlFiles);
		SKOSValidatorSPARQLImpl validator = new SKOSValidatorSPARQLImpl();
		Assert.assertFalse(validator.validate(vc).isValid());
	}
	
	@Test
	public void testReject_S27_2() throws IOException {
		String rdfFile = "skos/test/sources/rejected/rejected-s27-2.ttl";
		String[] sparqlFiles = new String []{"skos/sparql/rules/s27-2.sparql"};
		ValidationContext vc = createValidationContext(rdfFile, sparqlFiles);
		SKOSValidatorSPARQLImpl validator = new SKOSValidatorSPARQLImpl();
		Assert.assertFalse(validator.validate(vc).isValid());
	}
	
	@Test
	public void testReject_S27_3() throws IOException {
		String rdfFile = "skos/test/sources/rejected/rejected-s27-3.ttl";
		String[] sparqlFiles = new String []{"skos/sparql/rules/s27-3.sparql"};
		ValidationContext vc = createValidationContext(rdfFile, sparqlFiles);
		SKOSValidatorSPARQLImpl validator = new SKOSValidatorSPARQLImpl();
		Assert.assertFalse(validator.validate(vc).isValid());
	}
	
	@Test
	public void testReject_S27_4() throws IOException {
		String rdfFile = "skos/test/sources/rejected/rejected-s27-4";
		String[] sparqlFiles = new String []{"skos/sparql/rules/s27-4.sparql"};
		
		SKOSValidatorSPARQLImpl validator = new SKOSValidatorSPARQLImpl();
		for(int i = 1; i<=4; i++){
			ValidationContext vc = createValidationContext(rdfFile+"-"+i+".ttl", sparqlFiles);
			Assert.assertFalse(validator.validate(vc).isValid());
		}

	}
	
	@Test
	public void testReject_S27_5() throws IOException {
		String rdfFile = "skos/test/sources/rejected/rejected-s27-5";
		String[] sparqlFiles = new String []{"skos/sparql/rules/s27-5.sparql"};
		SKOSValidatorSPARQLImpl validator = new SKOSValidatorSPARQLImpl();
		for(int i = 1; i<=4; i++){
			ValidationContext vc = createValidationContext(rdfFile+"-"+i+".ttl", sparqlFiles);
			Assert.assertFalse(validator.validate(vc).isValid());
		}

	}
	
	@Test
	public void testReject_S27_6() throws IOException {
		String rdfFile = "skos/test/sources/rejected/rejected-s27-6.ttl";
		String[] sparqlFiles = new String []{"skos/sparql/rules/s27-6.sparql"};
		ValidationContext vc = createValidationContext(rdfFile, sparqlFiles);
		SKOSValidatorSPARQLImpl validator = new SKOSValidatorSPARQLImpl();
		Assert.assertFalse(validator.validate(vc).isValid());
	}
	
	@Test
	public void testReject_S43() throws IOException {
		String rdfFile = "skos/test/sources/rejected/rejected-s43.ttl";
		String[] sparqlFiles = new String []{"skos/sparql/rules/s43.sparql"};
		ValidationContext vc = createValidationContext(rdfFile, sparqlFiles);
		SKOSValidatorSPARQLImpl validator = new SKOSValidatorSPARQLImpl();
		Assert.assertFalse(validator.validate(vc).isValid());
	}
	
	@Test
	public void testReject_S43_1() throws IOException {
		String rdfFile = "skos/test/sources/rejected/rejected-s43-1.ttl";
		String[] sparqlFiles = new String []{"skos/sparql/rules/s43-1.sparql"};
		ValidationContext vc = createValidationContext(rdfFile, sparqlFiles);
		SKOSValidatorSPARQLImpl validator = new SKOSValidatorSPARQLImpl();
		Assert.assertFalse(validator.validate(vc).isValid());
	}
	
	@Test
	public void testReject_S43_2() throws IOException {
		String rdfFile = "skos/test/sources/rejected/rejected-s43-2";
		String[] sparqlFiles = new String []{"skos/sparql/rules/s43-2.sparql"};
		SKOSValidatorSPARQLImpl validator = new SKOSValidatorSPARQLImpl();
		for(int i = 1; i<=4; i++){
			ValidationContext vc = createValidationContext(rdfFile+"-"+i+".ttl", sparqlFiles);
			Assert.assertFalse(validator.validate(vc).isValid());
		}

	}
	
	@Test
	public void testReject_S46() throws IOException {
		String rdfFile = "skos/test/sources/rejected/rejected-s46";
		String[] sparqlFiles = new String []{"skos/sparql/rules/s46.sparql"};
		SKOSValidatorSPARQLImpl validator = new SKOSValidatorSPARQLImpl();
		for(int i = 1; i<=4; i++){
			ValidationContext vc = createValidationContext(rdfFile+"-"+i+".ttl", sparqlFiles);
			Assert.assertFalse(validator.validate(vc).isValid());
		}

	}
	
}
