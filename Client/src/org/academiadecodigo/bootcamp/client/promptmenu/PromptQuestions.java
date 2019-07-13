package org.academiadecodigo.bootcamp.client.promptmenu;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.menu.MenuInputScanner;
import org.academiadecodigo.bootcamp.scanners.string.StringInputScanner;

public  class PromptQuestions {
    private Prompt prompt;
    private String[] answers;

    public PromptQuestions(Prompt prompt){
        this.prompt = prompt;
    }

                                            // TODO: 2019-07-13   Very spaguetthi !!

    public String doUsername(){

        StringInputScanner nickname = new StringInputScanner();
        nickname.setMessage("Insert your nicknamme: ");

        String answer =  prompt.getUserInput(nickname);
        return  answer;
    }


    private void joinAnswers(String answer){
        for (int x=0; x < answers.length +1; x++){
            if (answers[x] != null)
                answers[x] = answer;
                return;  // Break
        }
    }

    public String[]  getFinalAnswers(){
        return answers;
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



    public void categorysMenus(String[] option) {

        MenuInputScanner menu = new MenuInputScanner(option);
        menu.setMessage("Select a category: ");

        int answer = prompt.getUserInput(menu);
        String catgHolder = option[answer];

        switch (catgHolder){

            case "animals"  :
                System.out.println(catgHolder + " category: ");
                animalQuestions();
                break;
            case "fruits":
                System.out.println(catgHolder + " category");
                fruitQuestions();
                break;
            case "vehicles":
                vehiclesQuestions();
                break;
            case "contrys":
                countryQuestions();
                break;
        }
    }




    public void animalQuestions() {
        StringInputScanner answer = new StringInputScanner();
        answer.setMessage("An animal with the letter:  ");

        String  animalAnswer = prompt.getUserInput(answer);
        System.out.println(animalAnswer);
        joinAnswers(animalAnswer);
    }

    private void  fruitQuestions(){

        StringInputScanner fruitInput = new StringInputScanner();
        fruitInput.setMessage("Say a fruit with the letter: ");

        String answer = prompt.getUserInput(fruitInput);
        joinAnswers(answer);
    }

    private void vehiclesQuestions(){

        StringInputScanner vehiclesInput = new StringInputScanner();
        vehiclesInput.setMessage("Insert a vehicle the the letter: ");

        String answer = prompt.getUserInput(vehiclesInput);
        joinAnswers(answer);
    }


    private void countryQuestions(){
        StringInputScanner countryInput = new StringInputScanner();
        countryInput.setMessage("insert a contry with the letter: ");

        String answer = prompt.getUserInput(countryInput);
        joinAnswers(answer);
    }



}
