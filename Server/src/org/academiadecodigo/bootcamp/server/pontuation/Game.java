package org.academiadecodigo.bootcamp.server.pontuation;


import org.academiadecodigo.bootcamp.server.pontuation.Rounds;
import org.academiadecodigo.bootcamp.server.wordValidation.Player;

import java.util.concurrent.ConcurrentHashMap;

public class Game {
    private ConcurrentHashMap<Player, Rounds> roundsScores;
    private Rounds rounds;
    private int gameScore;

    public Game(){ // TODO: 2019-07-13 Adicionar um update game, com resultado das rondas
        roundsScores = new ConcurrentHashMap<>();
    }

    /**
     * getGameScore Sums the rounds of the Player and prints Player and GameScore
     * @param player
     * @param rounds1
     * @param rounds2
     */
    public void updateGameScore(Player player, Rounds rounds1, Rounds rounds2){

        roundsScores.put(player,rounds1);
        roundsScores.put(player,rounds2);

        //Total gameScore:
        gameScore = rounds1.getScore() + rounds2.getScore();
    }

    /**
     * get gameScore for all players
     */
    public void getGameScore(){
        roundsScores.forEach((player, rounds)-> System.out.println( player + " Total: " + gameScore));
    }

    @Override
    public String toString() {
        return "Game{" +
                "roundsScores=" + roundsScores +
                '}';
    }
}
