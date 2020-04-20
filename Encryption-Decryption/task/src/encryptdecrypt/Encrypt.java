package encryptdecrypt;

public class Encrypt {
    final static String  alphabet = "abcdefghijklmnopqrstuvwxyz";

    public static char  shift(int d,char letter){

//
        return   (char) ((int) letter + d);

    }



    public static String code(int d,String text) {
        StringBuilder encrypt = new StringBuilder();
        for(char letter:text.toCharArray() ){

            encrypt.append(shift(d ,letter));
        }
      return encrypt.toString();
    }

    public static String encrypt(int d,String text){
        return code(d,text);
    }

    public static String decrypt(int d,String text){
        return code(-d,text);
    }
}
