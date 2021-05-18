package org.fis.project.Pass;

import org.apache.commons.io.FileUtils;
import org.fis.project.Exceptions.UsernameAlreadyExistsException;
import org.fis.project.Models.User;
//import org.json.JSONObject;
import java.util.ArrayList;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.spec.KeySpec;
import java.util.Base64;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class encoding {
    private static final String S_key = "Random string";
    private static final String salt = "Another random string";
     public static List<User> users=new ArrayList<User>();
     private static final Path USER_PATH = FileSystemService.getPathToFile("config", "users.json");
    public static String encrypt(String strToEncrypt) {
        try {
            byte[] iv = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
            IvParameterSpec ivspec = new IvParameterSpec(iv);
            SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
            KeySpec spec = new PBEKeySpec(S_key.toCharArray(), salt.getBytes(), 65536, 256);
            SecretKey tmp = factory.generateSecret(spec);
            SecretKeySpec secretKey = new SecretKeySpec(
                    tmp.getEncoded(), "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey, ivspec);
            // Return encrypted string
            return Base64.getEncoder().encodeToString(
                    cipher.doFinal(strToEncrypt.getBytes(
                            StandardCharsets.UTF_8)));
        } catch (Exception e) {
            System.out.println("Error while encrypting: " + e.toString());
        }
        return null;
    }

    public static String decrypt(String strToDecrypt) {
        try {
            byte[] iv = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
            IvParameterSpec ivspec = new IvParameterSpec(iv);
            SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
            KeySpec spec = new PBEKeySpec(S_key.toCharArray(), salt.getBytes(), 65536, 256);
            SecretKey tmp = factory.generateSecret(spec);
            SecretKeySpec secretKey = new SecretKeySpec(tmp.getEncoded(), "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            cipher.init(Cipher.DECRYPT_MODE, secretKey, ivspec);
            // Return decrypted string
            return new String(cipher.doFinal(Base64.getDecoder().decode(strToDecrypt)));
        } catch (Exception e) {
            System.out.println("Error while decrypting: "
                    + e.toString());
        }
        return null;
    }

    public static void Save(String role, String password, String user) {
        users.add(new User(user,password,role));
    }

    public static void runSave(String role, String password, String user)throws UsernameAlreadyExistsException
    {
        CheckExists(user);
      //  return -1;
        String encoded = encrypt(password);
        Save(role,encoded,user);
        persistUsers();
        //return 0;
    }
    public static void CheckExists(String username) throws UsernameAlreadyExistsException
    {
        for(User user:users)
        {
            if(Objects.equals(username,user.getUsername())) {
               // return -1;
                throw new UsernameAlreadyExistsException(username);
            }
            //System.out.println("we didn't find any duplicates yet");
        }
        //return 0;
    }
    public static int checkDecrypt(String myfile, String user, String password) {
        try {
            File Obj = new File(myfile);
            Scanner Reader = new Scanner(Obj);
            String[] input = new String[2];
                while (Reader.hasNextLine()){
                    input = Reader.nextLine().split(" ");
                if (input[0] == user) {
                    if(password==decrypt(input[1]))
                        return 1;
                    else return 0;
                }
                }
                Reader.close();
            return 0;
        }
        catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            return -1;
        }
    }

    public static void loadUsersFromFile() throws IOException {

        if (!Files.exists(USER_PATH)) {
            FileUtils.copyURLToFile(encoding.class.getClassLoader().getResource("users.json"), USER_PATH.toFile());
        }
        ObjectMapper objectMapper = new ObjectMapper();
        users = objectMapper.readValue(USER_PATH.toFile(), new TypeReference<List<User>>() {
        });
    }

    private static void persistUsers() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(USER_PATH.toFile(), users);
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }

}


