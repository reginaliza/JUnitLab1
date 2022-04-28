package model;

import java.util.HashMap;
import java.util.Locale;
import java.util.logging.Level;

public class SMS {

    public String mobileNumber(String str) {
        if (str.length() == 12)
            return str.replaceAll("63", "0");

        String first2Chars = str.substring(0, 2);
        String stringMinusFirst2Chars = str.substring(2);

        return first2Chars.replaceAll("63", "0") + stringMinusFirst2Chars;
    }

    public String register(String str) {
        if (str.length() == 8) {
            System.out.println("true");
            return str.toLowerCase(Locale.ROOT);
            //logger.log(Level.INFO, "true");
        } else
            //logger.log(Level.INFO, "false");
            System.out.println("false");

        String origStatement = str.substring(0, 8);
        return origStatement.toLowerCase();
    }

    // ************************* for User Information, Not Working Yet :( ****************

    public static String checkUserInfo(HashMap<String, String> smsMap, SMSModel sms) {
        String result = "Failed";

        if (smsMap.size() == 6) {
            String firstName = smsMap.get("First Name");
            String lastName = smsMap.get("Last Name");
            String bdayYear = smsMap.get("Birthday: Year");
            String bdayMonth = smsMap.get("Birthday: Month");
            String bdayDay = smsMap.get("Birthday: Day");
            String address = smsMap.get("Address");


        } else {
            result = "Invalid Hashmap";
        }

        return result;
    }
}
