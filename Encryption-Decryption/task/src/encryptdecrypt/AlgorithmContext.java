package encryptdecrypt;

public class AlgorithmContext {
    private Algoritm algoritm;
    public void select(String type){
         switch (type){
             case "shift":
                 algoritm = new Shift();
                 break;
             case "unicode":
                 algoritm=new Unicode();
                 break;
             default:
                 System.out.println("unknown algorithm");
         }
    }

    public Algoritm getAlgoritm() {
        return algoritm;
    }


    public void set(Algoritm algorithm) {
        this.algoritm=algorithm;
    }
}
