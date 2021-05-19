import org.fis.project.Exceptions.RestaurantAlreadyExistsException;
import org.fis.project.Exceptions.UsernameAlreadyExistsException;
import org.fis.project.Pass.FileSystemService;
import org.fis.project.Pass.encoding;
import org.fis.project.Score.ScoreFile;
import java.io.IOException;

public class testEncoding {
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
        //encoding.Save("Customer","test","roler");

        try {
            encoding.runSave(b, c, d);
        } catch (UsernameAlreadyExistsException e) {
            e.printStackTrace();
            //System.out.println("THIS WORKS");
        }

        int i = 0;
        System.out.println("Our first username is:"+encoding.users.get(i).getUsername());
        String Login = "user";
        String logPass = "test";
        int check = encoding.Login(Login, logPass);
        if (check == 1)
            System.out.println("Sucesfully logged as a Customer");
        if (check == 2)
            System.out.println("Suscesfully logged as a Restaurant");
        if (check == -1)
            System.out.println("Failed to log in!");
    }

}
