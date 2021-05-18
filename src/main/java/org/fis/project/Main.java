package org.fis.project;
import org.fis.project.Exceptions.RestaurantAlreadyExistsException;
import org.fis.project.Exceptions.UsernameAlreadyExistsException;
import org.fis.project.Pass.FileSystemService;
import org.fis.project.Pass.encoding;
import org.fis.project.Score.ScoreFile;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String a = "test";
        String b = "Restaurant";
        String d = "user";
        System.out.println(a);
        String c = encoding.encrypt(a);
        c = encoding.decrypt(c);
        System.out.println(c);
        System.out.println(FileSystemService.getPathToFile("config", "users.json"));
        try {
            encoding.loadUsersFromFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //encoding.Save("Customer","password","roler");

        try {
            encoding.runSave(b, c, d);
        } catch (UsernameAlreadyExistsException e) {
            e.printStackTrace();
            System.out.println("THIS WORKS");
        }

        int i = 0;
        System.out.println(encoding.users.get(i).getUsername());
        int score = 10;
        int total = 20;
        int nrofReviews = 2;
        String description = "hello there";
        String username = "Tester1";
        try {
            ScoreFile.runSave(username, score, description, nrofReviews, total);
        } catch (RestaurantAlreadyExistsException e) {
            e.printStackTrace();
        }
        System.out.println("This score file user is:"+ScoreFile.users.get(i).getUsername());

        String Login = "user";
        String logPass = "test";
        int check = encoding.Login(Login, logPass);
        if (check == 1)
            System.out.println("Sucesfully logged as a Customer");
        if (check == 2)
            System.out.println("Suscesfully logged as a restaurant");
        if (check == -1)
            System.out.println("Failed to log in!");
    }

}
