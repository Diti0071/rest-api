package com.azurbo.task.exception;

/**
 * @author Ardit on 4/1/2021
 * @project demo
 */
public class ResourceNotFoundException extends Exception{

    public static final long serialVersionUID = 1L;

    public ResourceNotFoundException(String message){
        super(message);
    }
}
