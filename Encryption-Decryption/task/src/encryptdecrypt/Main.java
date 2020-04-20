package encryptdecrypt;

import java.util.Map;
import java.util.Scanner;


public class Main {





    public static void main(String[] args) {
        Parser parser = new Parser("mode enc","key 0","data ");

        parser.parse(args );

        String code = parser.getValue("mode");
        String text = parser.getValue("data");
        int key = Integer.parseInt(parser.getValue("key"));

        String result = "";
        switch(code){
            case "enc":
                result=Encrypt.encrypt(key,text);
                break;
            case"dec":
                result=Encrypt.decrypt(key,text);
                break;
        }

        System.out.println(result);

    }
}

