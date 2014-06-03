package es.inf.uc3m.kr.vaskos.utils;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;

import org.openrdf.rio.RDFFormat;

import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.RDFWriter;

public class RDFSyntaxHelper {

	
	public static String serializeModel(Model result, RDFFormat format) throws IOException{
    RDFWriter w = result.getWriter(format.getName());     
    StringWriter string = new StringWriter();
    w.write(result, string,"");
    string.close();
    return string.toString();
}
	
	
}
