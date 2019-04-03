package br.feevale.bolao.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
@RestController
public class CustomizedExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(CustomException.class)
    public final ResponseEntity<ApiError> handleCustomException(CustomException ex, WebRequest request) {
        System.out.println(ex.getErrors());
        ex.printStackTrace();
        return new ResponseEntity<>(new ApiError(ex.getErrors()), HttpStatus.OK);
    }

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ApiError> handleAllExceptions(Exception ex, WebRequest request) {
        List<String> errors = new ArrayList<>();
        ex.printStackTrace();
        if (ex.getMessage() == null) {
            errors.add("Ops, ocorreu um erro. Tente novamente mais tarde.");
        } else {
            errors.add(ex.getMessage());
        }

        return new ResponseEntity<>(new ApiError(errors), HttpStatus.OK);
    }

}
