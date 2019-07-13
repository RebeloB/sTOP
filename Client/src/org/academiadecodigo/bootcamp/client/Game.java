package org.academiadecodigo.bootcamp.client;

import java.util.Arrays;

public class Game {
    private Client client;
    private int playerNum;
    private boolean receivedQuestions;
    private String[] questions;
    private String[] answers;

    public Game(Client client){
        this.client = client;
        receivedQuestions = false;
    }

    public void receive(String serverMessage){
        switch (serverMessage.substring(0,1)) {
            case "W":
                winner(serverMessage);
                break;
            case "E":
                endOfGame(serverMessage);
                break;
            default:
                questionAnswer(serverMessage);
                break;
        }
    }

    public void send(String gameMessage){
        //send() que invokes client.send()
        //answer for game starts with \\
        receivedQuestions = false;
        gameMessage = "\\\\" + playerNum + " " + Arrays.toString(answers);
        client.send(gameMessage);
    }

    public void show(String serverMessage){
        System.out.println(serverMessage);
        //receive() will receive all messages received from the client.receive() starting with \\
    }

    public void winner(String serverMessage) {
        System.out.println("The winner is " + serverMessage.substring(2));
        //If message contain the winner it will start with "W " + the nick of the winner;
    }

    public void endOfGame(String serverMessage) {
        //If message contain the mark for the end of the game;
        //Logic to stop the game
    }

    public void questionAnswer(String serverMessage) {
        if (!receivedQuestions) {
            //f the message contains the questions
            playerNum = Integer.valueOf(serverMessage.split(",")[0]);
            questions = serverMessage.substring(Integer.valueOf(serverMessage.split(",")[0])).split(",");
            receivedQuestions = true;
        } else {
            //If the message constains the answers
            playerNum = Integer.valueOf(serverMessage.split(",")[0]);
            questions = serverMessage.substring(Integer.valueOf(serverMessage.split(",")[0])).split(",");
            receivedQuestions = false;
        }
    }

}
