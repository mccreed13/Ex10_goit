import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class UserCreator {
    public static void createUserJson(String fileName) throws IOException {
        File file = new File(fileName);
        FileReader fr = new FileReader(file);
        BufferedReader reader = new BufferedReader(fr);
        String line = reader.readLine();
        line = reader.readLine();
        List<User> userListJson = new ArrayList<User>();
        while (line != null){
            String[] strings = line.split(" ");
            userListJson.add(new User(strings[0], Integer.parseInt(strings[1])));
            line = reader.readLine();
        }
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(userListJson);

        System.out.println(json);
        File users = new File("user.json");
        OutputStream outputStream = new FileOutputStream(users);
        outputStream.write(json.getBytes());
    }

    static class User {
        private String name;
        private int age;

        public User(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }
    }
}

