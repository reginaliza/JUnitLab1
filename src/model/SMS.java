package model;

import java.util.Locale;

public class SMS {

    public String mobileNumber(String str) {
        if (str.length() == 12)
            return str.replaceAll("63", "0");

        String first2Chars = str.substring(0,2);
        String stringMinusFirst2Chars = str.substring(2);

        return first2Chars.replaceAll("63", "0") + stringMinusFirst2Chars;
    }

    public String register(String str) {
        if (str.length() == 8)
            return str.toLowerCase(Locale.ROOT);

        String origStatement = str.substring(0, 8);
        return origStatement.toLowerCase();
    }
}
