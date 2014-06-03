package es.inf.uc3m.kr.validator.impl;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import es.inf.uc3m.kr.validator.to.ValidationContext;


public class SKOSValidatorBasicCoreImplTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testValidate() {
		ValidationContext vc = new ValidationContext();
		vc.setLocalFile("file:///G://repositories/github/vaskos/trunk/vaskos/src/test/resources/skos/sparql/test/accepted/mountain-bike-simple.ttl");
		SKOSValidatorCoreBasicImpl validator = new SKOSValidatorCoreBasicImpl();
		validator.validate(vc);
	}

}
