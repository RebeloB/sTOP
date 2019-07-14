package org.academiadecodigo.bootcamp.server.wordValidation;

public class Player {
    /**
     * HashMap<Id, name>
     */
    private int id;
    private String name;
    private int points;

    public Player(int id, String name){
        this.id = id;
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Player{" +
                " name='" + name + '\'' +
                '}';
    }
}
