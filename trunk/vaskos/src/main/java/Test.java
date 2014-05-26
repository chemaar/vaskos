import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

import org.mindswap.pellet.jena.PelletInfGraph;
import org.mindswap.pellet.jena.PelletReasonerFactory;

import scala.Tuple2;
import scala.collection.convert.Decorators.AsJavaCollection;
import scala.collection.immutable.List;
import scala.collection.immutable.Map;
import scala.collection.immutable.Set;
import scala.util.Try;

import com.hp.hpl.jena.ontology.Individual;
import com.hp.hpl.jena.ontology.OntClass;
import com.hp.hpl.jena.ontology.OntDocumentManager;
import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.ontology.OntModelSpec;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.reasoner.ValidityReport;
import com.hp.hpl.jena.vocabulary.OWL;

import es.inf.uc3m.kr.validator.SKOSValidator;
import es.inf.uc3m.kr.validator.utils.Scala2Java;
import es.weso.monads.Result;
import es.weso.parser.PrefixMap;
import es.weso.rdf.RDF;
import es.weso.rdf.reader.RDFFromWeb;
import es.weso.rdfgraph.nodes.IRI;
import es.weso.rdfgraph.statements.RDFTriple;
import es.weso.shex.PrefixMaps;
import es.weso.rdf.RDFTriples;
import es.weso.shex.Schema;
import es.weso.shex.ShapeSyntax.ShEx;
import es.weso.shex.Typing;



public class Test {

	static String readFile(String path, Charset encoding) 
			  throws IOException 	{
			  byte[] encoded = Files.readAllBytes(Paths.get(path));
			  return new String(encoded, encoding);
			}
	

	public static void main(String[] args) throws IOException, URISyntaxException {
		String sheXontent = readFile("src/main/resources/shex/issue.shex", StandardCharsets.UTF_8);
		String rdfContent = readFile("src/main/resources/shex/issue.ttl", StandardCharsets.UTF_8);
		IRI iri = new IRI(new URI("http://example.org/x"));
		Try<Tuple2<Schema, PrefixMap>> loaded = Schema.fromString(sheXontent);
		Schema schema = loaded.get()._1;
		PrefixMap pm = loaded.get()._2;
		RDFTriples rdftriples = new RDFTriples(null , pm);
		RDF rdf = rdftriples.parse(rdfContent).get();
		Result<Typing> result = Schema.matchSchema(iri, rdf, schema);
		java.util.List<java.util.Map<IRI, java.util.Set<IRI>>> results = Scala2Java.convertRestultsToJava(result);
		for(java.util.Map<IRI, java.util.Set<IRI>> converted: results){
			for(IRI key:converted.keySet()){
				System.out.println(key.str());
				java.util.Set<IRI> values = converted.get(key);
				for(IRI value:values){
					System.out.println("\t"+value.str());
				}
			}
		}
		//System.out.println(result);

////		OntDocumentManager dm = OntDocumentManager.getInstance();
////		dm.setProcessImports(false);
////		OntModelSpec spec = new OntModelSpec(PelletReasonerFactory.THE_SPEC);
////		spec.setDocumentManager(dm);     
////		//spec.setReasoner(reasoner);
////
////
////		OntModel model = ModelFactory.createOntologyModel( spec, null );
////		model.read(Thread.currentThread().getContextClassLoader().getResourceAsStream(SKOSValidator.SKOS_ONTOLOGY_FILE), "");  
////		model.read(Thread.currentThread().getContextClassLoader().getResourceAsStream("skos/mountain-bike-simple.ttl"), "","TURTLE");  
////		PelletInfGraph infModel = ((PelletInfGraph) model.getGraph());
////		//infModel.classify();
////
////
////
////		ValidityReport validity = model.validate();
////		for (Iterator i = validity.getReports(); i.hasNext(); ) {
////			System.out.println(" - " + i.next());
////		}
	}


}
