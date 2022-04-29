package model;

import java.util.Date;
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

    public String userInfo (String firstName, String lastName, String birthday, String address) {
        return firstName + " " + lastName + ", " + birthday + ", " + address;
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

}
