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
    private static HashMapRevamp words = new HashMapRevamp();
    private ReaderListAnimals animals;
    private ReaderListFruits fruits;
    private ReaderListBrands brands;
    private ReaderListCountries countries;
    private int numberOfPlayers;


    /*private String player1 = "1,Cão,Banana,bigode,Portugal".toLowerCase();
    private String player2 = "2,macaco,kiwi,peugeot,espanha".toLowerCase();
    private String player3 = "3,MaCaCo,KiWi,PeUgEoT, ".toLowerCase();
    private String player4 = "4, , , , ".toLowerCase();*/



    //private String[] playersAnswers = new String[numberOfPlayers];
    private String[][] ah; //TODO: REFACTOR THIS SHIT!!!!!!!!!!!!


    public CompareAnswers(){
        animals = new ReaderListAnimals();
        fruits = new ReaderListFruits();
        brands = new ReaderListBrands();
        countries = new ReaderListCountries();

    }


    private void validate() {
        for (int i = 1; i < 5; i++) { //TODO: REFACTOR THIS SHITT

            for (int j = 0; j < numberOfPlayers; j++) {
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


    public int[] compare() {

        //checks if the answers are correct based on the lists
        validate();


        // numbOfCat+1
        for (int i = 1; i < 5; i++) {  // TODO: change magic number 5

            //numOfPlayers
            for (int j = 0; j < numberOfPlayers; j++) {
                words.add(ah[j][i]);
            }
            //mudança de categoria

            //verificar respostas entre players
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
           return getScores();
    }

    private void attributePoints(int category) {

        for (String word : words) {
            if (!(word.equals(" "))) {
                for (int j = 0; j < numberOfPlayers; j++) {

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
                for (int i = 0; i < numberOfPlayers; i++) {
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
        numberOfPlayers = activePlayers.size();

        ah = new String[activePlayers.size()][5];// TODO: change magic number 5
        int counter = 0;

        for (ClientHandler client : activePlayers){
            ah[counter] = client.getPromptMenu().getPromptQuestions().getAnswers();
            counter++;
        }
        initLists();
        compare();
    }


    private int[] getScores(){
        int[] scores = new int[numberOfPlayers];
        int playerScore = 0;
        for (int i = 0; i < numberOfPlayers; i++) {
            for (int j = 1; j < 5; j++) {
                try {
                    playerScore = playerScore + Integer.parseInt(ah[i][j]);
                }catch (NumberFormatException nfe){
                    System.out.println(nfe.getMessage());
                }
            }
            scores[i] = playerScore;
            System.out.println(scores[i]);

        }
            return scores;
    }

    }
