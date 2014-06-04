package es.inf.uc3m.kr.vaskos.impl;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import junit.framework.Assert;

import org.junit.Test;

import es.inf.uc3m.kr.vaskos.SKOSValidator;
import es.inf.uc3m.kr.vaskos.to.ValidationContext;

public class SKOSValidatorShexImplTest {
	

	

private static final String SKOS_SHEX_RULES = SKOSValidator.SHEX_FILE;

	//	@Test
	public void testSimpleAccept() throws URISyntaxException, IOException {
		URI iri = new URI("http://example.org/x");
		String shexFile = "src/test/resources/shex/test/rules/issue.shex";
		String rdfFile = "src/test/resources/shex/test/sources/accepted/issue.ttl";
		ValidationContext vc = createValidationContext(iri, shexFile, rdfFile);
		SKOSValidatorShexImpl validator = new SKOSValidatorShexImpl();
		Assert.assertTrue(validator.validate(vc).isValid());
	}
	
//	@Test
	public void testSimpleReject() throws URISyntaxException, IOException {
		URI iri = new URI("http://example.org/x");
		String shexFile = "src/test/resources/shex/test/rules/issue.shex";
		String rdfFile = "src/test/resources/shex/test/sources/rejected/issue.ttl";
		ValidationContext vc = createValidationContext(iri, shexFile, rdfFile);
		SKOSValidatorShexImpl validator = new SKOSValidatorShexImpl();
		Assert.assertFalse(validator.validate(vc).isValid());
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
			String shexFile = SKOS_SHEX_RULES;
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
			String shexFile = SKOS_SHEX_RULES;
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
			String shexFile = SKOS_SHEX_RULES;
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
			String shexFile = SKOS_SHEX_RULES;
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
			String shexFile = SKOS_SHEX_RULES;
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
			String shexFile = SKOS_SHEX_RULES;
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
			String shexFile = SKOS_SHEX_RULES;
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
			String shexFile = SKOS_SHEX_RULES;
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
			String shexFile = SKOS_SHEX_RULES;
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
			String shexFile = SKOS_SHEX_RULES;
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
			String shexFile = SKOS_SHEX_RULES;
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
			String shexFile = SKOS_SHEX_RULES;
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
			String shexFile = SKOS_SHEX_RULES;
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
			String shexFile = SKOS_SHEX_RULES;
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
			String shexFile = SKOS_SHEX_RULES;
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
			String shexFile = SKOS_SHEX_RULES;
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
			String shexFile = SKOS_SHEX_RULES;
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
			String shexFile = SKOS_SHEX_RULES;
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
			String shexFile = SKOS_SHEX_RULES;
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
			String shexFile = SKOS_SHEX_RULES;
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
			String shexFile = SKOS_SHEX_RULES;
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
			String shexFile = SKOS_SHEX_RULES;
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
			String shexFile = SKOS_SHEX_RULES;
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
			String shexFile = SKOS_SHEX_RULES;
			String rdfFile = "src/test/resources/skos/test/sources/accepted/consistent-24.ttl";
			Assert.assertTrue(executeTest(iri, shexFile, rdfFile));
		}catch (Exception e){
			e.printStackTrace();
			Assert.assertTrue(Boolean.FALSE);
		}
	}
	
	
	//FIXME: It works on-line because of the inheritance and the start element
	@Test
	public void testAccept_40() {
		try{
			URI iri = new URI("http://example.org/MyCollection");
			String shexFile = SKOS_SHEX_RULES;
			String rdfFile = "src/test/resources/skos/test/sources/accepted/consistent-40.ttl";
			Assert.assertTrue(executeTest(iri, shexFile, rdfFile));
		}catch (Exception e){
			e.printStackTrace();
			Assert.assertTrue(Boolean.FALSE);
		}
	}
	
	
	//FIXME: It works on-line because of the inheritance and the start element
	@Test
	public void testAccept_41() {
		try{
			URI iri = new URI("http://example.org/MyOrderedCollection");
			String shexFile = SKOS_SHEX_RULES;
			String rdfFile = "src/test/resources/skos/test/sources/accepted/consistent-41.ttl";
			Assert.assertTrue(executeTest(iri, shexFile, rdfFile));
		}catch (Exception e){
			e.printStackTrace();
			Assert.assertTrue(Boolean.FALSE);
		}
	}

	
	//FIXME: Matches empty
	@Test
	public void testRejectConsistent_45() {
		try{
			URI iri = new URI("http://example.org/A");
			String shexFile = SKOS_SHEX_RULES;
			String rdfFile = "src/test/resources/skos/test/sources/rejected/rejected-45.ttl";
			Assert.assertFalse(executeTest(iri, shexFile, rdfFile));
		}catch (Exception e){
			e.printStackTrace();
			Assert.assertTrue(Boolean.FALSE);
		}
	}
	
	//FIXME: Matches empty
	@Test
	public void testRejectConsistent_46() {
		try{
			URI iri = new URI("http://example.org/A");
			String shexFile = SKOS_SHEX_RULES;
			String rdfFile = "src/test/resources/skos/test/sources/rejected/rejected-46.ttl";
			Assert.assertFalse(executeTest(iri, shexFile, rdfFile));
		}catch (Exception e){
			e.printStackTrace();
			Assert.assertTrue(Boolean.FALSE);
		}
	}
	
	//FIXME: Matches empty
	@Test
	public void testRejectConsistent_47() {
		try{
			URI iri = new URI("http://example.org/A");
			String shexFile = SKOS_SHEX_RULES;
			String rdfFile = "src/test/resources/skos/test/sources/rejected/rejected-47.ttl";
			Assert.assertFalse(executeTest(iri, shexFile, rdfFile));
		}catch (Exception e){
			e.printStackTrace();
			Assert.assertTrue(Boolean.FALSE);
		}
	}
	
	
	@Test
	public void testAccept_48() {
		try{
			URI iri = new URI("http://example.org/A");
			String shexFile = SKOS_SHEX_RULES;
			String rdfFile = "src/test/resources/skos/test/sources/accepted/consistent-48.ttl";
			Assert.assertTrue(executeTest(iri, shexFile, rdfFile));
		}catch (Exception e){
			e.printStackTrace();
			Assert.assertTrue(Boolean.FALSE);
		}
	}

	@Test
	public void testAccept_49() {
		try{
			URI iri = new URI("http://example.org/A");
			String shexFile = SKOS_SHEX_RULES;
			String rdfFile = "src/test/resources/skos/test/sources/accepted/consistent-49.ttl";
			Assert.assertTrue(executeTest(iri, shexFile, rdfFile));
		}catch (Exception e){
			e.printStackTrace();
			Assert.assertTrue(Boolean.FALSE);
		}
	}
	
	
	@Test
	public void testAccept_50() {
		try{
			URI iri = new URI("http://example.org/A");
			String shexFile = SKOS_SHEX_RULES;
			String rdfFile = "src/test/resources/skos/test/sources/accepted/consistent-50.ttl";
			Assert.assertTrue(executeTest(iri, shexFile, rdfFile));
		}catch (Exception e){
			e.printStackTrace();
			Assert.assertTrue(Boolean.FALSE);
		}
	}
	
	@Test
	public void testAccept_51() {
		try{
			URI iri = new URI("http://example.org/A");
			String shexFile = SKOS_SHEX_RULES;
			String rdfFile = "src/test/resources/skos/test/sources/accepted/consistent-51.ttl";
			Assert.assertTrue(executeTest(iri, shexFile, rdfFile));
		}catch (Exception e){
			e.printStackTrace();
			Assert.assertTrue(Boolean.FALSE);
		}
	}
	
	
	
	//Helper MEthods
	protected static boolean executeTest(URI iri, String shexFile, String rdfFile) throws IOException{
		ValidationContext vc = createValidationContext(iri, shexFile, rdfFile);
		SKOSValidatorShexImpl validator = new SKOSValidatorShexImpl();
		return validator.validate(vc).isValid();
	}

	private static ValidationContext createValidationContext(URI iri,
			String shexFile, String rdfFile) {
		ValidationContext vc = new ValidationContext();
		vc.setStartingIRI(iri);
		vc.setShexFile(shexFile);
		vc.setLocalFile(rdfFile);
		return vc;
	}
	
	//FIXME: Online version works
	@Test
	public void testRejected_2() throws URISyntaxException, IOException {
		URI iri = new URI("http://example.org/MyConcept");
		String shexFile = SKOS_SHEX_RULES;
		String rdfFile = "src/test/resources/skos/test/sources/rejected/rejected-2.ttl";
		ValidationContext vc = createValidationContext(iri, shexFile, rdfFile);
		SKOSValidatorShexImpl validator = new SKOSValidatorShexImpl();
		Assert.assertFalse(validator.validate(vc).isValid());
	}

}
