package org.fis.project.main;

import org.fis.project.Exceptions.UsernameAlreadyExistsException;
import org.fis.project.Pass.FileSystemService;
import org.fis.project.Pass.encoding;
import org.fis.project.Score.ScoreFile;

import java.io.IOException;

public class Main {
    public static void main(String[] args){
        String a="test";
        String b="test2";
        String d="user";
        System.out.println(a);
        String c=encoding.encrypt(a);
        c=encoding.decrypt(c);
        System.out.println(c);
        System.out.println(FileSystemService.getPathToFile("config", "users.json"));
        try {
            encoding.loadUsersFromFile();
        }catch (IOException e) {
            e.printStackTrace();
        }
        //encoding.Save("hello","password","roler");

        try {
            encoding.runSave(b,c,d);
        } catch (UsernameAlreadyExistsException e) {
            e.printStackTrace();
            System.out.println("THIS WORKS");
        }

        int i=0;
        System.out.println(encoding.users.get(i).getUsername());
    }
}