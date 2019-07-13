package org.academiadecodigo.bootcamp.server.Scoring;

import java.util.HashMap;
import java.util.Iterator;

public class HashMapRevamp implements Iterable<String>{
    private HashMap<String,Integer> hashMap = new HashMap<>();


    @Override
    public Iterator<String> iterator() {
        return hashMap.keySet().iterator();
    }

    public void add(String string){
        if(hashMap.containsKey(string)){
            hashMap.put(string,(hashMap.get(string) + 1));
            return;
        }
        hashMap.put(string,1);
    }

    public Integer get(String word){
        return hashMap.get(word);
    }

    public int size(){
        return hashMap.size();
    }

    public boolean contains(String word){
        return hashMap.containsKey(word);
    }

    public void clear(){
        hashMap.clear();

    }

}
