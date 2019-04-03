package br.feevale.bolao.exception;

import java.util.ArrayList;
import java.util.List;

public class CustomException extends RuntimeException {

    private List<String> errors;

    public CustomException(List<String> errors) {
        this.errors = errors;
    }

    public CustomException(String error) {
        errors = new ArrayList<>();
        errors.add(error);
    }

    public List<String> getErrors() {
        return errors;
    }
}
