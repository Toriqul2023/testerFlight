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

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        exchange.getResponseHeaders().add("Access-Control-Allow-Origin", "*");
        exchange.getResponseHeaders().add("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
        exchange.getResponseHeaders().add("Access-Control-Allow-Headers", "Content-Type");

        exchange.getResponseHeaders().set("Content-Type","application/json");
        String method= exchange.getRequestMethod();


            Gson gson = new Gson();
          User[] users=gson.fromJson(new FileReader("src/main/resources/user.json"),User[].class);
          String response=gson.toJson(users);

        exchange.sendResponseHeaders(200,response.getBytes().length);
        OutputStream operation= exchange.getResponseBody();
        operation.write(response.getBytes());
        operation.close();



    }
}
