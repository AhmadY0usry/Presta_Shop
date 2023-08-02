package Pages;

import Page_Base.Page_Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Cart_Page extends Page_Base {
    WebDriver driver;
    public Cart_Page(WebDriver driver) {
        super(driver);
        this.driver=driver;
    }
    By NumOfProducts=By.cssSelector(".product-line-info .label");
    By ProceedToCheckOut=By.cssSelector(".text-sm-center .btn.btn-primary");
    By RemoveFromCart=By.className("remove-from-cart");
    By NoItemsText=By.className("no-items");

    public int getNumOfProducts() {
        List <WebElement> listOfProducts=driver.findElements(NumOfProducts);
        return listOfProducts.size();
    }
    public CheckOut_Page clickProceedToCheckOut()
    {
        click(ProceedToCheckOut);
        return new CheckOut_Page(driver);
    }
    public void clickOnRemoveBtn()
    {
        click(this.RemoveFromCart);
    }

    public String getNoItemsText()
    {
        return getText(this.NoItemsText);
    }

}
