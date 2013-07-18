package utils;

import java.util.Collection;
import java.util.Iterator;

public class StringUtils {

    public static String join(Collection<String> c, String d) {
        String[] strings = c.toArray(new String[c.size()]);
        return join(strings, d);
    }

    public static String join(String r[], String d) {
        if (r.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int i;
        for (i = 0; i < r.length - 1; i++) {
            sb.append(r[i]).append(d);
        }
        return sb.toString() + r[i];
    }
}
