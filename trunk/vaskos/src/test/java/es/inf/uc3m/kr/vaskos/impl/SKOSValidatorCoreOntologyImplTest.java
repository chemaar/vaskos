package es.inf.uc3m.kr.vaskos.impl;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import es.inf.uc3m.kr.vaskos.impl.SKOSValidatorCoreOntologyImpl;
import es.inf.uc3m.kr.vaskos.to.ValidationContext;

public class SKOSValidatorCoreOntologyImplTest {

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
		vc.setLocalFile(SRC_TEST_RESOURCES+"skos/mountain-bike-simple-test.ttl");
		SKOSValidatorCoreOntologyImpl validator = new SKOSValidatorCoreOntologyImpl();
		validator.validate(vc);
	}

}
