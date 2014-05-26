package es.inf.uc3m.kr.validator.loader;

import org.w3c.dom.Document;

import es.inf.uc3m.kr.validator.exceptions.ResourceNotFoundException;
import es.inf.uc3m.kr.validator.to.KnowledgeResourcesTO;



/**
 * This interface indicates the set of operations to be implemented
 * for a loader of differente kind of sources (Files, Local files, String, etc.).
 */
public interface ResourceLoader {
    
    public KnowledgeResourcesTO [] getKnowledgeResources() throws ResourceNotFoundException;
    public String getKnowledgeResourceAsString(String filename) throws ResourceNotFoundException;
    
}