package es.inf.uc3m.kr.validator.impl;

import static org.junit.Assert.*;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import junit.framework.Assert;

import org.apache.commons.lang3.tuple.Pair;
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
	
//	@Test
//	public void testAccept() throws URISyntaxException, IOException {
//
//		String [] rdfFiles = new String []{
//				"src/test/resources/skos/test/sources/accepted/consistent-2.ttl",
//				"src/test/resources/skos/test/sources/accepted/consistent-3.ttl",
//				"src/test/resources/skos/test/sources/accepted/consistent-4.ttl",
//				"src/test/resources/skos/test/sources/accepted/s2.ttl",
//				"src/test/resources/skos/test/sources/accepted/s3.ttl",
//				"src/test/resources/skos/test/sources/accepted/s4.ttl",
//				"src/test/resources/skos/test/sources/accepted/s5.ttl",
//				"src/test/resources/skos/test/sources/accepted/s6.ttl",
//				//"src/test/resources/skos/test/sources/accepted/consistent-5.ttl", // Stackoverflow
//				"src/test/resources/skos/test/sources/accepted/consistent-6.ttl",
//				"src/test/resources/skos/test/sources/accepted/consistent-7.ttl",
//				//"src/test/resources/skos/test/sources/accepted/consistent-8.ttl" //Stackoverflow
//				//"src/test/resources/skos/test/sources/accepted/consistent-9.ttl",// SPARQL 
//				"src/test/resources/skos/test/sources/accepted/s13.ttl",
//				"src/test/resources/skos/test/sources/accepted/consistent-10.ttl"
//		};
//		SKOSValidatorShexImpl validator = new SKOSValidatorShexImpl(shexFile, iri);
//		for(int i = 0; i<rdfFiles.length;i++){
//			System.out.println("Validating "+rdfFiles[i]);
//			Assert.assertTrue(validator.validate(rdfFiles[i]));
//		}
//
//	}
	
	@Test
	public void testAccept_Consistent_2() {
		try{
			URI iri = new URI("http://example.org/MyConcept");
			String shexFile = "src/main/resources/skos/shex/rules/skos-concept.shex";
			String rdfFile = "src/test/resources/skos/test/sources/accepted/consistent-2.ttl";
			Assert.assertTrue(executeTest(iri, shexFile, rdfFile));
		}catch (Exception e){
			e.printStackTrace();
			Assert.assertTrue(Boolean.FALSE);
		}

	}

	@Test
	public void testAccept_Consistent_3() {
		try{
			URI iri = new URI("http://example.org/MyConcept");
			String shexFile = "src/main/resources/skos/shex/rules/skos-concept.shex";
			String rdfFile = "src/test/resources/skos/test/sources/accepted/consistent-3.ttl";
			Assert.assertTrue(executeTest(iri, shexFile, rdfFile));
		}catch (Exception e){
			e.printStackTrace();
			Assert.assertTrue(Boolean.FALSE);
		}

	}
	
	@Test
	public void testAccept_Consistent_4() {
		try{
			URI iri = new URI("http://example.org/MyConcept");
			String shexFile = "src/main/resources/skos/shex/rules/skos-concept.shex";
			String rdfFile = "src/test/resources/skos/test/sources/accepted/consistent-4.ttl";
			Assert.assertTrue(executeTest(iri, shexFile, rdfFile));
		}catch (Exception e){
			e.printStackTrace();
			Assert.assertTrue(Boolean.FALSE);
		}

	}
	
	@Test
	public void testAccept_Consistent_S2() {
		try{
			URI iri = new URI("http://example.org/MyConcept");
			String shexFile = "src/main/resources/skos/shex/rules/skos-concept.shex";
			String rdfFile = "src/test/resources/skos/test/sources/accepted/s2.ttl";
			Assert.assertTrue(executeTest(iri, shexFile, rdfFile));
		}catch (Exception e){
			e.printStackTrace();
			Assert.assertTrue(Boolean.FALSE);
		}
	}
	
	@Test
	public void testAccept_Consistent_S3() {
		try{
			URI iri = new URI("http://example.org/MyConcept");
			String shexFile = "src/main/resources/skos/shex/rules/skos-concept.shex";
			String rdfFile = "src/test/resources/skos/test/sources/accepted/s3.ttl";
			Assert.assertTrue(executeTest(iri, shexFile, rdfFile));
		}catch (Exception e){
			e.printStackTrace();
			Assert.assertTrue(Boolean.FALSE);
		}
	}
	
	
	@Test
	public void testAccept_Consistent_S4() {
		try{
			URI iri = new URI("http://example.org/MyConcept");
			String shexFile = "src/main/resources/skos/shex/rules/skos-concept.shex";
			String rdfFile = "src/test/resources/skos/test/sources/accepted/s4.ttl";
			Assert.assertTrue(executeTest(iri, shexFile, rdfFile));
		}catch (Exception e){
			e.printStackTrace();
			Assert.assertTrue(Boolean.FALSE);
		}
	}
	
	@Test
	public void testAccept_Consistent_S5() {
		try{
			URI iri = new URI("http://example.org/MyConcept");
			String shexFile = "src/main/resources/skos/shex/rules/skos-concept.shex";
			String rdfFile = "src/test/resources/skos/test/sources/accepted/s5.ttl";
			Assert.assertTrue(executeTest(iri, shexFile, rdfFile));
		}catch (Exception e){
			e.printStackTrace();
			Assert.assertTrue(Boolean.FALSE);
		}
	}
	
	
	@Test
	public void testAccept_Consistent_S6() {
		try{
			URI iri = new URI("http://example.org/MyConcept");
			String shexFile = "src/main/resources/skos/shex/rules/skos-concept.shex";
			String rdfFile = "src/test/resources/skos/test/sources/accepted/s6.ttl";
			Assert.assertTrue(executeTest(iri, shexFile, rdfFile));
		}catch (Exception e){
			e.printStackTrace();
			Assert.assertTrue(Boolean.FALSE);
		}
	}
	
	@Test
	public void testAccept_Consistent_5() {
		try{
			URI iri = new URI("http://example.org/MyConcept");
			String shexFile = "src/main/resources/skos/shex/rules/skos-concept.shex";
			String rdfFile = "src/test/resources/skos/test/sources/accepted/consistent-5.ttl";
			Assert.assertTrue(executeTest(iri, shexFile, rdfFile));
		}catch (Exception e){
			e.printStackTrace();
			Assert.assertTrue(Boolean.FALSE);
		}

	}
	
	@Test
	public void testAccept_Consistent_6() {
		try{
			URI iri = new URI("http://example.org/MyConcept");
			String shexFile = "src/main/resources/skos/shex/rules/skos-concept.shex";
			String rdfFile = "src/test/resources/skos/test/sources/accepted/consistent-6.ttl";
			Assert.assertTrue(executeTest(iri, shexFile, rdfFile));
		}catch (Exception e){
			e.printStackTrace();
			Assert.assertTrue(Boolean.FALSE);
		}

	}
	
	@Test
	public void testAccept_Consistent_7() {
		try{
			URI iri = new URI("http://example.org/MyConcept");
			String shexFile = "src/main/resources/skos/shex/rules/skos-concept.shex";
			String rdfFile = "src/test/resources/skos/test/sources/accepted/consistent-7.ttl";
			Assert.assertTrue(executeTest(iri, shexFile, rdfFile));
		}catch (Exception e){
			e.printStackTrace();
			Assert.assertTrue(Boolean.FALSE);
		}

	}
	
	//FIXME: Checked with SPARQL @Test
	@Test
	public void testAccept_Consistent_8() {
		try{
			URI iri = new URI("http://example.org/MyConcept");
			String shexFile = "src/main/resources/skos/shex/rules/skos-concept.shex";
			String rdfFile = "src/test/resources/skos/test/sources/accepted/consistent-8.ttl";
			Assert.assertTrue(executeTest(iri, shexFile, rdfFile));
		}catch (Exception e){
			e.printStackTrace();
			Assert.assertTrue(Boolean.FALSE);
		}

	}
	
	@Test
	public void testAccept_Consistent_9() {
		try{
			URI iri = new URI("http://example.org/MyConcept");
			String shexFile = "src/main/resources/skos/shex/rules/skos-concept.shex";
			String rdfFile = "src/test/resources/skos/test/sources/accepted/consistent-9.ttl";
			Assert.assertTrue(executeTest(iri, shexFile, rdfFile));
		}catch (Exception e){
			e.printStackTrace();
			Assert.assertTrue(Boolean.FALSE);
		}

	}
	
	@Test
	public void testAccept_Consistent_10() {
		try{
			URI iri = new URI("http://example.org/MyConcept");
			String shexFile = "src/main/resources/skos/shex/rules/skos-concept.shex";
			String rdfFile = "src/test/resources/skos/test/sources/accepted/consistent-10.ttl";
			Assert.assertTrue(executeTest(iri, shexFile, rdfFile));
		}catch (Exception e){
			e.printStackTrace();
			Assert.assertTrue(Boolean.FALSE);
		}

	}
	
	//FIXME: On-line version works
	@Test
	public void testAccept_S13() {
		try{
			URI iri = new URI("http://example.org/MyConcept");
			String shexFile = "src/main/resources/skos/shex/rules/skos-concept.shex";
			String rdfFile = "src/test/resources/skos/test/sources/accepted/s13.ttl";
			Assert.assertTrue(executeTest(iri, shexFile, rdfFile));
		}catch (Exception e){
			e.printStackTrace();
			Assert.assertTrue(Boolean.FALSE);
		}
	}
    //FIXME: On-line version works
	@Test
	public void testAccept_16() {
		try{
			URI iri = new URI("http://example.org/MyClass");
			String shexFile = "src/main/resources/skos/shex/rules/skos-concept.shex";
			String rdfFile = "src/test/resources/skos/test/sources/accepted/consistent-16.ttl";
			Assert.assertTrue(executeTest(iri, shexFile, rdfFile));
		}catch (Exception e){
			e.printStackTrace();
			Assert.assertTrue(Boolean.FALSE);
		}
	}
	
    //FIXME: On-line version works
	@Test
	public void testAccept_17() {
		try{
			URI iri = new URI("http://example.org/Love");
			String shexFile = "src/main/resources/skos/shex/rules/skos-concept.shex";
			String rdfFile = "src/test/resources/skos/test/sources/accepted/consistent-17.ttl";
			Assert.assertTrue(executeTest(iri, shexFile, rdfFile));
		}catch (Exception e){
			e.printStackTrace();
			Assert.assertTrue(Boolean.FALSE);
		}
	}
	
    //FIXME: On-line version works
	@Test
	public void testAccept_18() {
		try{
			URI iri = new URI("http://example.org/Colour");
			String shexFile = "src/main/resources/skos/shex/rules/skos-concept.shex";
			String rdfFile = "src/test/resources/skos/test/sources/accepted/consistent-18.ttl";
			Assert.assertTrue(executeTest(iri, shexFile, rdfFile));
		}catch (Exception e){
			e.printStackTrace();
			Assert.assertTrue(Boolean.FALSE);
		}
	}
    //FIXME: On-line version works
	@Test
	public void testAccept_19() {
		try{
			URI iri = new URI("http://example.org/Love");
			String shexFile = "src/main/resources/skos/shex/rules/skos-concept.shex";
			String rdfFile = "src/test/resources/skos/test/sources/accepted/consistent-19.ttl";
			Assert.assertTrue(executeTest(iri, shexFile, rdfFile));
		}catch (Exception e){
			e.printStackTrace();
			Assert.assertTrue(Boolean.FALSE);
		}
	}
	
	

	@Test
	public void testAccept_20() {
		try{
			URI iri = new URI("http://example.org/MyConcept");
			String shexFile = "src/main/resources/skos/shex/rules/skos-concept.shex";
			String rdfFile = "src/test/resources/skos/test/sources/accepted/consistent-20.ttl";
			Assert.assertTrue(executeTest(iri, shexFile, rdfFile));
		}catch (Exception e){
			e.printStackTrace();
			Assert.assertTrue(Boolean.FALSE);
		}
	}
	
	@Test
	public void testAccept_21() {
		try{
			URI iri = new URI("http://example.org/Potassium");
			String shexFile = "src/main/resources/skos/shex/rules/skos-concept.shex";
			String rdfFile = "src/test/resources/skos/test/sources/accepted/consistent-21.ttl";
			Assert.assertTrue(executeTest(iri, shexFile, rdfFile));
		}catch (Exception e){
			e.printStackTrace();
			Assert.assertTrue(Boolean.FALSE);
		}
	}
	
	@Test
	public void testAccept_22() {
		try{
			URI iri = new URI("http://example.org/MyResource");
			String shexFile = "src/main/resources/skos/shex/rules/skos-concept.shex";
			String rdfFile = "src/test/resources/skos/test/sources/accepted/consistent-22.ttl";
			Assert.assertTrue(executeTest(iri, shexFile, rdfFile));
		}catch (Exception e){
			e.printStackTrace();
			Assert.assertTrue(Boolean.FALSE);
		}
	}
	
	
	@Test
	public void testAccept_23() {
		try{
			URI iri = new URI("http://example.org/MyResource");
			String shexFile = "src/main/resources/skos/shex/rules/skos-concept.shex";
			String rdfFile = "src/test/resources/skos/test/sources/accepted/consistent-23.ttl";
			Assert.assertTrue(executeTest(iri, shexFile, rdfFile));
		}catch (Exception e){
			e.printStackTrace();
			Assert.assertTrue(Boolean.FALSE);
		}
	}
	
	
	@Test
	public void testAccept_24() {
		try{
			URI iri = new URI("http://example.org/Protein");
			String shexFile = "src/main/resources/skos/shex/rules/skos-concept.shex";
			String rdfFile = "src/test/resources/skos/test/sources/accepted/consistent-24.ttl";
			Assert.assertTrue(executeTest(iri, shexFile, rdfFile));
		}catch (Exception e){
			e.printStackTrace();
			Assert.assertTrue(Boolean.FALSE);
		}
	}
	
	
	
	//Helper MEthods
	protected static boolean executeTest(URI iri, String shexFile, String rdfFile) throws IOException{
		SKOSValidatorShexImpl validator = new SKOSValidatorShexImpl(shexFile, iri);
		return validator.validate(rdfFile);
	}

	@Test
	public void testRejected_2() throws URISyntaxException, IOException {
		URI iri = new URI("http://example.org/MyConcept");
		String shexFile = "src/main/resources/skos/shex/rules/skos-concept.shex";
		String rdfFile = "src/test/resources/skos/test/sources/rejected/rejected-2.ttl";
		SKOSValidatorShexImpl validator = new SKOSValidatorShexImpl(shexFile, iri);
		Assert.assertFalse(validator.validate(rdfFile));
	}

}
