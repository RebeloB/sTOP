package org.academiadecodigo.bootcamp.server.wordValidation.readerLists;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ReaderListFruits implements Iterable<String> {

    private List<String> listFruits = new LinkedList<>();
    private File frutas = new File("resources/Frutas.txt");

    public void readFileFruits() throws IOException {

        FileReader fileReader = new FileReader(frutas);
        BufferedReader bReader = new BufferedReader(fileReader);

        String line = "";
        String[] word;
        String result = "";

        while((line = bReader.readLine()) != null){

            result += line.toLowerCase() + " ";
        }

        bReader.close();

        //word = result.split(" ");

        Collections.addAll(listFruits, result);
    }

    public boolean isValid(String word){
        if(listFruits.contains(word)){
            return true;
        }
        return false;
    }

    @Override
    public Iterator<String> iterator() {
        return listFruits.iterator();
    }

}
