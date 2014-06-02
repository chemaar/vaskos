package es.inf.uc3m.kr.validator.impl;

import java.io.IOException;

import org.apache.log4j.Logger;

import com.hp.hpl.jena.rdf.model.Model;

import es.inf.uc3m.kr.validator.SKOSValidatorAdapter;
import es.inf.uc3m.kr.validator.loader.FilesResourceLoader;
import es.inf.uc3m.kr.validator.loader.JenaRDFModelWrapper;
import es.inf.uc3m.kr.validator.loader.ResourceLoader;
import es.inf.uc3m.kr.validator.loader.VaskosModelWrapper;
import es.inf.uc3m.kr.validator.utils.SPARQLUtils;

public class SKOSValidatorSPARQLImpl extends SKOSValidatorAdapter{
	protected static Logger logger = Logger.getLogger(SKOSValidatorSPARQLImpl.class);

	public SKOSValidatorSPARQLImpl() throws IOException{
	
	}

	public void execute() {
		logger.info("Starting validation in "+this.getClass().getSimpleName()+" with context "+this.context);
		String[] sparqlQueries = this.context.getStringSPARQLqueries();
		ResourceLoader resourceLoader = new FilesResourceLoader(new String []{this.context.getLocalFile()});
		VaskosModelWrapper wrapper = new JenaRDFModelWrapper(resourceLoader, this.context.getFormat().getName());
		Model model = (Model) wrapper.getModel();
		boolean valid = Boolean.TRUE;
		
		for(int i = 0; valid && i<sparqlQueries.length;i++){
			valid = valid && SPARQLUtils.runQuestion(model, sparqlQueries[i]);
		}
		this.context.setValid(valid);
		logger.info("Finish validation in "+this.getClass().getSimpleName()+" with context "+this.context);
	}
	
	

}
