package Controller;

import Model.User;
import com.google.gson.Gson;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class loginRegHandle {
    Gson gson =new Gson();
    private User user;

    public User hadnleReg(User newuser,User[] oldUsers) {
        try {
            User[] newUsers= Arrays.copyOf(oldUsers,oldUsers.length+1);
            newUsers[newUsers.length-1]=newuser;
            FileWriter file=new FileWriter("src/main/resources/user.json");
            file.write(gson.toJson(newUsers));
            file.close();



        }
        catch (IOException e) {
            System.out.println(e);
        }
       return user;
    }
}
