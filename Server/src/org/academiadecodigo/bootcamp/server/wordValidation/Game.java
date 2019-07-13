package org.academiadecodigo.bootcamp.server.wordValidation;


import java.util.concurrent.ConcurrentHashMap;

public class Game {
    private ConcurrentHashMap<Player, Rounds> roundsScores;
    private Rounds rounds;

    public Game(){ // TODO: 2019-07-13 Adicionar um update game, com resultado das rondas
        roundsScores = new ConcurrentHashMap<>();
    }

    public void updateRoundScores(){

    }

    /**
     * getGameScore Sums the rounds of the player and prints Player and gamescore
     * @param player
     * @param rounds1
     * @param rounds2
     */
    public void UpdateGameScore(Player player, Rounds rounds1, Rounds rounds2){

        roundsScores.put(player,rounds1);
        roundsScores.put(player,rounds2);

        //Total gameScore:
        int gameScore = rounds1.getScore() + rounds2.getScore();

        System.out.println("\n Total: " + gameScore);
    }

    /**
     * get gameScore for all players
     */
    public void getGameScore(){
        roundsScores.forEach((player, rounds)-> System.out.println("Key: " + player + " round: " + rounds));
    }

}
