package ua.goit.module10;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CreateJson {
    public static void main(String[] args) throws IOException {
        File inputFile = new File("src/main/resources/file1");
        File outputFile = new File("src/main/resources/user.json");

        FileReader fileReader = new FileReader(inputFile);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        List<User> userList = new ArrayList<>();

        String str = bufferedReader.readLine();
        while (str != null) {
            str = bufferedReader.readLine();
            if (str == null) {
                break;
            }
            String[] userInfo = str.split(" ");
            String name = userInfo[0];
            Integer age = Integer.valueOf(userInfo[1]);

            User user = new User(name, age);
            userList.add(user);
        }

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(userList);

        try (FileWriter writer = new FileWriter(outputFile))
        {
            String text = json.toString();
            writer.write(text);
            writer.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    static class User {
        private String name;
        private Integer age;

        public User(String name, Integer age) {
            this.name = name;
            this.age = age;
        }
    }
}


