package Search_Test_Cases;

import Pages.SearchResults_Page;
import Test_Base.Test_Base;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Test_Search extends Test_Base {
SearchResults_Page searchResultsPage;
SoftAssert softAssert = new SoftAssert();
    @Test
    public void Search_Products()
    {
     String Product_Name="Mug";
     homePage.clickOnAllProducts();
     searchResultsPage=homePage.searchFor(Product_Name);
     softAssert.assertEquals(searchResultsPage.isAllProductsRelatedToSearch(Product_Name),
                    "True","Not All Products related To Search");
     softAssert.assertAll();
    }
}
