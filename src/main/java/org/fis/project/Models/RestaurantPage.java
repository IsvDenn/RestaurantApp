package org.fis.project.Models;

public class RestaurantPage {
    private String username;
    private int score;
    private int nrofreviews;
    private String description;
    private int total;
    //private String[] products=new String[100];
   // private int nrOfProducts=0;

    public RestaurantPage() {
    }

    public RestaurantPage(String username, int score, String description,int nrofreviews,int Total) {
        this.username = username;
        this.score=score;
        this.description = description;
        this.nrofreviews=nrofreviews;
        this.total=total;
    }
    public int getTotal() { return total;}
    public void SetTotal(int Total) { this.total=Total;}
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    public int getNrOfReviews() { return nrofreviews; }
    public void setNrOfReviews(int newnumber) { this.nrofreviews=newnumber; }

    public int getScore() {
        return score;
    }

    public void setScore(int newscore) {
        this.score = newscore;
    }

    public String getdescription() {
        return description;
    }

    public void setDescription(String newDescription) {
        this.description = newDescription;
    }

   //@Override
  //  public boolean equals(Object o) {
      //  if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;

//        RestaurantPage user = (User) o;

    //    if (!username.equals(user.username)) return false;
     //   else
       //     return true;
    }

