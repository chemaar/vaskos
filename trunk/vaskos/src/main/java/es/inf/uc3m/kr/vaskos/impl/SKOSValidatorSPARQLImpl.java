package es.inf.uc3m.kr.vaskos.impl;

import java.io.IOException;

import org.apache.log4j.Logger;

import com.hp.hpl.jena.rdf.model.Model;

import es.inf.uc3m.kr.vaskos.SKOSValidatorAdapter;
import es.inf.uc3m.kr.vaskos.to.MessageTO;
import es.inf.uc3m.kr.vaskos.to.MessageType;
import es.inf.uc3m.kr.vaskos.to.ValidationContextUtils;
import es.inf.uc3m.kr.vaskos.utils.SPARQLRulesLoader;
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
		String []sparqlFiles = this.context.getSparqlFiles();
		for(int i = 0; valid && i<sparqlQueries.length;i++){
			valid = valid && SPARQLUtils.runQuestion(model, sparqlQueries[i]);
			if(!valid){
				logger.info("This query has failed:");
				logger.info(sparqlQueries[i]);
				String template = SPARQLRulesLoader.getMessage(sparqlFiles[i]);
				String text = template; //Change if needed
				MessageTO message = new MessageTO();
				message.setLevel(MessageType.ERROR);
				message.setMessage(text);
				this.context.getMessenger().getErrors().add(message);
			}
		}
		logger.info("SPARQL queries have been performed and valid is "+valid+".");
		this.context.setValid(valid);
		logger.info("Finish validation in "+this.getClass().getSimpleName()+" with context "+this.context);
	}
	

}
