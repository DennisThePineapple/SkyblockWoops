package Wooper.Util;

import java.util.UUID;
//https://stackoverflow.com/questions/18986712/creating-a-uuid-from-a-string-with-no-dashes
public class StringtoUUID {
    public static UUID convert(String string) {
        return java.util.UUID.fromString(
                string
                        .replaceFirst(
                                "(\\p{XDigit}{8})(\\p{XDigit}{4})(\\p{XDigit}{4})(\\p{XDigit}{4})(\\p{XDigit}+)",
                                "$1-$2-$3-$4-$5"));

    }
}
