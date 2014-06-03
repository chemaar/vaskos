package es.inf.uc3m.kr.vaskos.to;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

import org.apache.log4j.Logger;
import org.openrdf.rio.RDFFormat;

import com.hp.hpl.jena.rdf.model.Model;

import es.inf.uc3m.kr.vaskos.utils.FileUtils;
import es.inf.uc3m.kr.vaskos.utils.RDFSyntaxHelper;
import es.inf.uc3m.kr.vaskos.utils.SPARQLUtils;

public class ValidationContext {

	protected static Logger logger = Logger.getLogger(ValidationContext.class);
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
		this.localFile = null;
		this.uriFile = null;
		this.endpoint = null;
		this.baseModel = null;
		this.inferredModel = null;
		this.messenger = new MessageManager();
		this.valid = Boolean.FALSE;
		this.shexFile = null;
		this.startingIRI = URI.create("http://example.org/A");
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
			//this.stringSPARQLqueries [i] = FileUtils.readFile(this.sparqlFiles[i], StandardCharsets.UTF_8);
			logger.debug("Trying to load "+this.sparqlFiles[i]);
			InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream(this.sparqlFiles[i]);
			this.stringSPARQLqueries [i] = FileUtils.convertStreamToString(is);
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
		if(this.lines == null && this.baseModel!=null){
			try {
				return RDFSyntaxHelper.serializeModel(getBaseModel(), RDFFormat.TURTLE);
			} catch (IOException e) {
				return "";
			}
		}
		return this.lines;

	}

	public String getLines(RDFFormat format) throws IOException {
		return RDFSyntaxHelper.serializeModel(getBaseModel(), format);
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
