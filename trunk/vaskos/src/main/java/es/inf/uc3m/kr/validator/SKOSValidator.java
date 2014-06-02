package es.inf.uc3m.kr.validator;

import es.inf.uc3m.kr.validator.to.ValidationContext;



public interface SKOSValidator {
	
	static String SKOS_ONTOLOGY_FILE = "skos/skos.rdf";
	static String SHEX_FILE = "skos/shex/rules/skos-concept.shex";
	
	public ValidationContext validate (ValidationContext context);
	

}
