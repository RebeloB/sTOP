package org.academiadecodigo.bootcamp.server.pontuation;

import org.academiadecodigo.bootcamp.server.wordValidation.Player;

import java.util.concurrent.ConcurrentHashMap;

public class Ranking {
    /**
     * HashMap de Players.txt <nameId, PointsGame>
     *
     */
    private ConcurrentHashMap<Player, Game> ranking;
    private Player player;
    private Rounds rounds;
    private Game game;

    // TODO: 2019-07-13 update construtor to recive a game and update the ranking with the game score 
    public Ranking(Player player,Game game){
        this.ranking = new ConcurrentHashMap<>();
        this.player = player;
        this.game = game;

    }

    /**
     * update must receive a HashMap of roundScore
     */
    public void updateRanking(){
        ranking.put(player, game);
    }

    public void showRanking(){
        System.out.println("Ranking: \n" + ranking.entrySet());
    }


}
