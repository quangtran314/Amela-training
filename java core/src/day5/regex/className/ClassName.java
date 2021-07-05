package day5.regex.className;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ClassName {
    private static final String ACCOUNT_REGEX = "^[CAP]\\d{4}[GHIKLM]$";

    public static void main(String[] args){
        if(validate("C0318G")){
            System.out.println("C0318G is valid name");
        } else {
            System.out.println("C0318G is not valid name");
        }

        if(validate("M0318G")){
            System.out.println("M0318G is valid name");
        } else {
            System.out.println("M0318G is not valid name");
        }
    }

    public static boolean validate(String regex) {
		Pattern pattern = Pattern.compile(ACCOUNT_REGEX);
		Matcher  matcher = pattern.matcher(regex);
		return matcher.matches();
	}
}
