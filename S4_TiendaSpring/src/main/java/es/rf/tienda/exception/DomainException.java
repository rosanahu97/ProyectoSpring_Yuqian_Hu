package es.rf.tienda.exception;

@SuppressWarnings("serial")
public class DomainException extends RuntimeException {
	
	public DomainException() {}
	
	public DomainException(String msg) {
		super(msg);
	}
	
	

}
