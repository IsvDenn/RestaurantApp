package org.fis.project.Score;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ScoreFile {
    public static int addScore(int x,String fileName)
    {   try{
        File restaurantPage= new File(fileName);
        Scanner myRead=new Scanner(restaurantPage);
        int current = 0;
        int nrOfReviews = 0;
        int[] read=new int[10];
        while(myRead.hasNextLine()) {
            read[current]=myRead.nextInt();
            current++;
        }
        current=read[0];
        nrOfReviews=read[1];
        current = (current + x) / (nrOfReviews + 1);
        return current;
    } catch(FileNotFoundException exception){
        System.out.println("An error has occured");
        exception.printStackTrace();
        return -1;
    }
    }
    public static void updateFile(int nr, int score,String Description,String myfile) {
        try {
            FileWriter myWriter = new FileWriter(myfile, false);
            myWriter.write(nr + " " + score + " "+Description+ "\n");
            myWriter.close();

        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
