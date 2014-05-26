package es.inf.uc3m.kr.validator.impl;

import java.io.IOException;
import java.net.URI;
import java.nio.charset.StandardCharsets;

import scala.Tuple2;
import scala.util.Try;
import es.inf.uc3m.kr.validator.SKOSValidator;
import es.inf.uc3m.kr.validator.exception.VaskosModelException;
import es.inf.uc3m.kr.validator.utils.FileUtils;
import es.inf.uc3m.kr.validator.utils.Scala2Java;
import es.weso.monads.Result;
import es.weso.parser.PrefixMap;
import es.weso.rdf.RDF;
import es.weso.rdf.RDFTriples;
import es.weso.rdfgraph.nodes.IRI;
import es.weso.shex.Schema;
import es.weso.shex.Typing;

public class SKOSValidatorShexImpl implements SKOSValidator{
	
	private String shexFile;
	private IRI iri;
	private String shexRules;

	public SKOSValidatorShexImpl(String shexFile,URI iri) throws IOException{
		this.shexFile = shexFile;
		this.iri = new IRI (iri);
		this.shexRules = FileUtils.readFile(this.shexFile, StandardCharsets.UTF_8);
	}

	public boolean validate(String file) {
		try {
			//FIXME: Now it is only Turtle
			String rdfContent = FileUtils.readFile(file, StandardCharsets.UTF_8);
			Try<Tuple2<Schema, PrefixMap>> loaded = Schema.fromString(this.shexRules);
			Schema schema = loaded.get()._1;
			PrefixMap pm = loaded.get()._2;
			RDFTriples rdftriples = new RDFTriples(null , pm);
			RDF rdf = rdftriples.parse(rdfContent).get();
			Result<Typing> result = Schema.matchSchema(iri, rdf, schema);
			//showResult(Scala2Java.convertRestultsToJava(result));
			System.out.println(result.isValid());

			return result.isValid();
		} catch (IOException e) {
			throw new VaskosModelException(e, "Reading File");
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
