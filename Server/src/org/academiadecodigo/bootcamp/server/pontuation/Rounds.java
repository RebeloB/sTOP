package org.academiadecodigo.bootcamp.server.pontuation;

import org.academiadecodigo.bootcamp.server.wordValidation.Player;

import java.util.concurrent.ConcurrentHashMap;

public class Rounds {
    /**
     * HashMap<Round, score>
     */
    private int round;
    private int score;
    private ConcurrentHashMap<Integer, Integer> playerRound; // round, score

    public Rounds(int round, int score){
        playerRound = new ConcurrentHashMap<>();
        this.score = score;
        this.round = round;
    }

    /**
     * Put player and score of the round and increments round
     */
    public void updateScore(){
        playerRound.put(round, score);
    }

    /**
     * Set of Player round
     */

    public void roundsScores(){
        System.out.println("Round = Score:  " + playerRound.entrySet()); // TODO: 2019-07-14 number of round wrong
    }

    public int getScore() {
        return score;
    }

    public int getRound() {
        return round;
    }

    @Override
    public String toString() {
        return "Rounds{" +
                "round=" + round +
                ", score=" + score +
                '}';
    }
}
