package org.academiadecodigo.bootcamp.server.wordValidation.readerLists;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ReaderListAnimals{

    private String[] words;
    private boolean valid;

    private File animais = new File("/Users/codecadet/Desktop/GroupProject/sTOP/Server/resources/Animais.txt");

    public void readFileAnimals() throws IOException {

        FileReader fileReader = new FileReader(animais);
        BufferedReader bReader = new BufferedReader(fileReader);

        String line = "";
        String result = "";

        while((line = bReader.readLine()) != null){

            result += line.toLowerCase() + " ";
        }

        bReader.close();

        words = result.split(" " );
    }

    public void printWords() {
        for (int i = 0; i < this.words.length; i++) {
            System.out.println(words[i]);
        }
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


