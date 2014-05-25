package es.inf.uc3m.kr.validator.impl;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class SKOSValidatorBasicCoreImplTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testValidate() {
		SKOSValidatorCoreBasicImpl validator = new SKOSValidatorCoreBasicImpl();
		validator.validate("skos/mountain-bike-simple-test.ttl");
	}

}
