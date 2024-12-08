import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import static org.testng.Assert.assertEquals;

public class TestNGExample {

    private int number;
    private final String USER_NAME = "Zoidberg";
    private final String USER_PASSWORD = "doctor";

    @BeforeClass
    public void setUpBeforeClass() {
        number = 5;
    }

    @AfterClass
    public void tearDownAfterClass() {
        number = 0;
    }

    @Test(groups = "regress")
    public void simple_calculation_test() {
        assertEquals(2+3, 5, "Wrong result");
    }

    @Test()
    public void simple_calculation_test2() {
        assertEquals(number + 8, 13, "Wrong result");
    }

    @Test(enabled = false)
    @Parameters({"name", "password"})
    public void simple_parameter_test(String name, String password) {
        assertEquals(name, USER_NAME, "Wrong name");
        assertEquals(password, USER_PASSWORD, "Wrong password");
    }

    @Test(dataProvider = "credits")
    public void data_provider_test(String name, String password) {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(name, USER_NAME, "Wrong name");
        softAssert.assertEquals(password, USER_PASSWORD, "Wrong password");
        softAssert.assertAll();
    }

    @DataProvider(name = "credits")
    public static Object[][] cresits() {
        return new Object[][] {
                {"Zoidberg", "doctor"},
                {"Zoidberg", "capo"},
                {"lAte", "little"},
        };
    }

}
