package encryptdecrypt;

import java.util.Optional;

public class Cypher {
    private Parser   parser;
    private  Algoritm algorithm;
    private Data dataManager;
    
    
    
    public Cypher(String ... options){
        parser = new Parser(options);
        algorithm = new Unicode();//default algorithme
        dataManager = new Data();
    }


    public void setAlgorithme(Algoritm algorithm){
        this.algorithm= algorithm;
    }


    public void setArgs(String[] args){
        parser.parse(args);
    }


    public void transform() {
        try {
            String code = parser.getValueOrDefault("mode", "enc");
            String text = parser.getValueOrDefault("data", "");
            int key = Integer.parseInt(parser.getValueOrDefault("key", "0"));



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
                    dataManager.print(algorithm.code(key,dataManager.getData()));
                    break;
                case"dec":
                    dataManager.print(algorithm.decode(key,dataManager.getData()));
                    break;
            }
        }
        catch (Exception e){
            System.out.println("error file");
        }


    }
}
