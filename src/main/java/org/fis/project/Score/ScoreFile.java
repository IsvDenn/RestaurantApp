package org.fis.project.Score;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;
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
        int current = (total + x) / (nrOfReviews);
        return current;
    }
        public static void Save(String username, int score, String description,int nrofreviews, int Total) {
        users.add(new RestaurantPage(username,  score, description, nrofreviews,Total));
    }
    public static int runSaveDescription(String username, int score, String description,int nrofreviews){
        if(CheckExistsDescription(username,description)!=-1) {
            persistUsers();
            return 0;
        }
        //String encoded = encrypt(password);
        //Save(role,encoded,user);

        return -1;
    }
        public static int runSaveScore(String username, int score,int nrofreviews){
            if(CheckExistsScore(username,score,nrofreviews)!=-1) {
                persistUsers();
                return 0;
            }
            //String encoded = encrypt(password);
           // Save(role,encoded,user);
            return -1;
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
    public static int CheckExistsScore(String username,int newScore,int NrOfReviews)
    {
        for(RestaurantPage user:users)
        {
            if(Objects.equals(username,user.getUsername())) {
                user.setScore(newScore);
                user.setNrOfReviews(NrOfReviews);
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
