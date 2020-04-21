package encryptdecrypt;


import java.io.IOException;



public class Main {





    public static void main(String[] args){
        Cypher cypher = new Cypher("mode enc","key 0","data ","in ","out");
        cypher.setArgs(args);
        //cypher.setAlgorithme(new Shift()); change algorithme
        cypher.transform();


    }
}

