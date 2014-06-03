package es.inf.uc3m.kr.vaskos;

import es.inf.uc3m.kr.vaskos.to.ValidationContext;



public interface SKOSValidator {
	
	static String SKOS_ONTOLOGY_FILE = "skos/skos.rdf";
	static String SHEX_FILE = "skos/shex/rules/skos-concept.shex";
	
	public ValidationContext validate (ValidationContext context);
	public void setSuccessor(SKOSValidator successor);

}
