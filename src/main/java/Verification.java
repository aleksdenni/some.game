import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;

public class Verification {

    private final SecureRandom key = new SecureRandom();

    public  int getKey(int number) {
        return key.nextInt(number)+1;
    }

    public boolean inputData(String[] args){
        if(args.length%2!=0){
            if(args.length > 2){
                var argsList = new ArrayList<String>();
                for (String s : args){
                    argsList.add(s.trim());
                    if (Collections.frequency(argsList,s) < 2){
                        return true;
                    }else System.out.println("Аргументы не должны повторятся");
                }
            }else System.out.println("Аргументов не может быть меньше чем 3");
        }else System.out.println("Количество аргументов должно быть нечётным");
        return false;
    }

    public boolean check(String str){
        return false;
    }

    /*public static String keyHMAC(){
        return Arrays.toString(new HmacUtils().hmac(String.valueOf(key)));
    }*/

    /*public static String computeHMAC(String secret, String... parts) {
        var text = Arrays.stream(parts).map(StringUtils::trimToEmpty).collect(Collectors.joining(""));
        return new HmacUtils(HmacAlgorithms.HMAC_SHA_256, secret).hmacHex(text);
    }*/

}


    /*public static  String generateHashString(String str){
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        md.update(str.getBytes());
        byte[] mdbytes = md.digest();
        StringBuilder hexString = new StringBuilder();
        for (byte mdbyte : mdbytes) {
            hexString.append(String.format("%02x", 0xFF & mdbyte));
        }
        return hexString.toString();
    }*/

    /*public static String computeHMAC(String secret, String... parts) {
        var text = Arrays.stream(parts).map(StringUtils::trimToEmpty).collect(Collectors.joining(""));
        return new HmacUtils(HmacAlgorithms.HMAC_SHA_256, secret).hmacHex(text);
    }*/