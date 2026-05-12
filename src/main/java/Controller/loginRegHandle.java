package Controller;

import Model.User;
import com.google.gson.Gson;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class loginRegHandle {
    Gson gson =new Gson();
    private User user;

    public User hadnleReg(User user) {
        try {
            this.user = user;
            String response = gson.toJson(user);
            FileWriter obj = new FileWriter("src/resources/user.json");

            obj.write(response);
            obj.close();

        }
        catch (IOException e) {
            System.out.println(e);
        }
       return user;
    }
}
