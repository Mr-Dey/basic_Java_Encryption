//this is encryption version 2.This encryption Use ASCII value to encrypt.
import java.util.Scanner;
import java.util.Random;
public class EncrypTion2 {

    //This is the Encryption method.
    public int[] Encrypt(String word){
        Random random=new Random();
        //new random intiger Array
        int[] randIntarr= new int[word.length()];

        //generating random Intiger bound(15)
        for(int i=0;i<word.length();i++){
            randIntarr[i]=random.nextInt(15);
        }

        //Converting user word into Charector array
        char[] wordArr=new char[word.length()];
        wordArr=word.toCharArray();

        //This array will store Ascii value of user word along side with radomInt array.
        int[] asciiarr=new int[word.length()*2];
      
        //Adding ascii value of word and random int in same array and return it as key.
        for(int z=0,i=0;i<asciiarr.length;i++){
            if(i<word.length()){
                asciiarr[i]=(int) wordArr[i]+randIntarr[i];
            }
            else{
                asciiarr[i]=randIntarr[z];
                z++;
            }
        }
        return asciiarr;
    }

    //This is the Decryption method.
    public String Decrypt(int[] key){
        int wordlen=key.length/2;
        for(int i=0;i<key.length/2;i++){
            key[i]=key[i]-key[wordlen];
            wordlen++;
        }
        char[]value=new char[key.length/2];
        for(int i=0;i<key.length/2;i++){
            value[i]=(char)key[i];
        }
        String res=String.valueOf(value);
        return res;
    }
    public static void main(String[] args){
      Scanner input=new Scanner(System.in);
      EncrypTion2 encry=new EncrypTion2();
      System.out.println("Enter a String!");
      String userInp=input.nextLine();
      input.close();
      int[] res=encry.Encrypt(userInp);
      System.out.println("Encrypted array");
      for(int x:res)System.out.print(x+" ");
      System.out.println("\n\n\n");
      String res1=encry.Decrypt(res);
      System.out.println("The decryted result is\n->"+res1);
    }
}
