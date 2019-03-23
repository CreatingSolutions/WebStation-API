package webstationapi.Utils;

public class Utils {

    public static String getToken(String auth) {
        String[] s = auth.split(" ");
        return s[1];
    }
}
