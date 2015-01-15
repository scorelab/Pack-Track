package model.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidationUtil {

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
	
	public static boolean isNumeric(String str) {
		try {
			double d = Double.parseDouble(str);
		} catch (NumberFormatException nfe) {
			return false;
		}
		return true;
	}
}
