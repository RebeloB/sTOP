package org.academiadecodigo.bootcamp.server.Scoring;

public class CompareAnswers {

    //Animais/Fruta/Marcas/Países

    //private HashSet<String> words = new HashSet<>();
    private HashMapRevamp words = new HashMapRevamp();


    private String player1 = "1,Panda,Banana,bigode,Portugal".toLowerCase();
    private String player2 = "2,Reimao,kiwi,peugeot,espanha".toLowerCase();
    private String player3 = "3,MaCaCo,KiWi,PeUgEoT, ".toLowerCase();
    private String player4 = "4, , , , ".toLowerCase();

    private String[] playersAnswers = new String[]{player1, player2, player3, player4};
    private String[][] ah;


    public void send(){

        if (false){
            System.out.println("This player word = emptyString ");
        }
    }


    public void compare() {

        //[numberOfPlayers][numberOfCategories+1]
        ah = new String[4][5];// TODO: change magic number 5 and 4

        for (int i = 0; i < playersAnswers.length; i++) {
            ah[i] = playersAnswers[i].split(",");
        }


        // numbOfCat+1
        for (int i = 1; i < 5; i++) {  // TODO: change magic number 5

            //numOfPlayers
            for (int j = 0; j < 4; j++) { //TODO: change magic number 4
                words.add(ah[j][i]);
            }
            //mudança de categoria

            //verificar respostas
            attributePoints(i);

            //clear no mapa
            words.clear();

            //apagar esta parte foi só pra testes
            System.out.println("Category: " + i);
            System.out.println("player1 points: " + ah[0][i]);
            System.out.println("player2 points: " + ah[1][i]);
            System.out.println("player3 points: " + ah[2][i]);
            System.out.println("player4 points: " + ah[3][i]);
            System.out.println("------------------------------");


        }
    }

        private void attributePoints(int category){

            for (String word : words) {
                if (!(word.equals(" "))) {
                    for (int j = 0; j < 4; j++) { //TODO: change magic number 4

                        if (words.get(word) == 1) {
                            if (ah[j][category].equals(word)) {
                                ah[j][category] = "10";
                            }
                        } else {
                            if (ah[j][category].equals(word)) {
                                ah[j][category] = "5";
                            }
                        }
                    }
                }else {
                    for (int i = 0; i < 4; i++) {   //TODO: change magic number 4
                        if (ah[i][category].equals(" ")){
                            ah[i][category] = "0";
                        }
                    }
                }
            }
        }




    public static void main(String[] args) {
        CompareAnswers comp = new CompareAnswers();
        comp.compare();

    }


}
