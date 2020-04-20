package encryptdecrypt;

import java.util.Scanner;


public class Main {





    public static void main(String[] args) {

        Scanner reader = new Scanner(System.in);
        String code = reader.nextLine();
        String text = reader.nextLine();
        int key = reader.nextInt();

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

