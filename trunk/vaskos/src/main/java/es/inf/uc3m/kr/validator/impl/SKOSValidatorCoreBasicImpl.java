package es.inf.uc3m.kr.validator.impl;

import java.net.URI;

import org.semanticweb.skos.SKOSDataset;
import org.semanticweb.skosapibinding.SKOSManager;

import es.inf.uc3m.kr.validator.SKOSValidator;
import es.inf.uc3m.kr.validator.SKOSValidatorAdapter;
import es.inf.uc3m.kr.validator.to.ValidationContext;

public class SKOSValidatorCoreBasicImpl extends SKOSValidatorAdapter{

public void execute(){
		try{
			SKOSManager manager = new SKOSManager();
			//1-Load SKOS ontology
			SKOSDataset skosCoreOntology = manager.loadDataset(Thread.currentThread().getContextClassLoader().getResource(SKOS_ONTOLOGY_FILE).toURI());
			URI inputSource = Thread.currentThread().getContextClassLoader().getResource(context.getLocalFile()).toURI();
			//2-Load SKOS dataset, 2.1 Load new SKOS definitions?
			SKOSDataset dataSet = manager.loadDataset(inputSource);

		}catch(Exception e){
			e.printStackTrace();
		}


	}

}
