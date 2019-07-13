package org.academiadecodigo.bootcamp.client;

import java.io.*;
import java.net.Socket;

public class Client {
        private Socket activeSocket;
        private BufferedWriter out;
        private BufferedReader in;
        private BufferedReader inputMsg;
        private Game game;


        Client() {
            try {
                game = new Game(this);
                inputMsg = new BufferedReader(new InputStreamReader(System.in));
                activeSocket = new Socket(host(), port());
                out = new BufferedWriter(new OutputStreamWriter(activeSocket.getOutputStream()));
                in = new BufferedReader(new InputStreamReader(activeSocket.getInputStream()));
                nick();
            } catch (IOException ioEx) {
                System.out.println(ioEx.getMessage());
            }
        }


        private String host(){
            try {
                System.out.println("\nEnter Host: ");
                String host = null;

                host = inputMsg.readLine();

                return host;
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        private int port(){
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

        private void nick(){
            try {
                char[] sentBuffer;
                System.out.println("\nEnter Nickname: ");
                sentBuffer = ("\\nick " + inputMsg.readLine()).toCharArray();

                out.write(sentBuffer, 0, sentBuffer.length);
                out.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        void init(){
            System.out.println("Connection established.");
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (!activeSocket.isClosed()){
                        receive();
                    }
                }
            }).start();
            while (!this.activeSocket.isClosed()) {
                this.send();
            }
        }

        private void send() {
            try {
                char[] sentBuffer;
                String inputMessage = inputMsg.readLine();
                sentBuffer = inputMessage.toCharArray();
                out.write(sentBuffer, 0, sentBuffer.length);
                out.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    void send(String gameMessage) {
        try {
            char[] sentBuffer;
            String inputMessage = gameMessage;
            sentBuffer = inputMessage.toCharArray();
            out.write(sentBuffer, 0, sentBuffer.length);
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

        private void receive() {
            try {
                char[] receiveBuffer = new char[1028];
                int readCount = 0;
                readCount = in.read(receiveBuffer);
                String receiveBufferStr = String.valueOf(receiveBuffer, 0, readCount);
                if(receiveBufferStr.substring(0, 2).equals("\\\\")) {
                    game.show(receiveBufferStr.substring(2));
                } else {
                    System.out.println(receiveBufferStr);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
