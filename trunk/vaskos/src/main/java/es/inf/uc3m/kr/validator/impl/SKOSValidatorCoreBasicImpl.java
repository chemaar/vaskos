package es.inf.uc3m.kr.validator.impl;

import java.net.URI;

import org.openrdf.rio.RDFFormat;
import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.AddImport;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLImportsDeclaration;
import org.semanticweb.owlapi.model.OWLNamedIndividual;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyChange;
import org.semanticweb.owlapi.model.OWLOntologyManager;
import org.semanticweb.owlapi.reasoner.OWLReasoner;
import org.semanticweb.skos.SKOSDataset;
import org.semanticweb.skos.SKOSInputSource;
import org.semanticweb.skosapibinding.*;

import es.inf.uc3m.kr.validator.SKOSValidator;

public class SKOSValidatorCoreBasicImpl implements SKOSValidator{

	public boolean validate(String file) {
		try{
			SKOSManager manager = new SKOSManager();
			//1-Load SKOS ontology
			SKOSDataset skosCoreOntology = manager.loadDataset(Thread.currentThread().getContextClassLoader().getResource(SKOS_ONTOLOGY_FILE).toURI());
			URI inputSource = Thread.currentThread().getContextClassLoader().getResource(file).toURI();
			//2-Load SKOS dataset, 2.1 Load new SKOS definitions?
			SKOSDataset dataSet = manager.loadDataset(inputSource);
			return Boolean.TRUE;
		}catch(Exception e){
			e.printStackTrace();
		}

		return Boolean.FALSE;
	}

}
