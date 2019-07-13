package org.academiadecodigo.bootcamp.chat.WordValidation;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

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
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
