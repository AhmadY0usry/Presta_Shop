package Cart_Test_Cases;

import Pages.Cart_Page;
import Pages.SearchResults_Page;
import Test_Base.Test_Base;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Test_AddToCart extends Test_Base {
    SearchResults_Page searchResultsPage;
    Cart_Page cartPage;
    SoftAssert softAssert = new SoftAssert();
    @Test
    public void Search_Products()
    {
        String Product_Name="Mug";
        homePage.clickOnAllProducts();
        searchResultsPage=homePage.searchFor(Product_Name);
        searchResultsPage.hoverOverProductAndClickAddQuickView(1);
        searchResultsPage.clickAddCartBtnOnClickView();
        searchResultsPage.clickContinueShopping();
        searchResultsPage.hoverOverProductAndClickAddQuickView(2);
        searchResultsPage.clickAddCartBtnOnClickView();
        searchResultsPage.clickContinueShopping();
        cartPage=homePage.clickOnCartBtn();
        softAssert.assertEquals(cartPage.getNumOfProducts(),2,"Actual number of products not as expected");
        softAssert.assertAll();
    }
}
