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
	
	private String []sparqlFiles;

	public SKOSValidatorSPARQLImpl() throws IOException{
	
	}

	public void execute() {
		try {
			this.sparqlFiles = this.context.getSparqlFiles();
			ResourceLoader resourceLoader = new FilesResourceLoader(new String []{this.context.getLocalFile()});
			//FIXME: Move to context
			VaskosModelWrapper wrapper = new JenaRDFModelWrapper(resourceLoader, RDFFormat.TURTLE.getName());
			Model model = (Model) wrapper.getModel();
			boolean valid = Boolean.TRUE;
			
			//FIXME: Move to context
			for(int i = 0; valid && i<this.sparqlFiles.length;i++){
				String queryString = FileUtils.readFile(this.sparqlFiles[i], StandardCharsets.UTF_8);;
				valid = valid && SPARQLUtils.runQuestion(model, queryString);
			}
			this.context.setValid(valid);
		} catch (IOException e) {
			throw new VaskosModelException(e, "Reading File");
		}
	}
	
	

}
