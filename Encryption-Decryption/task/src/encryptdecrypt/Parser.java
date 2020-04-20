package encryptdecrypt;

        import java.util.HashMap;
        import java.util.Map;


public class Parser {
    private final String[] options;
    Map<String,String> map;

    public Parser(String ...  options){
        this.options=options;
        this.map=new HashMap<>();
    }

    public void parse(String[]   line){


        for(String option : options){
           String[] values = option.split(" ");
           String key = values[0];

           String defaultValue = values.length == 1 ? "" : values[1];

            int i = 0;

           while(i <line.length){

                String item = line[i];
                String value;
                if (item.startsWith("-") && item.endsWith(key)){
                    if (!line[i+1].startsWith("-")){

                        value = line[i+1];
                    }
                    else {
                        value = defaultValue;
                    }
                    map.put(key,value);
                    break;
                }
                i++;

            }

        }

    }

    public String getValue(String label){
        return map.getOrDefault(label , "option invalid");
    }

}
