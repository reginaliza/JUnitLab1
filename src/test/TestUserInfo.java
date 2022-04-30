package test;

import model.SMSModel;
import model.SMS;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestUserInfo {


    // ******************* SUCCESS TEST CASES ****

    @Test
    public void user1() {
        SMSModel sms = new SMSModel();

        sms.setMessage("Regina Diloy, 1998-04-21, Bacoor City");

        assertTrue(SMS.hasValidMessageInput(sms));
    }

    @Test
    public void user2() {
        SMSModel sms = new SMSModel();

        sms.setMessage("CJ Corona, 1997-11-12, Makati City");

        assertTrue(SMS.hasValidMessageInput(sms));
    }

    @Test
    public void user3() {
        SMSModel sms = new SMSModel();

        sms.setMessage("Marco Valmores, 1973-09-10, Marikina City");

        assertTrue(SMS.hasValidMessageInput(sms));
    }

    // ******************* FAILED TEST CASES ****

    @Test
    public void user4() {
        SMSModel sms = new SMSModel();

        sms.setMessage("Regina Diloy, XXXX-XX-XX, Bacoor City");

        assertTrue(SMS.hasValidMessageInput(sms));
    }

    @Test
    public void user5() {
        SMSModel sms = new SMSModel();

        sms.setMessage("CJ Corona, 1997-11-12");

        assertTrue(SMS.hasValidMessageInput(sms));
    }

    @Test
    public void user6() {
        SMSModel sms = new SMSModel();

        sms.setMessage("Regina Diloy, 04-21-1998, Bacoor City");

        assertTrue(SMS.hasValidMessageInput(sms));
    }

}
