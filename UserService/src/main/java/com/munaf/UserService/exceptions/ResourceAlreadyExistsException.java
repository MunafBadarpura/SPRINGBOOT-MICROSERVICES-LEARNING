package com.munaf.UserService.exceptions;

public class ResourceAlreadyExistsException extends RuntimeException{

    public ResourceAlreadyExistsException() {
        super("Resource Already Exists On Server");
    }

    public ResourceAlreadyExistsException(String message) {
        super(message);
    }
}
