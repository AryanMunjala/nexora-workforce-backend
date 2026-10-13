package com.nexora.hrms.employee;
import org.springframework.http.HttpStatus; import org.springframework.web.bind.MethodArgumentNotValidException; import org.springframework.web.bind.annotation.*; import java.util.Map;
@RestControllerAdvice public class ApiExceptionHandler {
@ExceptionHandler(EmployeeNotFoundException.class) @ResponseStatus(HttpStatus.NOT_FOUND) public Map<String,String> missing(RuntimeException e){return Map.of("error",e.getMessage());}
@ExceptionHandler(DuplicateEmailException.class) @ResponseStatus(HttpStatus.CONFLICT) public Map<String,String> duplicate(RuntimeException e){return Map.of("error",e.getMessage());}
@ExceptionHandler(MethodArgumentNotValidException.class) @ResponseStatus(HttpStatus.BAD_REQUEST) public Map<String,String> invalid(MethodArgumentNotValidException e){return Map.of("error",e.getBindingResult().getFieldErrors().stream().findFirst().map(x->x.getField()+": "+x.getDefaultMessage()).orElse("Invalid request"));}
}
