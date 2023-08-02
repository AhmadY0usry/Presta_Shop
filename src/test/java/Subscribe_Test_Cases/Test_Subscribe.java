package Subscribe_Test_Cases;

import Test_Base.Test_Base;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Test_Subscribe extends Test_Base {
SoftAssert softAssert=new SoftAssert();
    @Test
    public void Test_Subscription()
    {
        homePage.enterEmailSubscribeField("ah@yahoo.com");
        homePage.clickOnSubscribeBtn();
        softAssert.assertEquals(homePage.getSubscribeMsg(),"You have successfully subscribed to this newsletter.");
    }
}
