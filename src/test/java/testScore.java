import org.fis.project.Exceptions.NoUsernameFound;
import org.fis.project.Exceptions.RestaurantAlreadyExistsException;
import org.fis.project.Pass.FileSystemService;
import org.fis.project.Score.ScoreFile;

import java.io.IOException;

public class testScore {
    public static void main(String[] args) {
        System.out.println(FileSystemService.getPathToFile("config", "Restaurants.json"));
        try {
            ScoreFile.loadUsersFromFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        int i = 0;
        int score = 5;
        int total = 10;
        int nrofReviews = 2;
        String description = "hello there";
        String username = "Tester1";
        try {
            ScoreFile.runSave(username, score, description, nrofReviews, total);
        } catch (RestaurantAlreadyExistsException e) {
            e.printStackTrace();
        }
        System.out.println("This score file user is:" + ScoreFile.users.get(i).getUsername());
       // int newval = ScoreFile.addScore(3, ScoreFile.users.get(i).getTotal() + 1, ScoreFile.users.get(i).getNrOfReviews() + 1);
        //System.out.println("The new value is:" + newval);
        try {
            ScoreFile.runSaveScore(ScoreFile.users.get(i).getUsername(), 5);
            System.out.println("We added the new value suscesfully:new average rounded down is:" + ScoreFile.users.get(i).getScore());
        } catch (NoUsernameFound noUsernameFound) {
            noUsernameFound.printStackTrace();
        }
        System.out.println(ScoreFile.users.get(i).getTotal());
        String newdescription="Hello world";
        try{
            ScoreFile.runSaveDescription(ScoreFile.users.get(i).getUsername(),newdescription);
            System.out.println("We suscesfully added a new description!" +ScoreFile.users.get(i).getdescription());
        }
        catch (NoUsernameFound noUsernameFound) {
            noUsernameFound.printStackTrace();
        }

        try {
            ScoreFile.runSaveEditScore(ScoreFile.users.get(i).getUsername(), 1,5);
            System.out.println("We edited the new value suscesfully:, new average rounded down is:" + ScoreFile.users.get(i).getScore());
        } catch (NoUsernameFound noUsernameFound) {
            noUsernameFound.printStackTrace();
        }
        System.out.println(ScoreFile.users.get(i).getTotal());
    }
}
