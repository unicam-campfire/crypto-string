import java.math.BigInteger;

public class Decrypt {

    private BigInteger integerToDecrypt;
    private BigInteger decryptedInteger;
    private BigInteger key;

    public Decrypt(BigInteger integerToDecrypt, BigInteger key){
        this.integerToDecrypt = integerToDecrypt;
        this.key = key;
    }

    private byte[] integerToByte (){
        return this.decryptedInteger.toByteArray();
    }

    public BigInteger decrypt (){
        this.decryptedInteger = integerToDecrypt.xor(key);
        byte[] decryptedStringToByte = this.integerToByte();
        return null;
    }
}