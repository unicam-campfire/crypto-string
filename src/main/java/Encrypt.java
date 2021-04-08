import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.util.Random;

public class Encrypt {

    private String stringToEncrypt;
    private BigInteger key;
    private byte[]stringToByteArray;

    public Encrypt(String stringToEncrypt){
        if(stringToEncrypt == null)
            throw new NullPointerException("Stringa nulla");
        this.stringToEncrypt = stringToEncrypt;
        this.generateKey();
    }

    private void generateKey (){
        int keyLength = this.stringToEncrypt.length() * 16;
        Random ran = new Random();
        this.key = new BigInteger(keyLength,ran);
    }

    public BigInteger getKey (){
        return this.key;
    }

    private void stringToByte (){
        this.stringToByteArray = stringToEncrypt.getBytes(StandardCharsets.UTF_8);
    }

    public BigInteger encrypt (){
        this.stringToByte();
        StringBuilder builder = new StringBuilder();
        for (byte b : this.stringToByteArray) {
            builder.append(b);
        }
        BigInteger stringToInt = new BigInteger(builder.toString());
        return this.key.xor(stringToInt);
    }
}