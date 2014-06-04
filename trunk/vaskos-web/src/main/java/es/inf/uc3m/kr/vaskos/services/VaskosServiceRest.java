package es.inf.uc3m.kr.vaskos.services;



import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.ws.rs.ConsumeMime;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.ProduceMime;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.sun.jersey.api.representation.FormParam;

import es.inf.uc3m.kr.vaskos.services.to.ResultTO;
import es.inf.uc3m.kr.vaskos.to.MessageTO;
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
	public ResultTO validate(@QueryParam("uri") String uriFile){
		try{

			ValidationContext context = this.validator.simpleValidation(createValidationContext(uriFile));
			ResultTO result = context2Result(context);
			return result;
		}catch(Exception e){
			throw new WebApplicationException(Response.Status.BAD_REQUEST);
		}

	}

	
	@POST
	@ConsumeMime(MediaType.APPLICATION_FORM_URLENCODED)
	@ProduceMime({"text/plain", "application/xml", "application/json"})
	public ResultTO validateLines( @FormParam("data") String lines){
		try{
			ValidationContext context = this.validator.simpleValidation(createValidationContextFromLines(lines));
			ResultTO result = context2Result(context);
			return result;
		}catch(Exception e){
			throw new WebApplicationException(Response.Status.BAD_REQUEST);
		}

	}


	private ResultTO context2Result(ValidationContext context) {
		ResultTO result = new ResultTO();
		result.setValid(context.isValid());
		//This time is nanoseconds
		result.setNanotime(context.getEndTime()-context.getStartTime());
		result.setTime(TimeUnit.MILLISECONDS.convert(result.getNanotime(), TimeUnit.NANOSECONDS));
		List<String> errors = messages2List(context.getMessenger().getErrors());
		result.setErrors(errors);
	
		return result;
	}

	private List<String> messages2List(List<MessageTO> messages){
		List<String> stringMessages = new LinkedList<String>();
		//FIXME: Move to Java 8 and use lambda expression
		for(MessageTO message:messages){
			stringMessages.add(message.getMessage());
		}
		return stringMessages;
	}


	private static ValidationContext createValidationContext(String urlFile) throws IOException {
		ValidationContext vc = new ValidationContext();
		vc.setUriFile(urlFile);
		vc.setSparqlFiles(SPARQLRulesLoader.getSPARQLRuleFiles());
		return vc;
	}

	private static ValidationContext createValidationContextFromLines(String lines) throws IOException {
		ValidationContext vc = new ValidationContext();
		vc.setLines(lines);
		vc.setSparqlFiles(SPARQLRulesLoader.getSPARQLRuleFiles());
		return vc;
	}
}
