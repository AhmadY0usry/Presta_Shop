package Signup_Test_Cases;

import Pages.Login_Page;
import Pages.Signup_Page;
import Test_Base.Test_Base;
import Test_Data.Excel_Reader;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

public class Register_Using_Invalid_Data extends Test_Base {

    Login_Page loginPage;
    Signup_Page signupPage;


    @DataProvider(name = "Invalid_Test_Data")
    public Object [][] InvalidUserRegisterData() throws IOException {
        Excel_Reader ER = new Excel_Reader();
        return  ER.getDataFromExcelFile("\\Test_Data.xlsx",1);
    }
    SoftAssert softAssert = new SoftAssert();

    @Test(dataProvider = "Invalid_Test_Data")
    public void Test_SignInWith_Invalid_Credentials(Object Email, Object FName, Object LName, Object pass, Object date) {
        loginPage = homePage.clickOnSignUpBtn();
        signupPage = loginPage.clickOnCreateAccountBtn();
        signupPage.selectMaleFromTitle();
        signupPage.selectNewsLetterChkBox();
        signupPage.selectTermsChkBox();
        signupPage.selectPartnerChkBox();
        signupPage.selectCustomerPrivacyChkBox();
        signupPage.FillDetails(FName.toString(),LName.toString(),Email.toString(),pass.toString(),date.toString());
        signupPage.clickOnSaveBtn();
        String FirstNameError=signupPage.getErrorText(0);
        softAssert.assertEquals(FirstNameError,"Invalid format.");

        String LastNameError=signupPage.getErrorText(1);
        softAssert.assertEquals(LastNameError,"Invalid format.");

        String EmailError=signupPage.getErrorText(2);
        softAssert.assertEquals(EmailError,"Invalid format.");

        String PassError=signupPage.getErrorText(3);
        softAssert.assertEquals(PassError,"Password must be between 8 and 72 characters long");

        softAssert.assertAll();
    }


}
