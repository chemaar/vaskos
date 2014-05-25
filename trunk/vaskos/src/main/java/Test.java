import java.util.Iterator;

import org.mindswap.pellet.jena.PelletInfGraph;
import org.mindswap.pellet.jena.PelletReasonerFactory;

import com.hp.hpl.jena.ontology.Individual;
import com.hp.hpl.jena.ontology.OntClass;
import com.hp.hpl.jena.ontology.OntDocumentManager;
import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.ontology.OntModelSpec;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.reasoner.ValidityReport;
import com.hp.hpl.jena.vocabulary.OWL;

import es.inf.uc3m.kr.validator.SKOSValidator;


public class Test {

	public static void main(String[] args) {

		OntDocumentManager dm = OntDocumentManager.getInstance();
		dm.setProcessImports(false);
		OntModelSpec spec = new OntModelSpec(PelletReasonerFactory.THE_SPEC);
		spec.setDocumentManager(dm);     
		//spec.setReasoner(reasoner);

		
		OntModel model = ModelFactory.createOntologyModel( spec, null );
		model.read(Thread.currentThread().getContextClassLoader().getResourceAsStream(SKOSValidator.SKOS_ONTOLOGY_FILE), "");  
		model.read(Thread.currentThread().getContextClassLoader().getResourceAsStream("skos/mountain-bike-simple.ttl"), "","TURTLE");  
		PelletInfGraph infModel = ((PelletInfGraph) model.getGraph());
		//infModel.classify();
		
		
		
		 ValidityReport validity = model.validate();
		 for (Iterator i = validity.getReports(); i.hasNext(); ) {
	            System.out.println(" - " + i.next());
	        }
	}
		

}
