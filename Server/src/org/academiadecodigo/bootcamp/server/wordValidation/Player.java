package org.academiadecodigo.bootcamp.server.wordValidation;

public class Player {
    /**
     * HashMap<Id, name>
     */
    private int id;
    private String name;

    public Player(int id, String name){
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Player{" +
                " name='" + name + '\'' +
                '}';
    }
}
