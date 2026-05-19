package Controller;

import Model.Booking;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class bookingController implements HttpHandler {
    public void sendingResponse(HttpExchange exchange,int status,String response) throws IOException{
        exchange.sendResponseHeaders(status,response.getBytes().length);
        OutputStream operation=exchange.getResponseBody();
        operation.write(response.getBytes());
        operation.close();
    }
    public void handle(HttpExchange exchange) throws IOException{
        exchange.getResponseHeaders().add("Access-Control-Allow-Origin", "*");
        exchange.getResponseHeaders().add("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
        exchange.getResponseHeaders().add("Access-Control-Allow-Headers", "Content-Type");
        exchange.getResponseHeaders().set("Content-Type", "application/json");



        String method= exchange.getRequestMethod();
        Gson gson=new Gson();
        if (method.equalsIgnoreCase("OPTIONS")) {
            exchange.sendResponseHeaders(204, -1);
            return;
        }
        Type type=new TypeToken<ArrayList<Booking>>(){}.getType();
        ArrayList<Booking> bookings=gson.fromJson(new FileReader("src/main/resources/booking.json"),type);
        if(bookings==null){
            bookings=new ArrayList<Booking>();
        }
        if(method.equals("GET")){
            String response=gson.toJson(bookings);
            sendingResponse(exchange,200,response);


        }
    }

}
