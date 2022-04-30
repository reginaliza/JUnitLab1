package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.HashMap;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SMS {

    final private static Logger logger = Logger.getLogger(SMS.class.getName());

    public String mobileNumber(String str) {
        if (str.length() == 12)
            return str.replaceAll("63", "0");

        String first2Chars = str.substring(0, 2);
        String stringMinusFirst2Chars = str.substring(2);

        return first2Chars.replaceAll("63", "0") + stringMinusFirst2Chars;
    }

    public String register(String str) {
        if (str.length() == 8) {
            logger.log(Level.INFO, "true");
            return str.toLowerCase(Locale.ROOT);
        } else
            logger.log(Level.INFO, "false");

        String origStatement = str.substring(0, 8);
        return origStatement.toLowerCase();
    }

    // ************************* for User Information ****************

    public String userInfo (String fullName, String birthday, String address) {
        return fullName + ", " + birthday + ", " + address;
    }

    public static boolean ValidDate(final String date) {
        boolean valid = false;
        try {
            LocalDate.parse(date,
                    DateTimeFormatter.ofPattern("uuuu-MM-dd")
                            .withResolverStyle(ResolverStyle.STRICT));
            valid = true;
        } catch (DateTimeParseException e) {
            e.printStackTrace();
            valid = false;
        } finally {
            return valid;
        }
    }

    public static boolean hasWhiteSpaces(final String text) {
        if (Character.isWhitespace(text.charAt(0)) || Character.isWhitespace(text.charAt(text.length() - 1))) {
            return true;
        }
        return false;
    }

    public static boolean hasValidMessageInput(final SMSModel message) {

        String text = message.getMessage();
        UserDetails user = inputSeparator(text);

        if (user == null) {
            return false;
        }

        if(hasWhiteSpaces(user.getFullName()) ||
                hasWhiteSpaces(user.getBirthday()) ||
                hasWhiteSpaces(user.getAddress())) {
            return false;
        }

        if(!ValidDate(user.getBirthday())) {
            return false;
        }

        if(stringArray(user.getFullName()).length <= 1) {
            return false;
        }

        if(stringArray(user.getAddress()).length <= 1 || !user.getAddress().toLowerCase().matches("(.*)city")){
            return false;
        }

        return true;
    }


    // *************** NOT WORKING ***
    public static String checkUserInfo(HashMap<String, String> smsMap, SMSModel sms) {
        String result = "Failed";

        if (smsMap.size() == 7) {
            String message = smsMap.get("Message");
            String firstName = smsMap.get("First Name");
            String lastName = smsMap.get("Last Name");
            String bdayYear = smsMap.get("Birthday: Year");
            String bdayMonth = smsMap.get("Birthday: Month");
            String bdayDay = smsMap.get("Birthday: Day");
            String address = smsMap.get("Address");

            if(message != null) {
                result = "Success";
                sms.setSuccess(true);
                return message.toLowerCase(Locale.ROOT);
            } else {
                sms.setSuccess(false);
                result = "NULL";
            }

            if(firstName != null) {

            }

        } else {
            result = "Invalid Hashmap";
        }

        return result;
    } // WITH ERRORS


    public static UserDetails inputSeparator(final String info) {
        String[] arrOfStr = info.split(",", 3);

        if (arrOfStr.length == 3) {
            return new UserDetails(arrOfStr[0], arrOfStr[1], arrOfStr[2]);
        } else {
            return null;
        }
    }

    public static String[] stringArray(final String text) {
        String[] arrOfStr = text.split("", 0);
        return arrOfStr;
    }

}
