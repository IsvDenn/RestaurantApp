package org.fis.project.Score;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;
import org.fis.project.Models.UserRatings;
import org.fis.project.Pass.FileSystemService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ReviewsFile {
    public static List<UserRatings> users=new ArrayList<UserRatings>();
    private static final Path USER_PATH = FileSystemService.getPathToFile("config", "Comments.json");
    public static void Save(String username,String Page, int score, String comment) {
        users.add(new UserRatings(username,Page,score,comment));
    }
    public static void runSave(String username,String Page, int score, String comment)
    { int check;
        check=CheckExists(username,Page,score,comment);
        //if it exists we edit the data in your list. otherwise we save.
        if(check==0)
            Save( username,Page,score,comment);
        persistUsers();
        //return 0;
    }
    public static int CheckExists(String username,String Page, int score, String comment)
    {
        for(UserRatings user:users) {
            if ((Objects.equals(username, user.getUsername())) && (Objects.equals(Page,user.getPage()))) {
                user.setPage(Page);//if we find a match we update the file
                user.setScore(score);
                user.setComment(comment);
                return 1;
            }
        }
        return 0;
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
            FileUtils.copyURLToFile(ScoreFile.class.getClassLoader().getResource("Comments.json"), USER_PATH.toFile());
        }
        ObjectMapper objectMapper = new ObjectMapper();
        users = objectMapper.readValue(USER_PATH.toFile(), new TypeReference<List<UserRatings>>() {
        });
    }
}