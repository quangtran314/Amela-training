package day5.regex.phoneNumber;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneNumber {
    private static final String ACCOUNT_REGEX = "^\\(\\d{2}\\)\\-\\(0\\d{9}\\)$";
    private static String[] validPhoneNumber = {"(84)-(0978489648)"};
    private static String[] inValidPhoneNumber = {"(a8)-(22222222)"};

    public static void main(String[] args){
        if(validate(validPhoneNumber[0])){
            System.out.println(validPhoneNumber[0] + " is valid name");
        } else {
            System.out.println(validPhoneNumber[0] + " is not valid name");
        }

        if(validate(inValidPhoneNumber[0])){
            System.out.println(inValidPhoneNumber[0] + " is valid name");
        } else {
            System.out.println(inValidPhoneNumber[0] + " is not valid name");
        }
    }

    public static boolean validate(String regex) {
		Pattern pattern = Pattern.compile(ACCOUNT_REGEX);
		Matcher  matcher = pattern.matcher(regex);
		return matcher.matches();
	}
}
