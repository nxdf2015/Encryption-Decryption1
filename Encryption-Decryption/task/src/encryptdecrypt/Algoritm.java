package encryptdecrypt;

public abstract class Algoritm {
    public abstract char shift(int key,char text);

    public  String code(int d,String text){
        return transform(d,text);
    }

    public String decode(int d,String text){
        return transform(-d,text);
    }

    public  String transform(int d,String text) {
        StringBuilder encrypt = new StringBuilder();
        for(char letter:text.toCharArray() ){

            encrypt.append(shift(d ,letter));
        }
        return encrypt.toString();
    }

}
