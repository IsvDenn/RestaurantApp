import org.fis.project.Exceptions.NoUsernameFound;
import org.fis.project.Exceptions.RestaurantAlreadyExistsException;
import org.fis.project.Exceptions.UsernameAlreadyExistsException;
import org.fis.project.Pass.FileSystemService;
import org.fis.project.Pass.encoding;
import org.fis.project.Score.ReviewsFile;
import org.fis.project.Score.ScoreFile;
import java.io.IOException;

public class testReviews {
    public static void main(String[] args) {
        System.out.println(FileSystemService.getPathToFile("config", "users.json"));
        try {
            ReviewsFile.loadUsersFromFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            ScoreFile.loadUsersFromFile();
        }
        catch(IOException e) {
            e.printStackTrace();
        }
        int i = 0;
        int score = 5;
        String page = "hello";
        String Comment= "A nice restaurant";
        String username = "Tester1";
        ReviewsFile.runSave(username, page, score, Comment);//if the review already exist it will update it.
        System.out.println(ReviewsFile.users.get(i).getComment());
        String Comment2="I hate it";
        int newscore=2;
        ReviewsFile.runSave(username,page,newscore,Comment2);
        System.out.println(ReviewsFile.users.get(i).getComment());
        //we should also include the ScoreFile class to save the new score
        try {
            ScoreFile.runSaveEditScore(ScoreFile.users.get(i).getUsername(), newscore,score);
            System.out.println("We edited the new value suscesfully:, new average rounded down is:" + ScoreFile.users.get(i).getScore());
        } catch (NoUsernameFound noUsernameFound) {
            noUsernameFound.printStackTrace();
        }
        System.out.println(ScoreFile.users.get(i).getTotal());

    }

}
