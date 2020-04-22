package encryptdecrypt;

public class Shift extends Algoritm {
    private final String alphabet = "abcdefghijklmnopqrstuvwxyz";

    @Override
    public char shift(int key, char letter) {

        boolean isUpper=false;
        if(isUpper= Character.isUpperCase(letter)){
            letter=Character.toLowerCase(letter);
        }
           int id;
        if((id = alphabet.indexOf(letter))==-1){
            return letter;
        }
           int size = alphabet.length();
          char c = alphabet.charAt(( size + id +key ) % size  );
          return isUpper ? Character.toUpperCase(c):c;

    }
}
