package es.inf.uc3m.kr.validator.impl;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SKOSValidatorCoreOntologyImplTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testValidate() {
		SKOSValidatorCoreOntologyImpl validator = new SKOSValidatorCoreOntologyImpl();
		validator.validate("skos/mountain-bike-simple-test.ttl");
	}

}
