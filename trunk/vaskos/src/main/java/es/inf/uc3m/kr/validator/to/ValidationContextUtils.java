package es.inf.uc3m.kr.validator.to;

import com.hp.hpl.jena.rdf.model.Model;

import es.inf.uc3m.kr.validator.loader.ExternalizeFilesResourceLoader;
import es.inf.uc3m.kr.validator.loader.JenaRDFModelWrapper;
import es.inf.uc3m.kr.validator.loader.ResourceLoader;
import es.inf.uc3m.kr.validator.loader.StringResourceLoader;
import es.inf.uc3m.kr.validator.loader.URLFilesResourceLoader;
import es.inf.uc3m.kr.validator.loader.VaskosModelWrapper;

public class ValidationContextUtils {
	
	public static void createBaseModel(ValidationContext vc){
		if(vc.getBaseModel()==null){
			VaskosModelWrapper wrapper = null;
			ResourceLoader resourceLoader = null;
			if(vc.isLocalFile()){
				resourceLoader = new ExternalizeFilesResourceLoader(
						new String []{vc.getLocalFile()});
			}else if(vc.isUriFile()){
				resourceLoader = new URLFilesResourceLoader(
						new String []{vc.getUriFile()});
			}else if(vc.isLines()){
				resourceLoader = new StringResourceLoader(vc.getLines());
			}else if(vc.isEndpoint()){
				//FIXME
			}
			wrapper= new JenaRDFModelWrapper(resourceLoader,vc.getFormat().getName());
			vc.setBaseModel((Model) wrapper.getModel());
		}
	
	}

}
