package test;

import model.SMSModel;
import model.SMS;
import org.junit.Test;
import java.util.HashMap;
import static org.junit.Assert.*;

public class TestUserInfo {

    // *************** NOT WORKING ***
    @Test
    public void testUser1(){
        HashMap<String, String> entry = new HashMap<>();
        SMSModel sms = new SMSModel();
        entry.put("Message", "register");
        entry.put("First Name", "Regina");
        entry.put("Last Name", "Diloy");
        entry.put("Birthday: Year", "1998");
        entry.put("Birthday: Month", "04");
        entry.put("Birthday: Day", "21");
        entry.put("Address", "Bacoor City");

        assertNotNull("Verify that HashMap is not NULL", sms);
        assertEquals(SMS.checkUserInfo(entry, sms), "Success");
    } // WITH ERROR


    // ******************* WORKING TEST CASES ****
    @Test
    public void user1() {
        SMS sms = new SMS();

        String firstName = "Regina";
        String lastName = "Diloy";
        String birthday = "1998-04-21";
        String address = "Bacoor City";

        assertEquals("Regina Diloy, 1998-04-21, Bacoor City", sms.userInfo(firstName, lastName, birthday, address));
    }

    @Test
    public void user2() {
        SMS sms = new SMS();

        String firstName = "Regina";
        String lastName = "Diloy";
        String birthday = "XXX";
        String address = "Bacoor City";

        assertEquals("Regina Diloy, 1998-04-21, Bacoor City", sms.userInfo(firstName, lastName, birthday, address));
    }

    @Test
    public void user3() {
        SMS sms = new SMS();

        String firstName = "Regina";
        String lastName = "Diloy";
        String birthday = "04-21-1998";
        String address = "Bacoor City";

        assertEquals("Regina Diloy, 1998-04-21, Bacoor City", sms.userInfo(firstName, lastName, birthday, address));
    }
}
