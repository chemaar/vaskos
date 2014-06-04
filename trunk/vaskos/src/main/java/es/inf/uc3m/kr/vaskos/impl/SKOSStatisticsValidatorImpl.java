package es.inf.uc3m.kr.vaskos.impl;

import java.net.URI;

import org.apache.log4j.Logger;
import org.semanticweb.skos.SKOSDataset;
import org.semanticweb.skosapibinding.SKOSManager;

import com.hp.hpl.jena.rdf.model.Model;

import es.inf.uc3m.kr.vaskos.SKOSValidatorAdapter;
import es.inf.uc3m.kr.vaskos.exception.VaskosModelException;
import es.inf.uc3m.kr.vaskos.to.MessageTO;
import es.inf.uc3m.kr.vaskos.to.MessageType;
import es.inf.uc3m.kr.vaskos.to.ValidationContextUtils;
import es.inf.uc3m.kr.vaskos.utils.SPARQLRulesLoader;
import es.inf.uc3m.kr.vaskos.utils.SPARQLStatisticsLoader;
import es.inf.uc3m.kr.vaskos.utils.SPARQLUtils;

public class SKOSStatisticsValidatorImpl extends SKOSValidatorAdapter{
	protected static Logger logger = Logger.getLogger(SKOSStatisticsValidatorImpl.class);

	public void execute(){
		try{

			logger.info("Starting validation in "+this.getClass().getSimpleName()+" with context "+this.context);
			String[] sparqlStatisticsQueries = this.context.getStringSPARQLStatisticQueries();

			if(!this.context.hasBaseModel()){
				ValidationContextUtils.createBaseModel(this.context);
			}

			Model model = this.context.getBaseModel();
			String  []sparqlStatisticFiles = this.context.getSparqlStatisticFiles();
			for(int i = 0; i<sparqlStatisticsQueries.length;i++){
				String []values = SPARQLUtils.fetchQuerySolutionToSimpleArray(
						SPARQLUtils.executeSimpleSparql(model, sparqlStatisticsQueries[i]),"no");
				if(values.length>0){
					String template = SPARQLStatisticsLoader.getMessage(this.context.getSparqlStatisticFiles()[i]);
					String text = String.format(template, values[0]);
					MessageTO message = new MessageTO();
					message.setLevel(MessageType.INFO);
					message.setMessage(text);
					this.context.getMessenger().getInfo().add(message);
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
