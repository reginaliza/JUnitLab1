package sms;

import sms.model.SMS;

import java.util.HashMap;

public class SMSChecker {

    public static boolean check(HashMap<String, String> smsMap, SMS sms) {
        boolean result = false;

        if (smsMap.size() == 2) {
            String msisdn = smsMap.get("Mobile number");
            String register = smsMap.get("Message");

            if (register.equals("Register") || register.equals("REGISTER") || register.equals("register")) {
                result = true;
                sms.setSuccess(true);
            } else {
                sms.setSuccess(false);
            }
        }
        return result;
    }
}
