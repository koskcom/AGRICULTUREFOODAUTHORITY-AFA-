package co.ke.bsl.util;

public class StringUtils {
	public static String limitStringLength(String orgString, int maxLen,
			String appendChars) {
		if (orgString == null)
			return "";
		if (orgString.length() <= maxLen)
			return orgString;
		if (appendChars == null)
			appendChars = "";

		String shortString = orgString.substring(0,
				maxLen - 1 - appendChars.length())
				+ appendChars;

		return shortString;
	}

	public static String join(String[] items, String joinChars,
			boolean appendEmptyItems) {
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < items.length; i++) {
			boolean append = true;
			if (isNullOrEmpty(items[i]) && !appendEmptyItems) {
				append = false;
			}

			if (append) {
				builder.append(items[i]);
				if (i < items.length - 1) {
					builder.append(joinChars);
				}
			}
		}
		return builder.toString();
	}

	public static boolean isNullOrEmpty(String string) {
		return string == null || string.equals("");
	}

	/**
	 * Converts the first character of the given string to lower case.
	 */
	public static String toFirstLowerCase(String original) {
		if (isNullOrEmpty(original)) {
			return original;
		} else if (original.length() == 1) {
			return original.toLowerCase();
		} else {
			return original.substring(0, 1).toLowerCase()
					+ original.substring(1);
		}
	}

	/**
	 * Converts the first character of the given string to upper case.
	 */
	public static String toFirstUpperCase(String original) {
		if (isNullOrEmpty(original)) {
			return original;
		} else if (original.length() == 1) {
			return original.toUpperCase();
		} else {
			return original.substring(0, 1).toUpperCase()
					+ original.substring(1);
		}
	}
}
