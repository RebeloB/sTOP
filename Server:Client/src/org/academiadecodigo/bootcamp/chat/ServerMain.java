package org.academiadecodigo.bootcamp.chat;

public class ServerMain {

    public static void main(String[] args) {
        Server server = new Server();
        server.init();
        server.start();
    }
}
