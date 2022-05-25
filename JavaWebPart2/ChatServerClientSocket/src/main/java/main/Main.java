package main;

import java.io.IOException;

public class Main {
    public static void main(String[] args){
        //int port = Integer.parseInt(args[0]);
        try
        {
            ChatServer server = new ChatServer(5050);
            server.start();
        }catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}