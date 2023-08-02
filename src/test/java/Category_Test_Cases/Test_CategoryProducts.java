package Category_Test_Cases;

import Pages.CategoryResult_Page;
import Test_Base.Test_Base;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static org.testng.Assert.assertEquals;

public class Test_CategoryProducts extends Test_Base {
    CategoryResult_Page categoryResultPage;
    SoftAssert softAssert= new SoftAssert();
    @Test
    public void View_Category_Products()
    {
        categoryResultPage=homePage.navigateToClothesAndSelect("Men");
        softAssert.assertEquals(categoryResultPage.getListHeader(),"MEN","Category Navigate with error");
        categoryResultPage=homePage.navigateToClothesAndSelect("Women");
        softAssert.assertEquals(categoryResultPage.getListHeader(),"WOMEN","Category Navigate with error");
        softAssert.assertAll();
    }
}
