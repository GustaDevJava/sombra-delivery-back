package com.sombra.delivery.gfcsrvsombradelivery.controller.exceptions;

import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandardError {
    private static final long serialVersionUID = 1L;

    private List<FielMessade> errors = new ArrayList<>();

    public ValidationError(){
        super();
    }

    public ValidationError(Long timestamp, Integer status, String error) {
        super(timestamp, status, error);
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public List<FielMessade> getErrors() {
        return errors;
    }

    public void addError(String fieldName, String message) {
        this.errors.add(new FielMessade(fieldName, message));
    }

    

    
}
