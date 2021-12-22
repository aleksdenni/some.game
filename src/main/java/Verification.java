import org.apache.commons.codec.digest.HmacUtils;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Collections;

import static org.apache.commons.codec.digest.HmacAlgorithms.HMAC_SHA_256;

public class Verification {

    private final SecureRandom key = new SecureRandom();
    private final String keyHmac = generateKey();

    public  SecureRandom getKey() {
        return key;
    }

    public String getHmac() {
        return keyHmac;
    }

    public boolean inputData(String[] args){
        boolean check = false;  // replace if with a new switch
        if(args.length%2!=0){
            if(args.length > 2){
                var argsList = Arrays.asList(args);
                for (String s : args){
                    if (!(Collections.frequency(argsList,s) < 2)){
                        System.out.println("Arguments must be non-repetitive");
                        check = false;
                        break;
                    } else check =true;
                }
            }else System.out.println("There must be more than two arguments");
        }else System.out.println("The number of arguments must be odd");
        return check;
    }

    public String generateKey() {
        byte[] values = new byte[32];
        try {
            SecureRandom.getInstanceStrong().nextBytes(values);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        StringBuilder sb = new StringBuilder();
        for (byte b : values) {
            sb.append(String.format("%02x", b));
        }
        return String.valueOf(sb);
    }

    public String HMAC(String keyHmac, String compMove){
        return new HmacUtils(HMAC_SHA_256, keyHmac).hmacHex(compMove);
    }
}