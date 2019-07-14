package org.academiadecodigo.bootcamp.server;

import org.academiadecodigo.bootcamp.server.Scoring.CompareAnswers;
import org.academiadecodigo.bootcamp.server.pontuation.Game;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
    private ServerSocket serverSocket;
    private Socket activeSocket;
    private BufferedReader inputMsg;
    private ExecutorService pool;
    private static List<ClientHandler> clientHandler;
    private static int connections = 0;
    private static int playerID = 1;
    private CompareAnswers compareAnswers = new CompareAnswers();
    private int numPlayers;



    void init() {


        Collections.synchronizedList(new LinkedList<ClientHandler>());
        this.clientHandler = Collections.synchronizedList(new LinkedList<>());
        this.inputMsg = new BufferedReader(new InputStreamReader(System.in));

        try {
            this.serverSocket = new ServerSocket(port());
            numPlayers = numPlayers();
        } catch (IOException e) {
            e.printStackTrace();
        }
        pool = Executors.newFixedThreadPool(numPlayers);
    }

    void start() {
        while (serverSocket.isBound()) {
            try {
                this.activeSocket = serverSocket.accept();
                System.out.println("Client connected " + activeSocket.getInetAddress());
            } catch (IOException e) {
                e.printStackTrace();
            }
            pool.submit(new Runnable() {
                @Override
                public void run() {
                    ClientHandler newClientHandler = new ClientHandler(activeSocket, Server.this);
                    clientHandler.add(newClientHandler);

                    Server.connections++;

                    waiting();
                    newClientHandler.start(Server.playerID++);
                }
            });
        }
    }

    void send(String clientMessage, ClientHandler clientSending) {
        for (Object client : clientHandler) {
            if (!client.equals(clientSending)) {
                ((ClientHandler) client).send(clientMessage, clientSending.getNick());
            }
        }
    }

    private int port() {
        try {
            System.out.println("\nEnter Port: ");
            int port = 0;
            port = Integer.parseInt(inputMsg.readLine());
            return port;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Integer.parseInt(null);
    }

    public String listOnline() {
        String response = "";
        for (Object clients : clientHandler) {
            response = response + ((ClientHandler) clients).getNick() + " is online\n";
        }
        return response;
    }

    public boolean checkNickChange(String clientMessage) {
        for (Object client : clientHandler) {
            if (((ClientHandler) client).getNick().equals(clientMessage.substring(6).trim())) {
                return false;
            }
        }
        return true;
    }

    public void directMsg(String clientMessage, ClientHandler clientSending) {
        for (Object client : clientHandler) {
            if (((ClientHandler) client).getNick().equals(clientMessage.split(" ")[1])) {
                ((ClientHandler) client).send(clientMessage.split("^([^ ]+[ ]+[^ ]+)[ ]")[1], clientSending.getNick());
                return;
            }
        }
    }

    public static List<ClientHandler> getClientHandler() {
        return clientHandler;
    }

    public synchronized void waiting(){
        while (connections != numPlayers){
            try {
                this.wait();
                break;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.notifyAll();
        Game.randomLetter();
    }

    private int numPlayers() {
        try {
            System.out.println("\nEnter number of players: ");
            int numPlayers = 0;
            numPlayers = Integer.
                    parseInt(inputMsg.
                            readLine());
            return numPlayers;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Integer.parseInt(null);
    }

}

