package org.fis.project.Score;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;
import org.fis.project.Exceptions.NoUsernameFound;
import org.fis.project.Exceptions.RestaurantAlreadyExistsException;
import org.fis.project.Models.RestaurantPage;
import org.fis.project.Pass.FileSystemService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ScoreFile {
    public static List<RestaurantPage> users=new ArrayList<RestaurantPage>();
    private static final Path USER_PATH = FileSystemService.getPathToFile("config", "Restaurants.json");
    public static int addScore(int x, int total,int nrOfReviews)
    {
        int current = (total + x) / (nrOfReviews+1);
        return current;
    }
        public static void Save(String username, int score, String description,int nrofreviews, int Total) {
        users.add(new RestaurantPage(username,  score, description, nrofreviews,Total));
    }
    public static void runSaveDescription(String username, String description)throws NoUsernameFound{
        if(CheckExistsDescription(username,description)==-1) {
            persistUsers();
        }
        else
            throw new NoUsernameFound(username);

    }
        public static void runSaveScore(String username,int add)throws NoUsernameFound {
            if(CheckExistsScore(username,add)==-1) {
                persistUsers();
            }
            else
                throw new NoUsernameFound(username);
        }
        public static int CheckExistsDescription(String username,String Description)
        {
            for(RestaurantPage user:users)
            {
                if(Objects.equals(username,user.getUsername())) {
                     user.setDescription(Description);
                     return -1;
                }
            }
            return 0;
        }
    public static int CheckExistsScore(String username,int add)
    { int newScore;
        int Total;
        int NrOfReviews;
        for(RestaurantPage user:users)
        {
            if(Objects.equals(username,user.getUsername())) {
                Total=user.getTotal();
                NrOfReviews=user.getNrOfReviews();
                newScore=addScore(add,Total,NrOfReviews);
                user.setScore(newScore);
                user.setNrOfReviews(NrOfReviews+1);
                user.SetTotal(Total+add);
                return -1;
            }
        }
        return 0;
    }
    public static void runSaveEditScore(String username,int add,int original)throws NoUsernameFound {
        if(CheckEditExistsScore(username,add,original)==-1) {
            persistUsers();
        }
        else
            throw new NoUsernameFound(username);
    }
    public static int CheckEditExistsScore(String username,int add,int original)
    { int newScore;
        int Total;
        int NrOfReviews;
        for(RestaurantPage user:users)
        {
            if(Objects.equals(username,user.getUsername())) {
                Total=user.getTotal()-original;
                NrOfReviews=user.getNrOfReviews();
                newScore=addScore(add,Total,NrOfReviews);
                user.setScore(newScore);
                // user.setNrOfReviews(NrOfReviews);
                user.SetTotal(Total+add);
                return -1;
            }
        }
        return 0;
    }
    public static void runSave(String username, int score, String description,int nrOfReviews,int Total)throws RestaurantAlreadyExistsException
    {
        CheckExists(username);
        //String encoded = encrypt(password);
        Save( username, score, description, nrOfReviews, Total);
        persistUsers();
        //return 0;
    }
    public static void CheckExists(String username)throws RestaurantAlreadyExistsException
    {
        for(RestaurantPage user:users) {
            if (Objects.equals(username, user.getUsername())) {
                throw new RestaurantAlreadyExistsException(username);
            }
        }
    }
    private static void persistUsers() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(USER_PATH.toFile(), users);
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }
    public static void loadUsersFromFile() throws IOException {

        if (!Files.exists(USER_PATH)) {
            FileUtils.copyURLToFile(ScoreFile.class.getClassLoader().getResource("Restaurants.json"), USER_PATH.toFile());
        }
        ObjectMapper objectMapper = new ObjectMapper();
        users = objectMapper.readValue(USER_PATH.toFile(), new TypeReference<List<RestaurantPage>>() {
        });
    }
}
