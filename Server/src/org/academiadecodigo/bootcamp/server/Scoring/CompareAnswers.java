package org.academiadecodigo.bootcamp.server.Scoring;

import org.academiadecodigo.bootcamp.server.ClientHandler;
import org.academiadecodigo.bootcamp.server.Server;
import org.academiadecodigo.bootcamp.server.pontuation.Game;
import org.academiadecodigo.bootcamp.server.wordValidation.readerLists.ReaderListAnimals;
import org.academiadecodigo.bootcamp.server.wordValidation.readerLists.ReaderListBrands;
import org.academiadecodigo.bootcamp.server.wordValidation.readerLists.ReaderListCountries;
import org.academiadecodigo.bootcamp.server.wordValidation.readerLists.ReaderListFruits;

import java.io.IOException;
import java.util.List;

public class CompareAnswers {

    //Animais/Fruta/Marcas/Países

    private static HashMapRevamp words = new HashMapRevamp();
    private static ReaderListAnimals animals;
    private static ReaderListFruits fruits;
    private static ReaderListBrands brands;
    private static ReaderListCountries countries;
    private static int numberOfPlayers;
    private static String letter;
    private static int[] allScores;

    private static String[][] answerMatrix;


    public CompareAnswers() {
        animals = new ReaderListAnimals();
        fruits = new ReaderListFruits();
        brands = new ReaderListBrands();
        countries = new ReaderListCountries();

    }


    private static void validate() {
        for (int i = 1; i < 5; i++) { //TODO: Change Magic number 5

            for (int j = 0; j < numberOfPlayers; j++) {
                switch (i) {
                    case 1:
                        if (!(animals.isValid(answerMatrix[j][i]))) {
                            answerMatrix[j][i] = " ";
                            break;
                        }
                        break;
                    case 2:
                        if (fruits.isValid(answerMatrix[j][i])) {
                            break;
                        }
                        answerMatrix[j][i] = " ";
                        break;

                    case 3:
                        if (brands.isValid(answerMatrix[j][i])) {
                            break;
                        }
                        answerMatrix[j][i] = " ";
                        break;
                    case 4:
                        if (countries.isValid(answerMatrix[j][i])) {
                            break;
                        }
                        answerMatrix[j][i] = " ";
                }
            }
        }
    }


    private static void compare() {

        //checks if the answers are correct based on the lists
        validate();


        // numbOfCat+1
        for (int i = 1; i < 5; i++) {  // TODO: change magic number 5

            //numOfPlayers
            for (int j = 0; j < numberOfPlayers; j++) {
                words.add(answerMatrix[j][i]);
            }
            //mudança de categoria

            //verificar respostas entre players
            attributePoints(i);

            //clear no mapa
            words.clear();

            System.out.println("");


        }
        countScores();
    }

    private static void attributePoints(int category) {

        for (String word : words) {
            if (!(word.equals(" "))) {
                for (int j = 0; j < numberOfPlayers; j++) {

                    if (words.get(word) == 1) {
                        if (answerMatrix[j][category].equals(word)) {
                            answerMatrix[j][category] = "10";
                        }
                    } else {
                        if (answerMatrix[j][category].equals(word)) {
                            answerMatrix[j][category] = "5";
                        }
                    }
                }
            } else {
                for (int i = 0; i < numberOfPlayers; i++) {
                    if (answerMatrix[i][category].equals(" ")) {
                        answerMatrix[i][category] = "0";
                    }
                }
            }
        }
    }

    public static void initLists() {
        try {
            animals.readFileAnimals();
            fruits.readFileFruits();
            brands.readFileBrands();
            countries.readFileCountries();

        } catch (IOException io) {
            System.out.println(io.getMessage());
        }
    }

    public static void receiveAnswers() {
        //[numberOfPlayers][numberOfCategories+1]
        System.out.println("fsioafjasijfasjflkjaslkdfjlksjdfa");
        List<ClientHandler> activePlayers = Server.getClientHandler();
        numberOfPlayers = activePlayers.size();

        answerMatrix = new String[activePlayers.size()][5];// TODO: change magic number 5
        int counter = 0;

        for (ClientHandler client : activePlayers) {
            answerMatrix[counter] = client.getPromptMenu().getPromptQuestions().getAnswers();
            for (int i = 0; i < 5; i++) {
                answerMatrix[counter][i] = answerMatrix[counter][i].toLowerCase();
            }
            counter++;
        }
        initLists();
        checkLetter();
        compare();

    }


    private static int[] countScores() {
        int[] scores = new int[numberOfPlayers];
        int playerScore;
        for (int i = 0; i < numberOfPlayers; i++) {
            playerScore = 0;
            for (int j = 1; j < 5; j++) {
                try {
                    //System.out.println(playerScore + Integer.parseInt(answerMatrix[i][j]));
                    playerScore = playerScore + Integer.parseInt(answerMatrix[i][j]);
                } catch (NumberFormatException nfe) {
                    System.out.println(nfe.getMessage());
                }
            }

            int player = Integer.parseInt(answerMatrix[i][0])-1;

            scores[player] = playerScore;
            System.out.println("player" + (answerMatrix[i][0]) + ": " + scores[player]);

        }
        allScores = scores;
        return scores;
    }


    public static void checkLetter(){
        letter = Game.getLetter();
        char letterV20 = letter.charAt(0);
        for (int i = 0; i < numberOfPlayers; i++) {
            for (int j = 1; j < 5; j++) {
                if (!(answerMatrix[i][j].charAt(0) == letterV20)){
                    answerMatrix[i][j] = " ";
                }
            }
        }
    }

    public static int[] getAllScores() {
        return allScores;
    }
}
