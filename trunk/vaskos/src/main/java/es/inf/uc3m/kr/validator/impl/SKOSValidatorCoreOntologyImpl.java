package es.inf.uc3m.kr.validator.impl;

import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;

import com.hp.hpl.jena.ontology.OntDocumentManager;
import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.ontology.OntModelSpec;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.reasoner.ValidityReport;

import es.inf.uc3m.kr.validator.SKOSValidatorAdapter;
import es.inf.uc3m.kr.validator.exception.VaskosModelException;
import es.inf.uc3m.kr.validator.to.MessageTO;
import es.inf.uc3m.kr.validator.to.MessageType;
import es.inf.uc3m.kr.validator.to.ValidationContextUtils;

public class SKOSValidatorCoreOntologyImpl extends SKOSValidatorAdapter{
	protected static Logger logger = Logger.getLogger(SKOSValidatorCoreOntologyImpl.class);


	public void execute(){
		logger.info("Starting validation in "+this.getClass().getSimpleName()+" with context "+this.context);
		try{
			//Reasoner reasoner = PelletReasonerFactory.theInstance().create();
			OntDocumentManager dm = OntDocumentManager.getInstance();
			dm.setProcessImports(false);
			OntModelSpec spec = new OntModelSpec(OntModelSpec.OWL_MEM_RULE_INF);
			spec.setDocumentManager(dm);     
			//spec.setReasoner(reasoner);


			OntModel ontology = ModelFactory.createOntologyModel( spec, null );
			ontology.read(Thread.currentThread().getContextClassLoader()
					.getResourceAsStream(SKOS_ONTOLOGY_FILE), "");  


			//If there is no base model loaded
			if(!this.context.hasBaseModel()){
				ValidationContextUtils.createBaseModel(this.context);
			}

			ontology.add(this.context.getBaseModel());


			OntModel inf = ModelFactory.createOntologyModel(spec, ontology);

			ValidityReport validity = ontology.validate();
			if (validity.isValid()) {
				this.context.setValid(Boolean.TRUE);
			} else {
				this.context.setValid(Boolean.FALSE);
				List<MessageTO> errors = this.context.getMessenger().getErrors();
				for (Iterator i = validity.getReports(); i.hasNext(); ) {
					MessageTO message = new MessageTO(i.next().toString(), MessageType.ERROR);
					errors.add(message );
				}
			}

			logger.info("Finish validation in "+this.getClass().getSimpleName()+" with context "+this.context);

		}catch(Exception e){
			this.context.setValid(Boolean.FALSE);
			logger.error("Validating in "+this.getClass().getSimpleName()+" with context "+this.context,e);
			throw new VaskosModelException(e);
		}

	}

}
