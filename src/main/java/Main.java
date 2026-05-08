import Controller.userController;

import com.sun.net.httpserver.HttpServer;

import java.io.IOException;

import java.net.InetSocketAddress;




public class Main {

    public static void main(String[] args) throws IOException {
      HttpServer server= HttpServer.create(new InetSocketAddress(9090),0);
      server.createContext("/user",new userController());
      server.start();
    }
}
