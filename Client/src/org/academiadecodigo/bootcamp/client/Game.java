package org.academiadecodigo.bootcamp.client;

public class Game {
    private Client client;
    private int playerNum;
    private String[] questions;
    private String[] answers;

    public Game(Client client){
        this.client = client;
    }

    public void receive(String serverMessage){
        playerNum = Integer.valueOf(serverMessage.split(",")[0]);
        questions = serverMessage.split(",")
    }

    public void send(){
        //send() que invokes client.send()
        //answer for game starts with \\
        String gameMessage = "\\\\";
        client.send(gameMessage);
    }

    public void show(String serverMessage){
        System.out.println(serverMessage);
        //receive() will receive all messages received from the client.receive() starting with \\
    }

    /*needed a thread to listen always to see if the game has finished*/



}
