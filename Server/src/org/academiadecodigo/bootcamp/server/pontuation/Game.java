package org.academiadecodigo.bootcamp.server.pontuation;


import org.academiadecodigo.bootcamp.server.pontuation.Rounds;
import org.academiadecodigo.bootcamp.server.wordValidation.Player;

import java.util.concurrent.ConcurrentHashMap;

public class Game {
    private ConcurrentHashMap<Player, Rounds> roundsScores;
    private Rounds rounds;
    private int gameScore;
    private static String letter;

    public Game() { // TODO: 2019-07-13 Adicionar um update game, com resultado das rondas
        roundsScores = new ConcurrentHashMap<>();
    }

    /**
     * getGameScore Sums the rounds of the Player and prints Player and GameScore
     *
     * @param player
     * @param rounds1
     * @param rounds2
     */
    public void updateGameScore(Player player, Rounds rounds1, Rounds rounds2) {

        roundsScores.put(player, rounds1);
        roundsScores.put(player, rounds2);

        //Total gameScore:
        gameScore = rounds1.getScore() + rounds2.getScore();
    }

    /**
     * get gameScore for all players
     */
    public void getGameScore() {
        roundsScores.forEach((player, rounds) -> System.out.println(player + " Total: " + gameScore));
    }

    @Override
    public String toString() {
        return "Game{" +
                "roundsScores=" + roundsScores +
                '}';
    }

    public static String randomLetter() {
        char[] alphabet = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'x', 'z'};

        int choice = (int) (Math.ceil(Math.random() * 23));

        letter = String.valueOf(alphabet[choice]);

        return letter;
    }

    public static String getLetter() {
        return letter;
    }
}


