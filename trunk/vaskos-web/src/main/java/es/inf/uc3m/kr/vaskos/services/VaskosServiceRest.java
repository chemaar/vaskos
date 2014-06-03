package es.inf.uc3m.kr.vaskos.services;



import java.io.IOException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.ProduceMime;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import es.inf.uc3m.kr.vaskos.to.ValidationContext;
import es.inf.uc3m.kr.vaskos.utils.SPARQLRulesLoader;
import main.ValidatorAppServ;

@Path("/vaskos")
public class VaskosServiceRest {
	ValidatorAppServ validator = new ValidatorAppServ();
	

	@GET
	@Path("hello")
	@ProduceMime({"text/plain", "application/xml", "application/json"})
	public String sayHello(){
		try{
			return "Hello";
		}catch(Exception e){
			 throw new WebApplicationException(Response.Status.BAD_REQUEST);
		}

	}
	
	
	
	@GET
	@ProduceMime({"text/plain", "application/xml", "application/json"})
	public String validate(@QueryParam("uri") String uriFile){
		try{
			System.out.println("VALIDATING "+this.validator.simpleValidation(createValidationContext(uriFile)).isValid());
			return "";
		}catch(Exception e){
			e.printStackTrace();
			 throw new WebApplicationException(Response.Status.BAD_REQUEST);
		}

	}
	
	
	private static ValidationContext createValidationContext(String urlFile) throws IOException {
		ValidationContext vc = new ValidationContext();
		vc.setUriFile(urlFile);
		vc.setSparqlFiles(SPARQLRulesLoader.getSPARQLRuleFiles());
		return vc;
	}
	
}
