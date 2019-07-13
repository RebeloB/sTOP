package org.academiadecodigo.bootcamp.chat.WordValidation;

import org.academiadecodigo.bootcamp.chat.ClientHandler;

import java.util.concurrent.ConcurrentHashMap;

public class Rounds {
    /**
     * HashMap<Player, score>
     */
    private int round;
    private Player player;
    private int score;
    private ConcurrentHashMap<Player, Integer> playerRound;

    public Rounds(Player player, int round, int score){
        playerRound = new ConcurrentHashMap<>();
        this.player = player;
        this.score = score;
        this.round = round;
    }

    public void updateScore(){
        playerRound.put(player, score);
    }

    public void roundsScores(){
        System.out.println(playerRound.entrySet());
    }



    public int getScore() {
        return score;
    }

    public int getRound() {
        return round;
    }

    public ConcurrentHashMap<Player, Integer> getPlayerRound() {
        return playerRound;
    }

    @Override
    public String toString() {
        return "Rounds{" +
                "round=" + round +
                ", score=" + score +
                '}';
    }


}
