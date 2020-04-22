package encryptdecrypt;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;

public class Data {
    private String data="";
    private Optional<File> out ;

    public Data(){
        out =Optional.empty();
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setFile(String filename) throws IOException {
        String result =  Files.readString(Path.of("./" + filename));
        setData(result);
    }

    public void setOut(String fileName)  {
        out  = Optional.of(new File("./" +  fileName));
    }


    public String getData() {
        return data;
    }

    public void print(String code)   {
        if (out.isPresent()){
            File file = out.get();

          try(FileWriter writer = new FileWriter(file)){
              writer.write(code);
          }
          catch (IOException e){

              System.out.println(e.getMessage());
          }

        }
        else {
            System.out.println(code);
        }
    }
}
