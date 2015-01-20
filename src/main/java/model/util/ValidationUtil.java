package model.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Utility class for special validations
 *
 */
public class ValidationUtil {

	/**
	 * Validates a Sri Lankan NIC
	 * @param id String to be validated
	 * @return True if valid and false otherwise
	 */
	public static boolean validateID(String id){
		String pattern="(\\d\\d\\d\\d\\d\\d\\d\\d\\d)([VvXx])";
		Pattern r = Pattern.compile(pattern);
		Matcher m = r.matcher(id);
		if(id.length()!=10){
			return false;
		}else if (!m.matches()){
			return false;
		} else{
			return true;
		}
	}
	
	/**
	 * Checks if numeric
	 * @param str String to be validated
	 * @return True if valid and false otherwise
	 */
	public static boolean isNumeric(String str) {
		try {
			double d = Double.parseDouble(str);
		} catch (NumberFormatException nfe) {
			return false;
		}
		return true;
	}
}
