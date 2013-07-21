package utils;

/**
 *
 * @author S
 */
public class FileUtils {

	public static final String getExtension(Object f) {
		if (f == null) {
			return null;
		}
		String filename = f.toString();
		final String afterLastSlash = filename.substring(filename.lastIndexOf('/') + 1);
		final int afterLastBackslash = afterLastSlash.lastIndexOf('\\') + 1;
		final int dotIndex = afterLastSlash.indexOf('.', afterLastBackslash);
		return (dotIndex == -1) ? "" : afterLastSlash.substring(dotIndex + 1);
	}
}
