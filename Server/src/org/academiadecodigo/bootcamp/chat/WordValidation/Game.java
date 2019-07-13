package org.academiadecodigo.bootcamp.chat.WordValidation;

import java.util.concurrent.ConcurrentHashMap;

public class Game {
    //private ConcurrentHashMap<Player, Rounds> roundsScores;
    private Rounds rounds;

    public Game(){
        //roundsScores = new ConcurrentHashMap<>();
    }

    public void getGameScore(Player player, Rounds rounds1, Rounds rounds2){
        int gameScore = rounds1.getScore() + rounds2.getScore();
        System.out.println("Game Score, Player: " + player.toString() + " Total: " + gameScore);
    }

}
