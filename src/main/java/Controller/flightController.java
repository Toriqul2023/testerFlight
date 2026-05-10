package Controller;

import Model.Flight;
import Model.User;
import com.google.gson.Gson;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;

public class flightController implements HttpHandler  {
 
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
    public boolean isNUmericalValue(String s){
        try{
            Integer.parseInt(s);
            return true;
        }
        catch(NumberFormatException e){
            return false;
        }

    }

    public void handle(HttpExchange exchange) throws IOException {


        Gson gson= new Gson();
        Flight[] flights=gson.fromJson(new FileReader("src/main/resources/flight.json")
                , Flight[].class);
        String method=exchange.getRequestMethod();
        exchange.getResponseHeaders().set("Content-Type","application/json");


        String path= exchange.getRequestURI().getPath();
        String[] dynamicPath=path.split("/");

        if(method.equals("GET") && path.equals("/flight")){
            String response=gson.toJson(flights);
            sendingData(exchange,200,response);
            
        }

       


        if(method.equals("GET") && isNUmericalValue(dynamicPath[2])){
            String response = "";
            for (Flight flight : flights) {
              if(flight.getId()==Integer.parseInt(dynamicPath[2])){
                  response=gson.toJson(flight);
                  break;
              }
            }
            sendingData(exchange,200,response);


        }

    }

}
