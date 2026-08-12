package com.flashcolorcard.springboot.app.exceptions;

import com.flashcolorcard.springboot.app.commom.commonutils.HttpError;

import java.util.ArrayList;
import java.util.List;

public class ResourceNotFoundException extends RuntimeException{

    private  List<HttpError> errors = new ArrayList<>();

    public ResourceNotFoundException(String message){
        super(message);
    }

    public ResourceNotFoundException(String message, List<HttpError> listErrors){
        super(message);
        this. errors = listErrors;
    }

    public List<HttpError> getErrors() {
        return errors;
    }
}
