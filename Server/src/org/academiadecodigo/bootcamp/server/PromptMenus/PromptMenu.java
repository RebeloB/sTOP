package org.academiadecodigo.bootcamp.server.PromptMenus;
import org.academiadecodigo.bootcamp.Prompt;


import java.io.*;
import java.net.Socket;

public class PromptMenu {

    PromptQuestions promptQuestions;

    private Socket client;
    private Prompt prompt;
    private PrintStream outPrint;
    private int ID;
    private boolean done;


    public PromptMenu(Socket client) throws IOException {
        this.client = client;
        this.done = false;
        prompt = new Prompt(client.getInputStream(), new PrintStream(client.getOutputStream()));     // Created input for user commands
        promptQuestions = new PromptQuestions(prompt, this);
    }

    public String getNickname(){
        String answer = promptQuestions.promptUsername();
        System.out.println("Your nickname: " + answer);
        return answer;
    }

    public void listCategorys(int id){   //todo Metodo a invocar com a lista das categorias;
        this.ID = id;
        promptQuestions.init(id);
    }


    public void mainMenu(){
        promptQuestions.showMainMenu(prompt);
    }

    public PromptQuestions getPromptQuestions() {
        return promptQuestions;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public boolean isDone() {
        return done;
    }
}
