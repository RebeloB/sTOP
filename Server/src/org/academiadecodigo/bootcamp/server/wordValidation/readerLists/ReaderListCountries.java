package org.academiadecodigo.bootcamp.server.wordValidation.readerLists;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ReaderListCountries {

    String[] words;
    private boolean valid;

    private File paises = new File("/Users/codecadet/Desktop/sTOP/Server/src/org/academiadecodigo/bootcamp/server/wordValidation/readerLists/ReaderListCountries.java");

    public void readFileCountries() throws IOException {

        FileReader fileReader = new FileReader(paises);
        BufferedReader bReader = new BufferedReader(fileReader);

        String line = "";
        String result = "";

        while((line = bReader.readLine()) != null){

            result += line.toLowerCase() + " ";
        }

        bReader.close();

        words = result.split(" ");

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
}
