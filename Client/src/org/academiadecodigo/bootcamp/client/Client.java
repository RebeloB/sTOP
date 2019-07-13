package org.academiadecodigo.bootcamp.client;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.client.promptmenu.PromptMenu;

import java.io.*;
import java.net.Socket;

public class Client {
        private Socket activeSocket;
        private BufferedWriter out;
        private BufferedReader in;
        private BufferedReader inputMsg;
        private Game game;

        private PromptMenu promptMenu;


        public Client() {
            try {
               // game = new Game(this);
                inputMsg = new BufferedReader(new InputStreamReader(System.in));
                activeSocket = new Socket(host(), port());
                out = new BufferedWriter(new OutputStreamWriter(activeSocket.getOutputStream()));
                in = new BufferedReader(new InputStreamReader(activeSocket.getInputStream()));

                promptMenu = new PromptMenu(activeSocket);
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

        /* private void nick(){
                promptMenu.getNickname();
        } */

        void init(){
            System.out.println("Connection established.");
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (!activeSocket.isClosed()){
                      //  receive();
                        promptMenu.getNickname();  /**  Debbugin reasons */
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
            promptMenu.getNickname();
        }

    }
