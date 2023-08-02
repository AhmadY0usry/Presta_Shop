package Login_Test_Cases;

import Pages.Login_Page;
import Test_Base.Test_Base;
import Test_Data.Excel_Reader;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

public class Test_Invalid_Login extends Test_Base {
    Login_Page loginPage;
    SoftAssert softAssert=new SoftAssert();

    @DataProvider(name = "Valid_Register_Test_Data")
    public Object [][] ValidUserRegisterData() throws IOException {
        Excel_Reader ER = new Excel_Reader();
        return  ER.getDataFromExcelFile("\\Test_Data.xlsx",0);
    }


    @Test(dataProvider = "Valid_Register_Test_Data")
    public void Login_With_Invalid_Data (Object Email, Object FName, Object LName, Object pass,Object date)
    {
        loginPage=homePage.clickOnSignUpBtn();
        loginPage.Enter_email_and_password(Email.toString(),pass.toString());
        loginPage.clickOnSignInBtn();
        softAssert.assertNotEquals(homePage.getAccountName(),FName +" "+ LName);
        softAssert.assertEquals(loginPage.getAuthenticationErrorMsg(),"Authentication failed.");
        softAssert.assertAll();
    }

}