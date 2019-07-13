package org.academiadecodigo.bootcamp.server.wordValidation;

import org.academiadecodigo.bootcamp.server.wordValidation.readerLists.ReaderListAnimals;
import org.academiadecodigo.bootcamp.server.wordValidation.readerLists.ReaderListBrands;
import org.academiadecodigo.bootcamp.server.wordValidation.readerLists.ReaderListCountries;
import org.academiadecodigo.bootcamp.server.wordValidation.readerLists.ReaderListFruits;

import java.io.IOException;

public class MainTest {
    public static void main(String[] args) {
        Player player1 = new Player(1, "manu");
        Player player2 = new Player(2,"david");

        Rounds firstRounds = new Rounds(player1,1,20);
        Rounds secondRounds = new Rounds(player1,2,10);
        Rounds firstRoundsP2 = new Rounds(player2,1,20);
        Rounds secondRoundsP2 = new Rounds(player2,2,20);

        Game game1 = new Game();

        //updateScoresAfterRound
        /**
         * First Player Round 1
         * Update Score
         * Prints Round score
         *
         */
        firstRounds.updateScore();
        firstRounds.roundsScores();

        /**
         * Second Player Round 1
         * Update Score
         * Prints Round score
         *
         */
        firstRoundsP2.updateScore();
        firstRoundsP2.roundsScores();

        /**
         * First Player Round 2
         * Update Score
         * Prints Round score
         *
         */
        secondRounds.updateScore();
        secondRounds.roundsScores();

        /**
         * Second Player Round 2
         * Update Score
         * Prints Round score
         *
         */
        secondRoundsP2.updateScore();
        secondRoundsP2.roundsScores();

        //------------------------------------------------------

        //Gets Player and total points of Game (2 Rounds)
        /**
         * Gets GameScore ()
         */
        game1.UpdateGameScore(player1, firstRounds, secondRounds);
        game1.UpdateGameScore(player2, firstRoundsP2, secondRoundsP2);

        game1.getGameScore();

        //player 1, Game1 & player 2 Game1
        Ranking rankingP1G1 = new Ranking(player1, game1);
        Ranking rankingP2G1 = new Ranking(player2, game1);

        //player 2, Round 1 & 2, Game1
        //Ranking rankingP2R1 = new Ranking(player2,firstRounds ,game1);
        //Ranking rankingP2R2 = new Ranking(player2,secondRounds ,game1);


        //puts <player, rounds>
        rankingP1G1.updateRanking();
        rankingP2G1.updateRanking();

        //rankingP2R1.updateRanking();
        //rankingP2R2.updateRanking();

        //Prints Ranking
        rankingP1G1.showRanking();
        rankingP2G1.showRanking();

        //rankingP2R1.showRanking();
        //rankingP2R2.showRanking();


        //----------------------------------------------------------------------
/*
        WordReader reader = new WordReader();

        try {
            reader.initFileReader();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        //reader.initReader();

        reader.readLinesAnimals();
*/

/**
 * Animal List: with List view
 * */
    ReaderListAnimals listAnimals = new ReaderListAnimals();

        try {
            //Animals List:
            listAnimals.readFileAnimals();
            System.out.println("\nLista Animais: ");

            //Printing Animal List
            for (String s: listAnimals) {
                System.out.println(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

/**
 * Fruit List: with List view
 */

    ReaderListFruits listFruits = new ReaderListFruits();

    try {

        listFruits.readFileFruits();
        System.out.println("\nLista Frutas: ");

        for (String f: listFruits) System.out.println(f);

    } catch (IOException e) {
        e.printStackTrace();
    }

/**
 * BrandsMotor List: with List view
 */

        ReaderListBrands listBrands = new ReaderListBrands();

        try {
            listBrands.readFileBrands();
            System.out.println("\nLista Marcas Motorizadas: ");

            for (String b: listBrands) {
                System.out.println(b);
            }
        } catch (IOException e){
            e.printStackTrace();
        }


        /**
         * Countries List : with List view
         */

        ReaderListCountries listCountries = new ReaderListCountries();

        try {
            listCountries.readFileCountries();
            System.out.println("\nLista Paises: ");

            for (String c: listCountries) {
                System.out.println(c);
            }
        } catch (IOException c){
            c.printStackTrace();
        }
    }
}
