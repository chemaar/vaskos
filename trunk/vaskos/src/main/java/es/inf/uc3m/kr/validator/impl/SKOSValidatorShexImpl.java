package es.inf.uc3m.kr.validator.impl;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import org.apache.log4j.Logger;



import scala.Tuple2;
import scala.util.Try;
import es.inf.uc3m.kr.validator.SKOSValidator;
import es.inf.uc3m.kr.validator.SKOSValidatorAdapter;
import es.inf.uc3m.kr.validator.exception.VaskosModelException;
import es.inf.uc3m.kr.validator.loader.FilesResourceLoader;
import es.inf.uc3m.kr.validator.loader.ResourceLoader;
import es.inf.uc3m.kr.validator.to.ValidationContextUtils;
import es.inf.uc3m.kr.validator.utils.FileUtils;
import es.weso.monads.Result;
import es.weso.parser.PrefixMap;
import es.weso.rdf.RDF;
import es.weso.rdf.RDFTriples;
import es.weso.rdfgraph.nodes.IRI;
import es.weso.shex.Schema;
import es.weso.shex.Typing;

public class SKOSValidatorShexImpl extends SKOSValidatorAdapter{
	
	protected static Logger logger = Logger.getLogger(SKOSValidatorShexImpl.class);
	
	private IRI iri;
	private String shexRules;



	public void execute() {
		logger.info("Starting validation in "+this.getClass().getSimpleName()+" with context "+this.context);
		try {
			//StandardCharsets.UTF_8
			this.shexRules = 
					FileUtils.convertStreamToString(
							Thread.currentThread().getContextClassLoader().getResourceAsStream(SKOSValidator.SHEX_FILE));
			this.iri = new IRI (context.getStartingIRI());
			//FIXME: Now it is only Turtle
			//If there is no base model loaded
			if(!this.context.hasBaseModel()){
				ValidationContextUtils.createBaseModel(this.context);
			}
			String rdfContent = FileUtils.readFile(context.getLocalFile(), 
					StandardCharsets.UTF_8);
			Try<Tuple2<Schema, PrefixMap>> loaded = Schema.fromString(this.shexRules);
			Schema schema = loaded.get()._1;
			PrefixMap pm = loaded.get()._2;
			RDFTriples rdftriples = new RDFTriples(null , pm);
			RDF rdf = rdftriples.parse(rdfContent).get();
			Result<Typing> result = Schema.matchSchema(iri, rdf, schema,false);
		//	showResult(Scala2Java.convertRestultsToJava(result));
			this.context.setValid(result.isValid());
			logger.info("Finish validation in "+this.getClass().getSimpleName()+" with context "+this.context);
		} catch (IOException e) {
			this.context.setValid(Boolean.FALSE);
			System.out.println("Validating in "+this.getClass().getSimpleName()+" with context "+this.context);
			throw new VaskosModelException(e);
		}
	}
	
	static void showResult(java.util.List<java.util.Map<IRI, java.util.Set<IRI>>> results){
		for(java.util.Map<IRI, java.util.Set<IRI>> converted: results){
			for(IRI key:converted.keySet()){
				System.out.println(key.str());
				java.util.Set<IRI> values = converted.get(key);
				for(IRI value:values){
					System.out.println("\t"+value.str());
				}
			}
		}
	}

}
