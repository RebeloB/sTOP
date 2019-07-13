package org.academiadecodigo.bootcamp.chat.WordValidation;

import java.util.concurrent.ConcurrentHashMap;

public class Ranking {
    /**
     * HashMap de Players <nameId, PointsGame>
     *
     */
    private ConcurrentHashMap<Player, Rounds> ranking; // TODO: 2019-07-13 change rounds to game 
    private Player player;
    private Rounds rounds;
    private Game game;

    // TODO: 2019-07-13 update construtor to recive a game and update the ranking with the game score 
    public Ranking(Player player,Rounds rounds ,Game game){
        this.ranking = new ConcurrentHashMap<>();
        this.player = player;
        this.game = game;
        this.rounds = rounds;
    }

    /**
     * update must receive a HashMap of roundScore
     */
    public void updateRanking(){
        // TODO: 2019-07-13 change rounds to game 
        ranking.put(player, rounds);
        //Sum the score of the rounds and update


    }

    public void showRanking(){
        System.out.println("Ranking: " + ranking.entrySet());
    }


}
