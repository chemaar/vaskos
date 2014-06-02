package es.inf.uc3m.kr.validator.impl;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import org.openrdf.rio.RDFFormat;

import com.hp.hpl.jena.rdf.model.Model;

import es.inf.uc3m.kr.validator.SKOSValidatorAdapter;
import es.inf.uc3m.kr.validator.exception.VaskosModelException;
import es.inf.uc3m.kr.validator.loader.FilesResourceLoader;
import es.inf.uc3m.kr.validator.loader.JenaRDFModelWrapper;
import es.inf.uc3m.kr.validator.loader.ResourceLoader;
import es.inf.uc3m.kr.validator.loader.VaskosModelWrapper;
import es.inf.uc3m.kr.validator.utils.FileUtils;
import es.inf.uc3m.kr.validator.utils.SPARQLUtils;

public class SKOSValidatorSPARQLImpl extends SKOSValidatorAdapter{
	

	public SKOSValidatorSPARQLImpl() throws IOException{
	
	}

	public void execute() {
		String[] sparqlQueries = this.context.getStringSPARQLqueries();
		ResourceLoader resourceLoader = new FilesResourceLoader(new String []{this.context.getLocalFile()});
		//FIXME: Move to context
		VaskosModelWrapper wrapper = new JenaRDFModelWrapper(resourceLoader, RDFFormat.TURTLE.getName());
		Model model = (Model) wrapper.getModel();
		boolean valid = Boolean.TRUE;
		
		for(int i = 0; valid && i<sparqlQueries.length;i++){
			valid = valid && SPARQLUtils.runQuestion(model, sparqlQueries[i]);
		}
		this.context.setValid(valid);
	}
	
	

}
