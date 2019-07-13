package org.academiadecodigo.bootcamp.server;

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
    private List<ClientHandler>/*LinkedList*/ clientHandler;
    private static int connections = 1;


    void init() {
        Collections.synchronizedList(new LinkedList<ClientHandler>());
        this.clientHandler = Collections.synchronizedList(new LinkedList<>());
        this.inputMsg = new BufferedReader(new InputStreamReader(System.in));
        try {
            this.serverSocket = new ServerSocket(port());
        } catch (IOException e) {
            e.printStackTrace();
        }
        pool = Executors.newFixedThreadPool(100);
    }

    void start() {
        while (serverSocket.isBound()) {
            try {
                this.activeSocket = serverSocket.accept();
            } catch (IOException e) {
                e.printStackTrace();
            }
            pool.submit(new Runnable() {
                @Override
                public void run() {
                    ClientHandler newClientHandler = new ClientHandler(activeSocket, Server.this);
                    clientHandler.add(newClientHandler);    //
                    newClientHandler.start(Server.connections++);
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

}

