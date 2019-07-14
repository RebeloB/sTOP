package org.academiadecodigo.bootcamp.server.PromptMenus;
import org.academiadecodigo.bootcamp.Prompt;


import java.io.*;
import java.net.Socket;

public class PromptMenu {

    PromptQuestions promptQuestions;

    private Socket client;
    private Prompt prompt;
    //private BufferedWriter out;
    //private BufferedReader in;
    private PrintStream outPrint;
    private int ID;


    public PromptMenu(Socket client, BufferedReader in, BufferedWriter out) throws IOException {
        this.client = client;

        prompt = new Prompt(client.getInputStream(), new PrintStream(client.getOutputStream()));     // Created input for user commands
        //this.out = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
        //this.in = new BufferedReader(new InputStreamReader(client.getInputStream()));
        promptQuestions = new PromptQuestions(prompt, this);

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

/*    public void send(String[] gameMessage){
        String gameMessageStr = "";
        for (int i = 0; i < gameMessage.length; i++) {
            gameMessageStr = gameMessageStr + gameMessage[i];
        }

        try {
            out.write(gameMessageStr);
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/

    public PromptQuestions getPromptQuestions() {
        return promptQuestions;
    }
}
