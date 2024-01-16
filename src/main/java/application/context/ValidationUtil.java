package application.context;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidationUtil {

    public static boolean emailValidation(String email) {
        String regex = "^(.+)@(.+)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public static boolean websiteValidation(String website) {
        String regex = "(https:\\/\\/www\\.|http:\\/\\/www\\.|https:\\/\\/|http:\\/\\/)" +
                "?[a-zA-Z0-9]{2,}" +
                "(\\.[a-zA-Z0-9]{2,})" +
                "(\\.[a-zA-Z0-9]{2,})?\n";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(website);
        return matcher.matches();
    }

    public static boolean passwordValidator(String password) {
        String regex;
        regex = ("^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$ %^&*-]).{8,}$");
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }

    public static boolean phoneNumberValidator(String phoneNumber) {
        String regex = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$ %^&*-]).{8,}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(phoneNumber);
        return matcher.matches();
    }

    public static boolean NationalCodeValidator(String nationalCode) {
        if (nationalCode.length() != 10) {
            return false;
        } else {
            //Check for equal numbers
            String[] allDigitEqual = {"0000000000", "1111111111", "2222222222", "3333333333",
                    "4444444444", "5555555555", "6666666666", "7777777777", "8888888888", "9999999999"};
            if (Arrays.asList(allDigitEqual).contains(nationalCode)) {
                return false;
            } else {
                int sum = 0;
                int lenght = 10;
                for (int i = 0; i < lenght - 1; i++) {
                    sum += Integer.parseInt(String.valueOf(nationalCode.charAt(i))) * (lenght - i);
                }

                int r = Integer.parseInt(String.valueOf(nationalCode.charAt(9)));

                int c = sum % 11;

                return (((c < 2) && (r == c)) || ((c >= 2) && ((11 - c) == r)));
            }

        }
    }
}


