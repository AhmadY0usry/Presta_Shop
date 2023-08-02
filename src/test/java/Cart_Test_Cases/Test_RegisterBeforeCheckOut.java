package Cart_Test_Cases;

import Pages.*;
import Test_Base.Test_Base;
import Test_Data.Excel_Reader;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

public class Test_RegisterBeforeCheckOut extends Test_Base {
    Login_Page loginPage;
    SearchResults_Page searchResultsPage;
    Cart_Page cartPage;
    CheckOut_Page checkOutPage;
    Signup_Page signupPage;
    SoftAssert softAssert=new SoftAssert();
    @DataProvider(name = "Valid_Test_Data")
    public Object [][] TestData() throws IOException {
        Excel_Reader ER = new Excel_Reader();
        return  ER.getDataFromExcelFile("\\Test_Data.xlsx",0);
    }
    @Test(dataProvider ="Valid_Test_Data")
    public void Test_Register_Before_CheckOut(Object Email, Object FName, Object LName, Object pass, Object date) {

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
        homePage.clickOnAllProducts();
        String Product_Name = "Mug";
        searchResultsPage = homePage.searchFor(Product_Name);
        searchResultsPage.hoverOverProductAndClickAddQuickView(1);
        searchResultsPage.clickAddCartBtnOnClickView();
        searchResultsPage.clickContinueShopping();
        cartPage = homePage.clickOnCartBtn();
        checkOutPage=cartPage.clickProceedToCheckOut();
        checkOutPage.fillAddressAndConfirm("11511","Cairo","Code");
        checkOutPage.ConfirmDeliveryOption();
        checkOutPage.choosePaymentOption("2");
        checkOutPage.clickOnAgreeToTerms();
        checkOutPage.clickOnPlaceOrder();
        softAssert.assertEquals(checkOutPage.getOrderSuccessMsg(),"\uE876YOUR ORDER IS CONFIRMED","Order is not confirmed");
        softAssert.assertAll();

    }
}
