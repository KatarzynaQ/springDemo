package com.sda.spring.demo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.validation.ObjectError;

import java.util.List;

public class ValidationError {
    private HttpStatus status;
    private List<ObjectError> objectErrorList;

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public List<ObjectError> getObjectErrorList() {
        return objectErrorList;
    }

    public void setObjectErrorList(List<ObjectError> objectErrorList) {
        this.objectErrorList = objectErrorList;
    }

    public ValidationError(HttpStatus status, List<ObjectError> objectErrorList) {
        this.status = status;
        this.objectErrorList = objectErrorList;


    }
}
