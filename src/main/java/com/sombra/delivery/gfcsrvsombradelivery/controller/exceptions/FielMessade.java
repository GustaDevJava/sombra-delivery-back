package com.sombra.delivery.gfcsrvsombradelivery.controller.exceptions;

import java.io.Serializable;

public class FielMessade implements Serializable {
    private static final long serialVersionUID = 1L;

    private String fieldName;
    private String message;

    public FielMessade() {
        super();
    }

    public FielMessade(String fieldName, String message) {
        this.fieldName = fieldName;
        this.message = message;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    
    
}
