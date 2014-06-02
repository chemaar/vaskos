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
		vc.setLocalFile("skos/mountain-bike-simple-test.ttl");
		SKOSValidatorCoreBasicImpl validator = new SKOSValidatorCoreBasicImpl();
		validator.validate(vc);
	}

}
