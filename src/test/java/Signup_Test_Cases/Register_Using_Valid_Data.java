package Signup_Test_Cases;

import Test_Base.Test_Base;
import Pages.Login_Page;
import Pages.Signup_Page;
import Test_Data.Excel_Reader;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;


public class Register_Using_Valid_Data extends Test_Base {
    Login_Page loginPage;
    Signup_Page signupPage;
    SoftAssert softAssert = new SoftAssert();

    @DataProvider(name = "Valid_Test_Data")
    public Object [][] ValidUserRegisterData() throws IOException {
        Excel_Reader ER = new Excel_Reader();
        return  ER.getDataFromExcelFile("\\Test_Data.xlsx",0);
    }
    @Test(dataProvider ="Valid_Test_Data")
    public void Test_SignIn_Valid_Credentials(Object Email, Object FName, Object LName, Object pass, Object date) {

        loginPage = homePage.clickOnSignUpBtn();
        signupPage = loginPage.clickOnCreateAccountBtn();
        signupPage.selectMaleFromTitle();
        signupPage.selectNewsLetterChkBox();
        signupPage.selectTermsChkBox();
        signupPage.selectPartnerChkBox();
        signupPage.selectCustomerPrivacyChkBox();
        signupPage.FillDetails(FName.toString(), LName.toString(), Email.toString(), pass.toString(), date.toString());
        signupPage.clickOnSaveBtn();
        softAssert.assertEquals(homePage.getAccountName(),FName +" "+ LName);
        softAssert.assertAll();
    }
}