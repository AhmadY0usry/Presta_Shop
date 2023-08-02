package Cart_Test_Cases;

import Pages.Cart_Page;
import Pages.SearchResults_Page;
import Test_Base.Test_Base;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class Test_RemoveProductFromCart extends Test_Base {
    SearchResults_Page searchResultsPage;
    Cart_Page cartPage;

    @Test
    public void Remove_Products_From_Cart() {
        String Product_Name = "Mug";
        homePage.clickOnAllProducts();
        searchResultsPage = homePage.searchFor(Product_Name);
        searchResultsPage.hoverOverProductAndClickAddQuickView(1);
        searchResultsPage.clickAddCartBtnOnClickView();
        searchResultsPage.clickContinueShopping();
        cartPage = homePage.clickOnCartBtn();
        cartPage.clickOnRemoveBtn();
        assertEquals(cartPage.getNoItemsText(),"There are no more items in your cart","Remove button not working");

    }
}
