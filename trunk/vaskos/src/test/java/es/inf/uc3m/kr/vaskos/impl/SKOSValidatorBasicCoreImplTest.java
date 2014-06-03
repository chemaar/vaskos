package es.inf.uc3m.kr.vaskos.impl;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import es.inf.uc3m.kr.vaskos.impl.SKOSValidatorCoreBasicImpl;
import es.inf.uc3m.kr.vaskos.to.ValidationContext;


public class SKOSValidatorBasicCoreImplTest {

	protected static final String SRC_TEST_RESOURCES = "src/test/resources/";
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testValidate() {
		ValidationContext vc = new ValidationContext();
		vc.setUriFile("file:///G://repositories/github/vaskos/trunk/vaskos/src/test/resources/skos/sparql/test/accepted/mountain-bike-simple.ttl");
		SKOSValidatorCoreBasicImpl validator = new SKOSValidatorCoreBasicImpl();
		validator.validate(vc);
	}

}
