package es.rf.tienda.exception;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collector;

import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
public class RestResponseEntityExceptionHandler  {

	
	@ExceptionHandler(value = { 
			DomainException.class,
			DAOException.class,
			ControllerException.class,
			IllegalArgumentException.class, 
			IllegalStateException.class, 
			org.springframework.dao.DuplicateKeyException.class,
			org.springframework.web.HttpRequestMethodNotSupportedException.class,
		    org.springframework.web.bind.MethodArgumentNotValidException.class,
			org.springframework.web.bind.MissingRequestHeaderException.class,
			org.springframework.web.bind.MissingServletRequestParameterException.class,
			org.springframework.web.method.annotation.MethodArgumentTypeMismatchException.class, 
			org.springframework.http.converter.HttpMessageNotReadableException.class
			})
	@ResponseBody
	public Map<String, Object> handleConflict(Exception ex) {
		String mensaje = ex.getClass().getCanonicalName() + "-" + ex.getMessage();
		System.out.println(mensaje);
		return montaError(ex, mensaje, HttpStatus.BAD_REQUEST);
	}


	
//	@ExceptionHandler(ControllerException.class)
//	public ResponseEntity<Object> procControllerException(final Exception e) {
//		String mensaje = e.getClass() + "-" + e.getMessage();
//		System.out.println(mensaje);
//		return montaError(e, mensaje, HttpStatus.BAD_REQUEST);
//	}
	
	

	private Map<String, Object> montaError(Exception ex, String mensaje, HttpStatus conflict) {
		Map<String, Object> map = new LinkedHashMap<String, Object>();
		map.clear();
		map.put("status", 0);
		map.put("message", mensaje);
		// getStackTrace se deberia filtrar por  "className": "es.rf.tienda.
		// Array de objetos
//		Object[] stack = Arrays.stream(ex.getStackTrace()).map(s->s.getClassName()).filter(s->s.truncate(12).equals("es.rf.tienda")).collect(toString());
		map.put("stacktrace", ex.getStackTrace());
		return map;
	}
}

