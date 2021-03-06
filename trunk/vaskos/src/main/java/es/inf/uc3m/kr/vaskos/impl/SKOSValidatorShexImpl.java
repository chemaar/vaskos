package es.inf.uc3m.kr.vaskos.impl;

import java.io.IOException;





import org.apache.jena.riot.RDFFormat;
import org.apache.log4j.Logger;

import scala.Tuple2;
import scala.util.Try;
import es.inf.uc3m.kr.vaskos.SKOSValidator;
import es.inf.uc3m.kr.vaskos.SKOSValidatorAdapter;
import es.inf.uc3m.kr.vaskos.exception.VaskosModelException;
import es.inf.uc3m.kr.vaskos.to.MessageTO;
import es.inf.uc3m.kr.vaskos.to.MessageType;
import es.inf.uc3m.kr.vaskos.to.ValidationContextUtils;
import es.inf.uc3m.kr.vaskos.utils.FileUtils;
import es.inf.uc3m.kr.vaskos.utils.SPARQLRulesLoader;
import es.weso.monads.Result;
import es.weso.parser.PrefixMap;
import es.weso.rdf.RDF;
import es.weso.rdf.RDFTriples;
import es.weso.rdfgraph.nodes.IRI;
import es.weso.shex.Matcher;
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
			//Only for shexscala
			String rdfContent = this.context.getLines(RDFFormat.TURTLE);
		
			
			Try<Tuple2<Schema, PrefixMap>> loaded = Schema.fromString(this.shexRules);
			Schema schema = loaded.get()._1;
			PrefixMap pm = loaded.get()._2;
			RDFTriples rdftriples = new RDFTriples(null , pm);
			RDF rdf = rdftriples.parse(rdfContent).get();
			Matcher matcher = new Matcher(schema,rdf,false,false);
			Result<Typing> result = matcher.matchIRI_AllLabels(this.iri);
			//Result<Typing> result = Schema.matchSchema(this.iri, rdf, schema,false);
			this.context.setValid(result.isValid());
			if(this.context.isValid()){
				//FIXME: Extract problems from shexscala
				MessageTO message = new MessageTO();
				message.setLevel(MessageType.ERROR);
				message.setMessage("Shex validation has not been sucessful");
				this.context.getMessenger().getErrors().add(message);
			}
			logger.info("Finish validation in "+this.getClass().getSimpleName()+" with context "+this.context);
		} catch (IOException e) {
			this.context.setValid(Boolean.FALSE);
			logger.error("Validating in "+this.getClass().getSimpleName()+" with context "+this.context);
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
