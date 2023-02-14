package es.rf.tienda.exception;

public class ControllerException extends RuntimeException {
	
	public ControllerException() {}
	
	public ControllerException(String msg) {
		super(msg);
	}
}