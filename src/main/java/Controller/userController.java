package Controller;

import Model.Flight;
import Model.User;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.*;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;

public class userController implements HttpHandler  {
 public void sendingData(HttpExchange exchange,int statusCode,String response){
     try{
         exchange.sendResponseHeaders(statusCode,response.getBytes().length);
         OutputStream operation=exchange.getResponseBody();
         operation.write(response.getBytes());
         operation.close();

     } catch (IOException e) {
         throw new RuntimeException(e);
     }

 }
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        exchange.getResponseHeaders().add("Access-Control-Allow-Origin", "*");
        exchange.getResponseHeaders().add("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
        exchange.getResponseHeaders().add("Access-Control-Allow-Headers", "Content-Type");
        exchange.getResponseHeaders().set("Content-Type", "application/json");



        String method= exchange.getRequestMethod();
        if (method.equalsIgnoreCase("OPTIONS")) {
            exchange.sendResponseHeaders(204, -1); // No content
            return;
        }

        Gson gson = new Gson();
        Type type=new TypeToken<ArrayList<User>>(){}.getType();
        ArrayList<User> users=gson.fromJson(new
                FileReader("src/main/resources/user.json"),type);

        if(users==null) {
            users= new ArrayList<>();
        }
        if(method.equals("GET")){

            String response=gson.toJson(users);
            sendingData(exchange,200,response);

        }
         if(method.equals("POST")){
            InputStream is= exchange.getRequestBody();
             System.out.println(is);
            User newUser=gson.fromJson(new InputStreamReader(is,StandardCharsets.UTF_8),User.class);
            try {
                System.out.println(newUser.getName());
                new loginRegHandle().hadnleReg(newUser,users);
                String response= gson.toJson(newUser);
                sendingData(exchange,200,response);
            } catch (IOException e) {

                String response="Something Wrong";
                sendingData(exchange,500,response);
            }


        }
    }
}