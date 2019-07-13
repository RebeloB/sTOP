package org.academiadecodigo.bootcamp.server.wordValidation.readerLists;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ReaderListAnimals implements Iterable<String>{

    private List<String> listAnimals = new LinkedList<>();

    private File animais = new File("/Users/codecadet/Desktop/StopGame/sTOP/Server/files/Animais.txt");

    public void readFileAnimals() throws IOException {

        FileReader fileReader = new FileReader(animais);
        BufferedReader bReader = new BufferedReader(fileReader);

        String line = "";
        String[] word;
        String result = "";

        while((line = bReader.readLine()) != null){

            result += line.toLowerCase() + "\n";
        }

        bReader.close();

        //word = result.split(" ");

        Collections.addAll(listAnimals, result);
    }

    public boolean isValid(String word){
        if(!listAnimals.contains(word)){
            return false;
        }
        return true;
    }

    @Override
    public Iterator<String> iterator() {
        return listAnimals.iterator();
    }
}

