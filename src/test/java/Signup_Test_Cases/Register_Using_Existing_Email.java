package Signup_Test_Cases;

import Pages.Login_Page;
import Pages.Signup_Page;
import Test_Base.Test_Base;
import Test_Data.Excel_Reader;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

public class Register_Using_Existing_Email extends Test_Base {
    Login_Page loginPage;
    Signup_Page signupPage;
    SoftAssert softAssert = new SoftAssert();


    @DataProvider(name = "Test_Data")
    public Object[][] ValidUserRegisterData() throws IOException {
        Excel_Reader ER = new Excel_Reader();
        return ER.getDataFromExcelFile("\\Test_Data.xlsx", 0);
    }

    @Test(dataProvider = "Test_Data")
    public void Test_SignIn_Existing_Email(Object Email, Object FName, Object LName, Object pass, Object date) {

        loginPage = homePage.clickOnSignUpBtn();
        signupPage = loginPage.clickOnCreateAccountBtn();
        signupPage.selectMaleFromTitle();
        signupPage.selectNewsLetterChkBox();
        signupPage.selectTermsChkBox();
        signupPage.selectPartnerChkBox();
        signupPage.selectCustomerPrivacyChkBox();
        signupPage.FillDetails(FName.toString(), LName.toString(), Email.toString(), pass.toString(), date.toString());
        signupPage.clickOnSaveBtn();
        homePage.clickOnSignOutBtn();
        homePage.clickOnSignUpBtn();
        loginPage.clickOnCreateAccountBtn();
        signupPage.selectMaleFromTitle();
        signupPage.selectNewsLetterChkBox();
        signupPage.selectTermsChkBox();
        signupPage.selectPartnerChkBox();
        signupPage.selectCustomerPrivacyChkBox();
        signupPage.FillDetails(FName.toString(), LName.toString(), Email.toString(), pass.toString(), date.toString());
        signupPage.clickOnSaveBtn();
        softAssert.assertEquals(signupPage.getErrorText(0), "The email is already used, please choose another one or sign in");
        softAssert.assertAll();

    }
}