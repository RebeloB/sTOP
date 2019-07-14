package org.academiadecodigo.bootcamp.server.wordValidation;

import org.academiadecodigo.bootcamp.server.pontuation.Game;
import org.academiadecodigo.bootcamp.server.pontuation.Ranking;
import org.academiadecodigo.bootcamp.server.pontuation.Rounds;

import java.io.IOException;

public class MainTest {
    public static void main(String[] args) throws IOException {
        Player player1 = new Player(1, "manu");
        Player player2 = new Player(2,"david");

        Game game1 = new Game();

        //updateScoresAfterRound
        /**
         * First Player Round 1
         * Update Score
         * Prints Round score
         *
         */
        Rounds firstRoundsP1 = new Rounds(1,20);
        firstRoundsP1.updateScore();
        firstRoundsP1.roundsScores();

        /**
         * Second Player Round 1
         * Update Score
         * Prints Round score
         *
         */
        Rounds firstRoundsP2 = new Rounds(1,20);
        firstRoundsP2.updateScore();
        firstRoundsP2.roundsScores();

        /**
         * First Player Round 2
         * Update Score
         * Prints Round score
         *
         */
        Rounds secondRoundsP1 = new Rounds(2,10);
        secondRoundsP1.updateScore();
        secondRoundsP1.roundsScores();

        /**
         * Second Player Round 2
         * Update Score
         * Prints Round score
         *
         */
        Rounds secondRoundsP2 = new Rounds(2,20);
        secondRoundsP2.updateScore();
        secondRoundsP2.roundsScores();

        //------------------------------------------------------

        //Gets Player and total points of Game (2 Rounds)
        /**
         * Gets GameScore ()
         */
        game1.updateGameScore(player1, firstRoundsP1, secondRoundsP1);
        game1.updateGameScore(player2, firstRoundsP2, secondRoundsP2);

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

/**
 * TESTING:
 *  Animal List: with List view
 * */
/*
        ReaderListAnimals listAnimals = new ReaderListAnimals();


        listAnimals.readFileAnimals();

        listAnimals.printWords();

        System.out.println(listAnimals.isValid("cao"));
*/
/**
 * Fruit List: with List view
 */




/**
 * BrandsMotor List: with List view
 */
/*
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
*/

        /**
         * Countries List : with List view
         */
/*
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
  */

}
}
