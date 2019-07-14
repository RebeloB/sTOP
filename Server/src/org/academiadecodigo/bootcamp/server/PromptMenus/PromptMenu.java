package org.academiadecodigo.bootcamp.server.PromptMenus;
import org.academiadecodigo.bootcamp.Prompt;


import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;

public class PromptMenu {

    PromptQuestions promptQuestions;

    private Socket client;
    private Prompt prompt;
    private PrintStream outPrint;
    private int ID;


    public PromptMenu(Socket client) throws IOException {
        this.client = client;
        prompt = new Prompt(client.getInputStream(),new PrintStream(client.getOutputStream()));     // Created input for user commands
        promptQuestions = new PromptQuestions(prompt);

    }


    public String getNickname(){

        String answer = promptQuestions.promptUsername();
        System.out.println("Your nickname: " + answer);
        return answer;
    }


    public void listCategorys(/*String[] categorys*/int id){   //todo Metodo a invocar com a lista das categorias;
        this.ID = id;
        promptQuestions.init(/*categorys*/id);
    }


    public void mainMenu(){

        promptQuestions.showMainMenu(prompt);
    }
}
