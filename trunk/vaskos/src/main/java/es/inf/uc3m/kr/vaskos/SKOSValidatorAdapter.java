package es.inf.uc3m.kr.vaskos;

import es.inf.uc3m.kr.vaskos.exception.VaskosModelException;
import es.inf.uc3m.kr.vaskos.to.ValidationContext;



public abstract class SKOSValidatorAdapter implements SKOSValidator{
	protected SKOSValidator successor;
	protected ValidationContext context;
	
    public void setSuccessor(SKOSValidator successor){
            this.successor = successor;
    }

    protected abstract void execute() throws Exception;
    protected void preExecute() throws Exception{
    	
    }
    protected void postExecute() throws Exception{
    	
    }
    
	public ValidationContext validate(ValidationContext context) {
		 this.context = context;
		 try {
			 preExecute();
			 execute();
			 postExecute();
			 if(successor != null){
			         return this.successor.validate(this.context);
			 }
		} catch (Exception e) {
			throw new VaskosModelException(e);
		}
		
     return  this.context;
	}
	

}
