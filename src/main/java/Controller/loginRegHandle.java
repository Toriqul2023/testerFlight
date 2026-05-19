package Controller;

import Model.User;
import com.google.gson.Gson;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.UUID;

public class loginRegHandle {
    Gson gson =new Gson();
    private User user;

    public  User hadnleReg(User newuser, ArrayList<User> users) throws IOException {
        String id=UUID.randomUUID().toString();
        newuser.setId(id);
        System.out.println(id);
            users.add(newuser);

            FileWriter file=new FileWriter("src/main/resources/user.json");
            file.write(gson.toJson(users));
            file.close();

       return newuser;
    }

}
