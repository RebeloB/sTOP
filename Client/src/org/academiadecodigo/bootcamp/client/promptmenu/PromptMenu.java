package org.academiadecodigo.bootcamp.client.promptmenu;
import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.string.StringInputScanner;


import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;

public class PromptMenu {

    PromptQuestions promptQuestions;

    private Socket client;
    private Prompt prompt;
    private PrintStream outPrint;


    public PromptMenu(Socket client) throws IOException {
        this.client = client;
        prompt = new Prompt(client.getInputStream(),new PrintStream(client.getOutputStream()));     // Created input for user commands
        promptQuestions = new PromptQuestions(prompt);
    }


    public String getNickname(){

        String answer = promptQuestions.doUsername();
        System.out.println("Your nickname: " + answer);
        return answer;
    }


    public void listCategorys(String[] categorys){
        promptQuestions.categorysMenus(categorys);
    }


    public void mainMenu(){
        promptQuestions.showMainMenu(prompt);
    }
}
