package es.inf.uc3m.kr.validator.impl;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import org.openrdf.rio.RDFFormat;

import com.hp.hpl.jena.rdf.model.Model;

import es.inf.uc3m.kr.validator.SKOSValidator;
import es.inf.uc3m.kr.validator.exception.VaskosModelException;
import es.inf.uc3m.kr.validator.loader.FilesResourceLoader;
import es.inf.uc3m.kr.validator.loader.JenaRDFModelWrapper;
import es.inf.uc3m.kr.validator.loader.ResourceLoader;
import es.inf.uc3m.kr.validator.loader.VaskosModelWrapper;
import es.inf.uc3m.kr.validator.utils.FileUtils;
import es.inf.uc3m.kr.validator.utils.SPARQLUtils;
import es.weso.rdfgraph.nodes.IRI;

public class SKOSValidatorSPARQLImpl implements SKOSValidator{
	
	private String []sparqlFiles;

	public SKOSValidatorSPARQLImpl(String []sparqlFiles) throws IOException{
		this.sparqlFiles = sparqlFiles;
	}

	public boolean validate(String file) {
		try {
			ResourceLoader resourceLoader = new FilesResourceLoader(new String []{file});
			VaskosModelWrapper wrapper = new JenaRDFModelWrapper(resourceLoader, RDFFormat.TURTLE.getName());
			Model model = (Model) wrapper.getModel();
			boolean valid = Boolean.TRUE;
			
			for(int i = 0; valid && i<this.sparqlFiles.length;i++){
				String queryString = FileUtils.readFile(this.sparqlFiles[i], StandardCharsets.UTF_8);;
				valid = valid && SPARQLUtils.runQuestion(model, queryString);
			}
			return valid;
		} catch (IOException e) {
			throw new VaskosModelException(e, "Reading File");
		}
	}
	
	

}
