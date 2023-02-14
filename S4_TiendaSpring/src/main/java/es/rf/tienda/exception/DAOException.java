package es.rf.tienda.exception;

public class DAOException extends RuntimeException {
	
	public DAOException() {}
	
	public DAOException(String msg) {
		super(msg);
	}
}
