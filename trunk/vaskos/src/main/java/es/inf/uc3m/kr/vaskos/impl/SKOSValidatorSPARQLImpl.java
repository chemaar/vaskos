package es.inf.uc3m.kr.vaskos.impl;

import java.io.IOException;

import org.apache.log4j.Logger;

import com.hp.hpl.jena.rdf.model.Model;

import es.inf.uc3m.kr.vaskos.SKOSValidatorAdapter;
import es.inf.uc3m.kr.vaskos.exception.VaskosModelException;
import es.inf.uc3m.kr.vaskos.to.ValidationContextUtils;
import es.inf.uc3m.kr.vaskos.utils.SPARQLUtils;

public class SKOSValidatorSPARQLImpl extends SKOSValidatorAdapter{
	protected static Logger logger = Logger.getLogger(SKOSValidatorSPARQLImpl.class);

	public SKOSValidatorSPARQLImpl() throws IOException{
	
	}

	public void execute() {
		logger.info("Starting validation in "+this.getClass().getSimpleName()+" with context "+this.context);
		String[] sparqlQueries = this.context.getStringSPARQLqueries();
		if(!this.context.hasBaseModel()){
			ValidationContextUtils.createBaseModel(this.context);
		}

		Model model = this.context.getBaseModel();
		boolean valid = Boolean.TRUE;
try{
		for(int i = 0; valid && i<sparqlQueries.length;i++){
			logger.info("Running question:");
			logger.info(sparqlQueries[i]+" model is null "+model);
			valid = valid && SPARQLUtils.runQuestion(model, sparqlQueries[i]);
			if(!valid){
				logger.info("This query has failed:");
				logger.info(sparqlQueries[i]);
			}
		}
		logger.info("SPARQL queries have been performed and valid is "+valid+".");
		this.context.setValid(valid);
		logger.info("Finish validation in "+this.getClass().getSimpleName()+" with context "+this.context);
	}catch(VaskosModelException e){
		logger.error(e);
	}
	}
	

}
