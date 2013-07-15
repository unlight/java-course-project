package utils;

import java.util.Collection;
import java.util.Iterator;

public class StringUtils {

    public static String join(Collection<String> c, String d) {
	  StringBuilder sb = new StringBuilder();
	  for (Iterator<String> it = c.iterator(); it.hasNext();) {
		String string = it.next();
		sb.append(string);
	  }
	  return sb.toString();
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
