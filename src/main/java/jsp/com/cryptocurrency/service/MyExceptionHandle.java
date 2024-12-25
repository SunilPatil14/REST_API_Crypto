package jsp.com.cryptocurrency.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.orm.ObjectOptimisticLockingFailureException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.resource.NoResourceFoundException;

@RestControllerAdvice
public class MyExceptionHandle {
	
	@ExceptionHandler(MethodArgumentTypeMismatchException.class)
	public ResponseEntity<Object> handle400(){
	  Map<String, Object> map =new HashMap<String, Object>();
	  map.put("error", "Bad request");
	  return new ResponseEntity<Object>(map ,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(NoResourceFoundException.class)
	public ResponseEntity<Object> handle404(){
	  Map<String, Object> map =new HashMap<String, Object>();
	  map.put("error", "URL is incorrect");
	  return new ResponseEntity<Object>(map ,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(ObjectOptimisticLockingFailureException.class)
	public ResponseEntity<Object> handle500(){
	  Map<String, Object> map =new HashMap<String, Object>();
	  map.put("error", "Internal server error");
	  return new ResponseEntity<Object>(map ,HttpStatus.NOT_FOUND);
	}

}
