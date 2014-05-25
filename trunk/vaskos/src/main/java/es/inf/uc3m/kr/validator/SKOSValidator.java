package es.inf.uc3m.kr.validator;

public interface SKOSValidator {
	
	static String SKOS_ONTOLOGY_FILE = "skos/skos.rdf";
	
	public boolean validate (String file);
	

}
