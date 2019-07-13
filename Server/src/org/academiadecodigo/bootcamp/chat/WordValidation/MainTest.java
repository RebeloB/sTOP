package org.academiadecodigo.bootcamp.chat.WordValidation;

public class MainTest {
    public static void main(String[] args) {
        Player player1 = new Player(1, "manu");
        Player player2 = new Player(2,"david");

        Rounds firstRounds = new Rounds(player1, 1,20);
        Rounds secondRounds = new Rounds(player1, 2,10);
        Rounds firstRoundsP2 = new Rounds(player2, 1,20);
        Rounds secondRoundsP2 = new Rounds(player2, 2,20);
        Game game1 = new Game();

        //updateScoresAfterRound
        firstRounds.updateScore();
        secondRounds.updateScore();

        firstRoundsP2.updateScore();
        secondRoundsP2.updateScore();

        //Gets Player and total points of Game (2 Rounds)
        game1.getGameScore(player1, firstRounds, secondRounds);
        game1.getGameScore(player2, firstRoundsP2, secondRoundsP2);

        //Ranking knows about player and
        //player 1, Round 1 & 2, Game1
        Ranking rankingP1R1 = new Ranking(player1,firstRounds ,game1);
        Ranking rankingP1R2 = new Ranking(player1,secondRounds ,game1);

        //player 2, Round 1 & 2, Game1
        Ranking rankingP2R1 = new Ranking(player2,firstRounds ,game1);
        Ranking rankingP2R2 = new Ranking(player2,secondRounds ,game1);


        //puts <player, rounds>
        rankingP1R1.updateRanking();
        rankingP1R2.updateRanking();

        rankingP2R1.updateRanking();
        rankingP2R2.updateRanking();

        //Prints Ranking
        rankingP1R1.showRanking();
        rankingP1R2.showRanking();

        rankingP2R1.showRanking();
        rankingP2R2.showRanking();


    }
}
