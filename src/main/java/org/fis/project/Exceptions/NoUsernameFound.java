package org.fis.project.Exceptions;

public class NoUsernameFound extends Exception{
    private String username;

    public NoUsernameFound(String username) {
        super(String.format("We didn't find the restaurant!!", username));
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
}
