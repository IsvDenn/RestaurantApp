package org.fis.project.Models;

public class RestaurantPage {
    private String username;
    private String score;
    private String description;
    private String[] products=new String[100];

    public User() {
    }

    public User(String username, String products, String description) {
        this.username = username;
        this.products = products;
        this.description = description;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String newscore) {
        this.score = newscore;
    }

    public String getdescription() {
        return description;
    }

    public void setDescription(String[] newDescription) {
        this.description = newDescription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RestaurantPage user = (User) o;

        if (!username.equals(user.username)) return false;
        else
            return true;
    }

