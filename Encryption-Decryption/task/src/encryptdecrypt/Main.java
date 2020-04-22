package encryptdecrypt;


/**
 * java  Main -mode type  -key value -data text -in filein -out fileout -alg name
 * -mode
 *       type : enc  code message | dec decode message , default value enc
 * -key
 *      value : int  ,  default value 0
 * -data
 *       text : string , default value ""
 *- in
 *       filein : string   , default stdin
 * -out
 *       fileout : string , default stdout
 * -alg
 *    name :string;  default value shift  (  letter + shift % 26 )
 *    value unicode
 *
 * if  option in and data are in the command in is ignored
 *  command :  java Main -mode -in save.txt -data "wellcome to hyperskill"
 *    equivalent to:  java Main -mode -data "wellcome to hyperskill"
 *
 */


public class Main {

    public static void main(String[] args){
        Cypher cypher = new Cypher("mode enc","key 0","data ","in ","out","alg shift");
        cypher.setArgs(args);
        cypher.transform();
    }
}

