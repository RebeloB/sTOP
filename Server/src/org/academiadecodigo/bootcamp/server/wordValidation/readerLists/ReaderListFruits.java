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
    String[] words;
    private boolean valid;

    private File frutas = new File("/Users/codecadet/Desktop/sTOP/Server/resources/Frutas.txt");

    public void readFileFruits() throws IOException {

        FileReader fileReader = new FileReader(frutas);
        BufferedReader bReader = new BufferedReader(fileReader);

        String line = "";
        String result = "";

        while((line = bReader.readLine()) != null){

            result += line.toLowerCase() + " ";
        }

        bReader.close();

        words = result.split(" ");

        //Collections.addAll(listFruits, result);
    }

    public boolean isValid(String word){
        for (int i = 0; i < this.words.length; i++) {
            if (this.words[i].equals(word)) {
                return valid = true;
            } else{
                valid = false;
            }
        } return valid;
    }

    @Override
    public Iterator<String> iterator() {
        return listFruits.iterator();
    }

}
