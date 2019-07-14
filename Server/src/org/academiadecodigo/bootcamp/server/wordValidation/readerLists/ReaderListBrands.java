package org.academiadecodigo.bootcamp.server.wordValidation.readerLists;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ReaderListBrands implements Iterable<String>{

    private List<String> listBrands = new LinkedList<>();
    String[] words;
    private boolean valid;

    private File marcas = new File("resources/Marcas_Veiculos_Motorizados.txt");

    public void readFileBrands() throws IOException {

        FileReader fileReader = new FileReader(marcas);
        BufferedReader bReader = new BufferedReader(fileReader);

        String line = "";
        String result = "";

        while((line = bReader.readLine()) != null){

            result += line.toLowerCase() + " ";
        }

        bReader.close();

        words = result.split(" ");

        //Collections.addAll(listBrands, result);
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
        return listBrands.iterator();
    }
}
