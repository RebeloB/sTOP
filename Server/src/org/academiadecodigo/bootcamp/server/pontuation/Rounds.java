package org.academiadecodigo.bootcamp.server.pontuation;

import org.academiadecodigo.bootcamp.server.wordValidation.Player;

import java.util.concurrent.ConcurrentHashMap;

public class Rounds { // TODO: 2019-07-14 Recive output of Tomaz points
    /**
     * HashMap<Round, score>
     */
    private int round;
    private int score;

    //private Player player;
    private int player;
    private int[] roundScore;

    private ConcurrentHashMap<Integer, Integer> playerRound; // round, score
    //private ConcurrentHashMap<Integer, Integer> playerRound; // player, score

    public Rounds(int round, int score){
        playerRound = new ConcurrentHashMap<>();
        this.score = score;
        this.round = round;
    }

    /**
     * Must recive (player id, cat1(score), cat2(score), cat3(score), cat4(score))
     *
     *
     */


    /**
     * Put player and score of the round and increments round HASHMAP
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
