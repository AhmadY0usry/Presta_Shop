package ContactUs_Test_Case;

import Pages.ContactUs_Page;
import Test_Base.Test_Base;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Test_ContactUs extends Test_Base {
    ContactUs_Page contactUsPage;
    SoftAssert softAssert=new SoftAssert();
    @Test
    public void Test_Contact_Us()
    {
        contactUsPage=homePage.clickOnContactUs();
        contactUsPage.selectSubject();
        softAssert.assertEquals(contactUsPage.getContactUsText(),"CONTACT US");
        contactUsPage.setEmailAddress("A@yahoo.com");
        contactUsPage.ContactForm_message("Your products are awesome");
        contactUsPage.clickOnSendBtn();
        softAssert.assertEquals(contactUsPage.getSuccessMsg(),"Your message has been successfully sent to our team.");
    }
}
