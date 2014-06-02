package es.inf.uc3m.kr.validator.to;

import java.io.IOException;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

import org.openrdf.rio.RDFFormat;

import com.hp.hpl.jena.rdf.model.Model;

import es.inf.uc3m.kr.validator.utils.FileUtils;
import es.inf.uc3m.kr.validator.utils.SPARQLUtils;

public class ValidationContext {
	
	private String localFile;
	private String uriFile;
	private String endpoint;
	private String lines;
	private String shexFile;
	private URI startingIRI;
	private String []sparqlFiles;
	private Model baseModel;
	private Model inferredModel;
	private MessageManager messenger;
	private boolean valid;
	private String[] stringSPARQLqueries;
	private RDFFormat format;
	private long startTime;
	private long endTime;
	
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
		this.format = RDFFormat.TURTLE;
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
	public void setSparqlFiles(String[] sparqlFiles) throws IOException {
		this.sparqlFiles = sparqlFiles;
		this.loadQueries(this.sparqlFiles);
	}
	private void loadQueries(String[] sparqlFiles2) throws IOException {
		this.stringSPARQLqueries = new String[this.sparqlFiles.length];
		for(int i = 0; i<this.sparqlFiles.length;i++){
			this.stringSPARQLqueries [i] = FileUtils.readFile(this.sparqlFiles[i], StandardCharsets.UTF_8);
		}
		
	}
	public String[] getStringSPARQLqueries() {
		return stringSPARQLqueries;
	}
	public void setStringSPARQLqueries(String[] stringSPARQLqueries) {
		this.stringSPARQLqueries = stringSPARQLqueries;
	}
	public RDFFormat getFormat() {
		return format;
	}
	public void setFormat(RDFFormat format) {
		this.format = format;
	}
	public long getStartTime() {
		return startTime;
	}
	public void setStartTime(long startTime) {
		this.startTime = startTime;
	}
	public long getEndTime() {
		return endTime;
	}
	public void setEndTime(long endTime) {
		this.endTime = endTime;
	}
	public String getLines() {
		return lines;
	}
	public void setLines(String lines) {
		this.lines = lines;
	}
	@Override
	public String toString() {
		return "ValidationContext [localFile=" + localFile + ", uriFile="
				+ uriFile + ", endpoint=" + endpoint + ", lines=" + lines
				+ ", shexFile=" + shexFile + ", startingIRI=" + startingIRI
				+ ", sparqlFiles=" + Arrays.toString(sparqlFiles) + ", valid="
				+ valid + ", format=" + format + ", startTime=" + startTime
				+ ", endTime=" + endTime + "]";
	}

	
	public boolean isLocalFile(){
		return this.localFile!=null;
	}
	
	public boolean isUriFile(){
		return this.uriFile!=null;
	}

	public boolean isEndpoint(){
		return this.endpoint!=null;
	}
	
	public boolean isLines(){
		return this.lines!=null;
	}
	

	public boolean hasBaseModel(){
		return this.baseModel!=null;
	}
	
}
