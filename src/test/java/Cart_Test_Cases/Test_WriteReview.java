package Cart_Test_Cases;

import Pages.*;
import Test_Base.Test_Base;
import Test_Data.Excel_Reader;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.testng.Assert.*;

public class Test_WriteReview extends Test_Base {
    SearchResults_Page searchResultsPage;
    Login_Page loginPage;
    Signup_Page signupPage;
    Product_Page productPage;
    Cart_Page cartPage;
    @DataProvider(name = "Test_Data")
    public Object [][] ValidUserRegisterData() throws IOException {
        Excel_Reader ER = new Excel_Reader();
        return  ER.getDataFromExcelFile("\\Test_Data.xlsx",0);
    }
    @Test(dataProvider = "Test_Data")
    public void Write_Review_On_Products(Object Email, Object FName, Object LName, Object pass, Object date)
    {
        String Product_Name="Mug";
        homePage.clickOnAllProducts();
        searchResultsPage=homePage.searchFor(Product_Name);
        productPage=searchResultsPage.clickOnProduct(2);
        assertThrows(IndexOutOfBoundsException.class,() -> productPage.clickOnWriteReview());

        loginPage = homePage.clickOnSignUpBtn();
        signupPage = loginPage.clickOnCreateAccountBtn();
        signupPage.selectMaleFromTitle();
        signupPage.selectNewsLetterChkBox();
        signupPage.selectTermsChkBox();
        signupPage.selectPartnerChkBox();
        signupPage.selectCustomerPrivacyChkBox();
        signupPage.FillDetails(FName.toString(), LName.toString(), Email.toString(), pass.toString(), date.toString());
        signupPage.clickOnSaveBtn();
        assertEquals(homePage.getAccountName(),FName +" "+ LName);

        homePage.clickOnAllProducts();
        searchResultsPage=homePage.searchFor(Product_Name);
        searchResultsPage.clickOnProduct(2);
        productPage.clickOnWriteReview();
        productPage.enterTitleContentAndClickSend("Product","This products is awesome");
        assertEquals(productPage.getReviewSent(),"check_circle");
    }
}