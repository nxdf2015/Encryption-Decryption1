package encryptdecrypt;

        import java.util.*;


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
                    value = defaultValue;
                    if (i < line.length-1 && !line[i+1].startsWith("-")){
                        value = line[i+1];
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

    public String getValueOrDefault(String label, String defaultValue){
        if (isPresent(label)){
            return getValue(label);
        }
        else{
            return defaultValue;
        }
    }

    public boolean isPresent(String key){
        return map.containsKey(key);
    }

}
