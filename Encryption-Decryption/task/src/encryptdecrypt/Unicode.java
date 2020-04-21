package encryptdecrypt;

import java.io.File;
import java.util.Optional;

public class Unicode extends  Algoritm{


    @Override
    public  char  shift(int d,char letter){
        return   (char) ((int) letter + d);

    }

}
