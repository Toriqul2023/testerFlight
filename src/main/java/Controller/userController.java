package Controller;

import Model.User;
import com.google.gson.Gson;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;

public class userController implements HttpHandler {
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
        exchange.getResponseHeaders().set("Content-Type","application/json");
        String method= exchange.getRequestMethod();


            Gson gson = new Gson();
          User[] users=gson.fromJson(new FileReader("src/main/resources/user.json")
                  ,User[].class);





          if(method.equals("GET")){
              String response=gson.toJson(users);
              sendingData(exchange,200,response);

          }

    }
}
