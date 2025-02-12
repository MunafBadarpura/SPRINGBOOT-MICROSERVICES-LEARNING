package com.munaf.UserService.exceptions;

public class ResourceNotFoundException extends RuntimeException {
  public ResourceNotFoundException(String message) {
    super(message);
  }

  public ResourceNotFoundException() {
      super("Recourse Not Found On Server");
  }
}
