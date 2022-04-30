package test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({testRegister.class, testUserInfo.class})


public class AllTests {

    //Tests all functions inside classes indicated on @Suite.SuiteClasses

}
