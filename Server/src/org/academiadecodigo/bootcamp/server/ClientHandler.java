package org.academiadecodigo.bootcamp.server;

import org.academiadecodigo.bootcamp.server.PromptMenus.PromptMenu;

import java.io.*;
import java.net.Socket;

public class ClientHandler {
    private Server server;
    private Socket activeSocket;
    private BufferedReader in;
    private BufferedWriter out;
    private String nick;

    private PromptMenu promptMenu;


    public ClientHandler(Socket activeSocket, Server server) {
        this.activeSocket = activeSocket;
        this.server = server;
        this.nick = "user";
        try {
            promptMenu = new PromptMenu(activeSocket);
            init();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void init(){
        try {
            this.in = new BufferedReader(new InputStreamReader(activeSocket.getInputStream()));
            this.out = new BufferedWriter(new OutputStreamWriter(activeSocket.getOutputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void start(int nick) {
        this.nick = "user" + nick;
        while (!activeSocket.isClosed()){
            String message = read();
            if(message == null){
                close();
            }
            if(message.substring(0, 2).equals("\\\\")) {
                command(message, this);
            } else if(message.substring(0, 1).equals("\\")) {
                command(message, this);
                server.send(message, this);
            }
        }
    }

    public String read() {
        String receiveBufferStr = "";
        try {
            char[] receiveBuffer = new char[1024];
            int charRead = in.read(receiveBuffer);
            receiveBufferStr = String.valueOf(receiveBuffer, 0, charRead).trim();
        } catch (IOException ioEx) {
            System.out.println(ioEx.getMessage());
        }
        return receiveBufferStr;
    }

    public void send(String inputMsg, String user) {
        try {
            String outputMessage = user + ": " + inputMsg + "\n";
            char[] sendBuffer = outputMessage.toCharArray();
            out.write(sendBuffer);
            out.flush();
        } catch (IOException ioEx) {
            System.out.println(ioEx.getMessage());
        }
    }

    public void close() {
        if (activeSocket == null) {
            return;
        }
        try {
            activeSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getNick() {
        return nick;
    }


    public void command(String clientMessage, ClientHandler clientSending){
        if(clientMessage.length() >= 5) {
            switch (clientMessage.substring(0, 5)) {
                case "\\quit":
                    close();
                    return;
                case "\\nick":
                    if(server.checkNickChange(clientMessage) || !(clientMessage.substring(6).trim().length() <= 0)){
                        nick = clientMessage.substring(6).trim();
                        send("Nick changed.", "Server");
                        return;
                    }
                    send("Nick already chosen.", "Server");
                    return;
                case "\\dmsg":
                    server.directMsg(clientMessage, clientSending);
                    return;
                case "\\list":
                    String[] list = server.listOnline().split("\n");
                    for (int i = 0; i < list.length; i++) {
                        send(list[i], "Server");
                    }
                    return;
                default:
                    send("Couldn't handle the command: " + clientMessage, "Server");
                    return;
            }
        }
        send("Couldn't handle the command: " + clientMessage, "Server");
        return;
    }
}
