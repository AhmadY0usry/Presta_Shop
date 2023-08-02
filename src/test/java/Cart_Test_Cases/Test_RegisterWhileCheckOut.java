package Cart_Test_Cases;

import Pages.Cart_Page;
import Pages.CheckOut_Page;
import Pages.SearchResults_Page;
import Test_Base.Test_Base;
import Test_Data.Excel_Reader;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

public class Test_RegisterWhileCheckOut extends Test_Base {
    SearchResults_Page searchResultsPage;
    Cart_Page cartPage;
    CheckOut_Page checkOutPage;
    SoftAssert softAssert=new SoftAssert();

    @DataProvider(name = "Test_Data")
    public Object [][] ValidUserRegisterData() throws IOException {
        Excel_Reader ER = new Excel_Reader();
        return  ER.getDataFromExcelFile("\\Test_Data.xlsx",0);}
    @Test(dataProvider = "Test_Data")
    public void Register_While_CheckOut(Object Email, Object FName, Object LName, Object pass, Object date) {
        String Product_Name = "Mug";
        homePage.clickOnAllProducts();
        searchResultsPage = homePage.searchFor(Product_Name);
        searchResultsPage.hoverOverProductAndClickAddQuickView(1);
        searchResultsPage.clickAddCartBtnOnClickView();
        searchResultsPage.clickContinueShopping();
        cartPage = homePage.clickOnCartBtn();
        checkOutPage =cartPage.clickProceedToCheckOut();
        checkOutPage.fillPersonalInformation(FName.toString(), LName.toString(), Email.toString(), pass.toString(), date.toString());
        checkOutPage.clickOnContinue();
        checkOutPage.fillAddressAndConfirm("11511","Cairo","Code");
        checkOutPage.ConfirmDeliveryOption();
        checkOutPage.choosePaymentOption("2");
        checkOutPage.clickOnAgreeToTerms();
        checkOutPage.clickOnPlaceOrder();
        softAssert.assertEquals(checkOutPage.getOrderSuccessMsg(),"\uE876YOUR ORDER IS CONFIRMED","Order is not confirmed");
        softAssert.assertAll();

    }
}
