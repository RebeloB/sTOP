package org.academiadecodigo.bootcamp.server.wordValidation.readerLists;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ReaderListCountries implements Iterable<String> {

    private List<String> listCountries = new LinkedList<>();

    private File paises = new File("/Users/codecadet/Desktop/StopGame/sTOP/Server/files/Paises.txt");

    public void readFileCountries() throws IOException {

        FileReader fileReader = new FileReader(paises);
        BufferedReader bReader = new BufferedReader(fileReader);

        String line = "";
        String[] word;
        String result = "";

        while((line = bReader.readLine()) != null){

            result += line.toLowerCase() + "\n";
        }

        bReader.close();

        //word = result.split(" ");

        Collections.addAll(listCountries, result);
    }

    public boolean isValid(String word){
        if(!listCountries.contains(word)){
            return false;
        }
        return true;
    }

    @Override
    public Iterator<String> iterator() {
        return listCountries.iterator();
    }
}
