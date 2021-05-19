package org.fis.project.Exceptions;

public class RestaurantAlreadyExistsException extends Exception {

    private String username;

    public RestaurantAlreadyExistsException(String username) {
        super(String.format("A restaurant with the username %s already exists!", username));
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
}