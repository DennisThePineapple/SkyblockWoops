package Wooper.Util;

import java.util.UUID;
//https://stackoverflow.com/questions/18986712/creating-a-uuid-from-a-string-with-no-dashes
public class StringtoUUID {
    public static UUID convert(String string) {
        if (string.contains("-")) {
            return UUID.fromString(string);
        }
        return java.util.UUID.fromString(
                string
                        .replaceFirst(
                                "(\\p{XDigit}{8})(\\p{XDigit}{4})(\\p{XDigit}{4})(\\p{XDigit}{4})(\\p{XDigit}+)",
                                "$1-$2-$3-$4-$5"));

    }
    public static String UUIDconvert(UUID string){
        String uuid = string.toString();
        return uuid.substring(0, 8) + "-" + uuid.substring(8, 12) + "-" + uuid.substring(12, 16) + "-" + uuid.substring(16, 20) + "-" + uuid.substring(20, 32);
    }
}
