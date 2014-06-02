package es.inf.uc3m.kr.validator.to;

import java.net.URI;

import com.hp.hpl.jena.rdf.model.Model;

public class ValidationContext {
	
	private String localFile;
	private String uriFile;
	private String endpoint;
	private String shexFile;
	private URI startingIRI;
	private String []sparqlFiles;
	private Model baseModel;
	private Model inferredModel;
	private MessageManager messenger;
	private boolean valid;
	
	public ValidationContext() {
		super();
		this.localFile = "";
		this.uriFile = "";
		this.endpoint = "";
		this.baseModel = null;
		this.inferredModel = null;
		this.messenger = new MessageManager();
		this.valid = Boolean.FALSE;
		this.shexFile = null;
		this.startingIRI = null;
	}
	public String getLocalFile() {
		return localFile;
	}
	public void setLocalFile(String localFile) {
		this.localFile = localFile;
	}
	public String getUriFile() {
		return uriFile;
	}
	public void setUriFile(String uriFile) {
		this.uriFile = uriFile;
	}
	public String getEndpoint() {
		return endpoint;
	}
	public void setEndpoint(String endpoint) {
		this.endpoint = endpoint;
	}
	public Model getBaseModel() {
		return baseModel;
	}
	public void setBaseModel(Model baseModel) {
		this.baseModel = baseModel;
	}
	public Model getInferredModel() {
		return inferredModel;
	}
	public void setInferredModel(Model inferredModel) {
		this.inferredModel = inferredModel;
	}
	public MessageManager getMessenger() {
		return messenger;
	}
	public void setMessenger(MessageManager messenger) {
		this.messenger = messenger;
	}
	public boolean isValid() {
		return valid;
	}
	public void setValid(boolean valid) {
		this.valid = valid;
	}
	public String getShexFile() {
		return shexFile;
	}
	public void setShexFile(String shexFile) {
		this.shexFile = shexFile;
	}
	public URI getStartingIRI() {
		return startingIRI;
	}
	public void setStartingIRI(URI startingIRI) {
		this.startingIRI = startingIRI;
	}
	public String[] getSparqlFiles() {
		return sparqlFiles;
	}
	public void setSparqlFiles(String[] sparqlFiles) {
		this.sparqlFiles = sparqlFiles;
	}
	
	
	

}
