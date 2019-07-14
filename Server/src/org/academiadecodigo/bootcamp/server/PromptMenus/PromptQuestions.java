package org.academiadecodigo.bootcamp.server.PromptMenus;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.menu.MenuInputScanner;
import org.academiadecodigo.bootcamp.scanners.string.StringInputScanner;

import java.util.Arrays;

public  class PromptQuestions {
    private Prompt prompt;
    private String[] answers;
    private PromptMenu promptMenu;


    public PromptQuestions(Prompt prompt, PromptMenu promptMenu){
        this.promptMenu = promptMenu;
        this.prompt = prompt;
    }

    public void init(/*String[] categorys*/ int id) {
        answers = new String[5]; //TODO: length to 5 -> so we can add the ID on index 0
        //TODO: add the ID to index 0
        answers[0] = (id + ",");
        for (int i = 1; i < answers.length; i++) {
            answers[i] = ",";
        }
        categorysMenus(/*categorys*/);
    }

                                            // TODO: 2019-07-13   Very spaguetthi !!


    /**
     *
     * @returns the username chosen;
     * */
    public String promptUsername(){
        StringInputScanner nickname = new StringInputScanner();
        nickname.setMessage("Insert your nicknamme: ");

        String answer =  prompt.getUserInput(nickname);
        System.out.println(answer);
        return answer;
    }


    /**   */
    private void joinAnswers(String answer,int answerIndex){

        answers[answerIndex] = (answer + ",");   //Alterado de 4 para 5

        for (String word : answers){
            System.out.println(word);
        }
    }




    public void showMainMenu(Prompt prompt){

        String[] options = {" Enter game", " Create a game"};

        MenuInputScanner menuInput = new MenuInputScanner(options);
        menuInput.setMessage("Do you with to : ");
        int answer = prompt.getUserInput(menuInput);

        switch (answer){
            case 1:
                System.out.println("Soon entering a game");
                break;
            case 2:
                System.out.println("Creating a game .... ishh");
                break;
        }
    }



    public void categorysMenus(/*String[] option*/) {
        String[] options = new String[/*option.length*/ 4 + 1];
/*        for (int i = 0; i < option.length; i++) {
            options[i] = option[i];
        }*/
        options[0] = "Animals";
        options[1] = "Vehicles Brand";
        options[2] = "Fruits";
        options[3] = "Countries";
        options[/*options.length-1*/4] = "Quit";

        MenuInputScanner menu = new MenuInputScanner(options);
        menu.setMessage("Select a category: ");

        int answer = prompt.getUserInput(menu);

        switch (answer){

            case 1 :
                System.out.println("animals category: ");
                joinAnswers(animalQuestions(),answer);
                break;
            case 2:
                System.out.println("vehicles brands: ");
                joinAnswers(vehiclesQuestions(),answer);
                break;
            case 3:
                System.out.println("fruits: ");
                joinAnswers(fruitQuestions(),answer);
                break;
            case 4:
                System.out.println("countries: ");
                joinAnswers(countryQuestions(),answer);
                //countryQuestions();
                break;
            case 5:
                System.err.println("Quit required");
                /*this.answers = */endGame();
                System.out.println(getAnswers() + " of player");
                return;
        }

        categorysMenus(/*option*/);
    }




    public String animalQuestions() {
        StringInputScanner answer = new StringInputScanner();
        answer.setMessage("An animal with the letter:  ");

        String  animalAnswer = prompt.getUserInput(answer);
        return  animalAnswer;
    }

    private String fruitQuestions(){

        StringInputScanner fruitInput = new StringInputScanner();
        fruitInput.setMessage("Say a fruit with the letter: ");

        String answer = prompt.getUserInput(fruitInput);
        return  answer;
    }

    private String vehiclesQuestions(){

        StringInputScanner vehiclesInput = new StringInputScanner();
        vehiclesInput.setMessage("Insert a vehicle the the letter: ");

        String answer = prompt.getUserInput(vehiclesInput);
        return answer;
    }


    private String countryQuestions(){
        StringInputScanner countryInput = new StringInputScanner();
        countryInput.setMessage("Insert a country with the letter: ");

        String answer = prompt.getUserInput(countryInput);
        return answer;
    }

    private void /*String[]*/ endGame(){
        System.out.println("Player asked to end the game!");
        String test = "";
        //promptMenu.send(this.answers);
        for (int i = 0; i < answers.length; i++) {
            test = test + answers[i];
        }
        System.out.println(test);
    }

    public String[] getAnswers() {
        return answers;
    }
}
