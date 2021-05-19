package org.fis.project.Models;

public class UserRatings {

    private String username;
    private String page;
    private int score;
    private String comment=" ";
    private String ownercomment=" ";
    public UserRatings() {
    }
    public UserRatings(String username, int score){
        this.username=username;
        this.score=score;
    }
    public UserRatings(String username,String Page, int score, String comment) {
        this.username = username;
        this.page=Page;
        this.score = score;
        this.comment = comment;
    }
    public String getOwnerComment(){ return  ownercomment; }
    public void setOwnerComment(String OwnerComment){ this.ownercomment=OwnerComment; }
    public String getPage() { return page; }
    public void setPage(String Page) { this.page=Page;}
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserRatings user = (UserRatings) o;

        if (!username.equals(user.username)) return false;
        if (!(score==user.score)) return false;
        return comment.equals(user.comment);
    }


    @Override
    public String toString() {
        return "UserDTO{" +
                "username='" + username + '\'' +
                ", score='" + score + '\'' +
                ", comment='" + comment + '\'' +
                '}';
    }
}