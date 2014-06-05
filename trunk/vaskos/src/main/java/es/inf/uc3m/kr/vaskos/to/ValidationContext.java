package es.inf.uc3m.kr.vaskos.to;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

import org.apache.jena.riot.RDFFormat;
import org.apache.log4j.Logger;





import com.hp.hpl.jena.rdf.model.Model;

import es.inf.uc3m.kr.vaskos.exception.VaskosModelException;
import es.inf.uc3m.kr.vaskos.utils.FileUtils;
import es.inf.uc3m.kr.vaskos.utils.RDFSyntaxHelper;
import es.inf.uc3m.kr.vaskos.utils.SPARQLRulesLoader;
import es.inf.uc3m.kr.vaskos.utils.SPARQLStatisticsLoader;
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
	private String []sparqlStatisticFiles;
	private Model baseModel;
	private Model inferredModel;
	private MessageManager messenger;
	private boolean valid;
	private String[] stringSPARQLqueries;
	private String [] stringSPARQLStatisticQueries;
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
		try {
			this.setSparqlFiles(SPARQLRulesLoader.getSPARQLRuleFiles());
			this.setSparqlStatisticFiles(SPARQLStatisticsLoader.getSPARQLStatisticsFiles());
		} catch (IOException e) {
			this.setValid(Boolean.FALSE);
			logger.error("Validating in "+this.getClass().getSimpleName()+" with context "+this);
			throw new VaskosModelException(e);
		}
	
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
	
	
	
	public String[] getSparqlStatisticFiles() {
		return sparqlStatisticFiles;
	}
	public void setSparqlStatisticFiles(String[] sparqlStatisticFiles) throws IOException {
		this.sparqlStatisticFiles = sparqlStatisticFiles;
		this.stringSPARQLStatisticQueries = loadQueries(this.sparqlStatisticFiles);
	}
	public String[] getStringSPARQLStatisticQueries() {
		return stringSPARQLStatisticQueries;
	}
	public void setStringSPARQLStatisticQueries(
			String[] stringSPARQLStatisticQueries) {
		this.stringSPARQLStatisticQueries = stringSPARQLStatisticQueries;
	}

	public String[] getSparqlFiles() {
		return sparqlFiles;
	}
	public void setSparqlFiles(String[] sparqlFiles) throws IOException {
		this.sparqlFiles = sparqlFiles;
		this.stringSPARQLqueries = loadQueries(this.sparqlFiles);
	}
	protected static String [] loadQueries(String[] sparqlFiles) throws IOException {
		String [] queriesAsString = new String[sparqlFiles.length];
		for(int i = 0; i<sparqlFiles.length;i++){
			logger.info("Trying to load "+sparqlFiles[i]);
			InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream(sparqlFiles[i]);
			queriesAsString [i] = FileUtils.convertStreamToString(is);
		}
		return queriesAsString;
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
