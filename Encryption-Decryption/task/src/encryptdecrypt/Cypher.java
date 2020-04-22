package encryptdecrypt;

import javax.swing.*;
import java.util.*;

public class Cypher {
    private Parser   parser;
    private  AlgorithmContext ctx;
    private Data dataManager;

    
    
    public Cypher(String ... options){

        parser = new Parser(options);
        ctx = new AlgorithmContext();//default algorithme
        dataManager = new Data();


    }

    public void setArgs(String[] args){
        parser.parse(args);
    }


    public void transform() {
        try {

            String code = parser.getValueOrDefault("mode", "enc");
            String text = parser.getValueOrDefault("data", "");
            int key = Integer.parseInt(parser.getValueOrDefault("key", "0"));

            String algorithme = parser.getValueOrDefault("alg","shift");

            ctx.select(algorithme);

            dataManager = new Data();

            if (parser.isPresent("data")) {
                dataManager.setData(parser.getValueOrDefault("data", ""));
            } else if (parser.isPresent("in")) {
                dataManager.setFile(parser.getValue("in"));
            }

            if (parser.isPresent("out")) {
                dataManager.setOut(parser.getValue("out"));
            }

            switch(code){
                case "enc":
                    dataManager.print(ctx.getAlgoritm().code(key,dataManager.getData()));
                    break;
                case"dec":
                    dataManager.print(ctx.getAlgoritm().decode(key,dataManager.getData()));
                    break;
            }
        }
        catch (Exception e){
            e.printStackTrace();
            System.out.println("error file");
        }


    }
}
