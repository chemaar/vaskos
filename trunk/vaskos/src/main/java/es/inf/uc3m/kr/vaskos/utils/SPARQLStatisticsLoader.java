package es.inf.uc3m.kr.vaskos.utils;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.ResourceBundle;
import java.util.Set;

public class SPARQLStatisticsLoader {

	protected static final String SPARQL_LOCAL_DIR = "sparql.local.dir";
	private static HashMap<String, String> sparqlRules; // Path of SPARQL Rule and message

	static{
		ResourceBundle sparqlBundle = ResourceBundle.getBundle(
				SPARQLStatisticsLoader.class.getName().toString());   
		String sparqlLocalDir = sparqlBundle.getString(SPARQL_LOCAL_DIR);
		sparqlRules = new HashMap<String,String>();
		Enumeration<String> keys = sparqlBundle.getKeys();
		while(keys.hasMoreElements()){
			String key = keys.nextElement();
			if(!key.equalsIgnoreCase(SPARQL_LOCAL_DIR)){
				sparqlRules.put(sparqlLocalDir+key, sparqlBundle.getString(key));	
			}
			
		}
	}

	public static String [] getSPARQLStatisticsFiles(){
		Set<String> keySet = sparqlRules.keySet();
		return  keySet.toArray(new String[keySet.size()]);
	}
	public static String getMessage(String key){
		String message = sparqlRules.get(key);
		return  (message==null?"":message);
	}

}
