package es.inf.uc3m.kr.validator.impl;

import java.net.URI;

import org.apache.log4j.Logger;
import org.semanticweb.skos.SKOSDataset;
import org.semanticweb.skosapibinding.SKOSManager;

import es.inf.uc3m.kr.validator.SKOSValidatorAdapter;
import es.inf.uc3m.kr.validator.exception.VaskosModelException;

public class SKOSValidatorCoreBasicImpl extends SKOSValidatorAdapter{
	protected static Logger logger = Logger.getLogger(SKOSValidatorCoreBasicImpl.class);

public void execute(){
		try{
			logger.info("Starting validation in "+this.getClass().getSimpleName()+" with context "+this.context);
			SKOSManager manager = new SKOSManager();
			//1-Load SKOS ontology
//			SKOSDataset skosCoreOntology = 
//					manager.loadDataset(
//							Thread.currentThread().getContextClassLoader().getResource(SKOS_ONTOLOGY_FILE).toURI());
			URI inputSource = new URI(context.getLocalFile());
			//		Thread.currentThread().getContextClassLoader().getResource(context.getLocalFile()).toURI();
			//2-Load SKOS dataset, 2.1 Load new SKOS definitions?
			SKOSDataset dataSet = manager.loadDataset(inputSource);
			this.context.setValid(Boolean.TRUE);
			logger.info("Finish validation in "+this.getClass().getSimpleName()+" with context "+this.context);
		}catch(Exception e){
			this.context.setValid(Boolean.FALSE);
			logger.error("Validating in "+this.getClass().getSimpleName()+" with context "+this.context,e);
			throw new VaskosModelException(e);
		}


	}

}
