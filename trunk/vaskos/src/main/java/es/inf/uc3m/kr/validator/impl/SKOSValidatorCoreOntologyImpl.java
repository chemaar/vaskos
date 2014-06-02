package es.inf.uc3m.kr.validator.impl;

import java.util.Iterator;

import org.mindswap.pellet.jena.PelletReasonerFactory;

import com.hp.hpl.jena.ontology.Individual;
import com.hp.hpl.jena.ontology.OntDocumentManager;
import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.ontology.OntModelSpec;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.reasoner.Reasoner;
import com.hp.hpl.jena.reasoner.ValidityReport;
import com.sun.istack.internal.logging.Logger;

import es.inf.uc3m.kr.validator.SKOSValidator;
import es.inf.uc3m.kr.validator.SKOSValidatorAdapter;
import es.inf.uc3m.kr.validator.to.ValidationContext;

public class SKOSValidatorCoreOntologyImpl extends SKOSValidatorAdapter{
	protected static Logger logger = Logger.getLogger(SKOSValidatorCoreOntologyImpl.class);


 public void execute(){
		try{
			//Reasoner reasoner = PelletReasonerFactory.theInstance().create();
			OntDocumentManager dm = OntDocumentManager.getInstance();
			dm.setProcessImports(false);
			OntModelSpec spec = new OntModelSpec(OntModelSpec.OWL_MEM_RULE_INF);
			spec.setDocumentManager(dm);     
			//spec.setReasoner(reasoner);

			
			OntModel base = ModelFactory.createOntologyModel( spec, null );
			base.read(Thread.currentThread().getContextClassLoader().getResourceAsStream(SKOS_ONTOLOGY_FILE), "");  
			base.read(Thread.currentThread().getContextClassLoader().getResourceAsStream(context.getLocalFile()), "","TURTLE");  
			OntModel inf = ModelFactory.createOntologyModel(spec, base);
			
			 ValidityReport validity = base.validate();
			    if (validity.isValid()) {
			        System.out.println("OK");
			    } else {
			        System.out.println("Conflicts");
			        for (Iterator i = validity.getReports(); i.hasNext(); ) {
			            System.out.println(" - " + i.next());
			        }
			    }
			
//			Individual p1 = base.getIndividual("http://purl.org/krgroup/pbs/p1/resource/Mountain_Bike");
//			// list the asserted types
//			for (Iterator<Resource> i = p1.listRDFTypes(false); i.hasNext(); ) {
//			    System.out.println( p1.getURI() + " is asserted in class " + i.next() );
//			}
//
//			// list the inferred types
//			p1 = inf.getIndividual( "http://purl.org/krgroup/pbs/p1/resource/Mountain_Bike" );
//			for (Iterator<Resource> i = p1.listRDFTypes(false); i.hasNext(); ) {
//			    System.out.println( p1.getURI() + " is inferred to be in class " + i.next() );
//			}
			

		}catch(Exception e){
			e.printStackTrace();
		}

	}

}
