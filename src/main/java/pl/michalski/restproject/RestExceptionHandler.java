package pl.michalski.restproject;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import pl.michalski.restproject.customers.Customer;
import pl.michalski.restproject.customers.CustomerNotFoundException;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

//    @ExceptionHandler(value = CustomerNotFoundException.class)
//    protected ResponseEntity<Object> customerNotFound(
//            RuntimeException ex, WebRequest request) {
//        String bodyOfResponse = "Customer Not Found";
//        return handleExceptionInternal(ex, bodyOfResponse, new HttpHeaders(), HttpStatus.NOT_FOUND, request);
//    }


}
