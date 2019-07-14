package org.academiadecodigo.bootcamp.server.Scoring;

import org.academiadecodigo.bootcamp.server.ClientHandler;
import org.academiadecodigo.bootcamp.server.wordValidation.readerLists.ReaderListAnimals;
import org.academiadecodigo.bootcamp.server.wordValidation.readerLists.ReaderListBrands;
import org.academiadecodigo.bootcamp.server.wordValidation.readerLists.ReaderListCountries;
import org.academiadecodigo.bootcamp.server.wordValidation.readerLists.ReaderListFruits;

import java.io.IOException;
import java.util.List;

public class CompareAnswers {

    //Animais/Fruta/Marcas/Países
    private HashMapRevamp words = new HashMapRevamp();
    private ReaderListAnimals animals;
    private ReaderListFruits fruits;
    private ReaderListBrands brands;
    private ReaderListCountries countries;


   /* private String player1 = "1,Cão,Banana,bigode,Portugal".toLowerCase();
    private String player2 = "2,macaco,kiwi,peugeot,espanha".toLowerCase();
    private String player3 = "3,MaCaCo,KiWi,PeUgEoT, ".toLowerCase();
    private String player4 = "4, , , , ".toLowerCase(); */



    //private String[] playersAnswers = new String[/*numbOfPlayers*/]{player1, player2, player3, player4};
    private String[][] ah; //TODO: REFACTOR THIS SHIT!!!!!!!!!!!!


    public CompareAnswers(){
        animals = new ReaderListAnimals();
        fruits = new ReaderListFruits();
        brands = new ReaderListBrands();
        countries = new ReaderListCountries();

    }


    private void validate() {
        for (int i = 1; i < 5; i++) { //TODO: REFACTOR THIS SHITT

            for (int j = 0; j < 4; j++) {  //TODO: change magic number 4 to player number
                switch (i) {
                    case 1:
                        if (animals.isValid(ah[j][i])) {
                            break;
                        }
                        ah[j][i] = " ";
                        break;
                    case 2:
                        if (fruits.isValid(ah[j][i])) {
                        break;
                        }
                            ah[j][i] = " ";
                        break;

                    case 3:
                        if (brands.isValid(ah[j][i])) {
                        break;
                        }
                            ah[j][i] = " ";
                        break;
                    case 4:
                        if (countries.isValid(ah[j][i])) {
                        break;
                        }
                            ah[j][i] = " ";
                }
            }
        }
    }


    public void compare() {



        validate();


        // numbOfCat+1
        for (int i = 1; i < 5; i++) {  // TODO: change magic number 5

            //numOfPlayers
            for (int j = 0; j < 4; j++) { //TODO: change magic number 4
                words.add(ah[j][i]);
            }
            //mudança de categoria

            //verificar respostas
            attributePoints(i);

            //clear no mapa
            words.clear();

            //apagar esta parte foi só pra testes
            System.out.println("Category: " + i);
            System.out.println("player1 points: " + ah[0][i]);
            System.out.println("player2 points: " + ah[1][i]);
            System.out.println("player3 points: " + ah[2][i]);
            System.out.println("player4 points: " + ah[3][i]);
            System.out.println("------------------------------");


        }
    }

    private void attributePoints(int category) {

        for (String word : words) {
            if (!(word.equals(" "))) {
                for (int j = 0; j < 4; j++) { //TODO: change magic number 4

                    if (words.get(word) == 1) {
                        if (ah[j][category].equals(word)) {
                            ah[j][category] = "10";
                        }
                    } else {
                        if (ah[j][category].equals(word)) {
                            ah[j][category] = "5";
                        }
                    }
                }
            } else {
                for (int i = 0; i < 4; i++) {   //TODO: change magic number 4
                    if (ah[i][category].equals(" ")) {
                        ah[i][category] = "0";
                    }
                }
            }
        }
    }

    public void initLists(){
        try {
            animals.readFileAnimals();
            fruits.readFileFruits();
            brands.readFileBrands();
            countries.readFileCountries();
        }catch (IOException io){
            System.out.println(io.getMessage());
        }
    }

    public void receiveAnswers(List<ClientHandler> activePlayers){
        //[numberOfPlayers][numberOfCategories+1]
        ah = new String[activePlayers.size()][5];// TODO: change magic number 5 and 4
        int counter = 0;

        for (ClientHandler client : activePlayers){
            ah[counter] = client.getPromptMenu().getPromptQuestions().getAnswers();
            counter++;
        }
    }


    public static void main(String[] args) {
            CompareAnswers comp = new CompareAnswers();
            comp.initLists();
            comp.compare();

    }

    }
