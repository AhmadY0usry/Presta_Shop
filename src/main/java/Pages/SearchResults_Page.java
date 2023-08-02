package Pages;

import Page_Base.Page_Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class SearchResults_Page extends Page_Base {
    WebDriver driver;

    public SearchResults_Page(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
    By productDescription = By.xpath("//h2");
    By addTOCartBtn=By.cssSelector(".add-to-cart");
    By QuickView=By.cssSelector(".js-quick-view");
    By ContinueShopping=By.cssSelector("#blockcart-modal button.btn");

    public String isAllProductsRelatedToSearch (String product)
    {
        List <WebElement> elements = driver.findElements(productDescription);
        for (WebElement element:elements)
        {
            if(element.getText().contains(product)) {}
            else {return "Not all products are related to search";}
        }
        return "True";
    }

    public Product_Page clickOnProduct(int productIndex)
    {
        List <WebElement> elements =driver.findElements(productDescription);
        elements.get(productIndex).click();
        return new Product_Page(driver);
    }

    public void hoverOverProductAndClickAddQuickView(int productIndex)
    {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        List<WebElement> elements =driver.findElements(productDescription);
        List<WebElement> quickViewList =driver.findElements(QuickView);
        hoverOnElement(elements.get(productIndex));
        quickViewList.get(productIndex).click();
    }
    public void clickAddCartBtnOnClickView()
    {
        wait=new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(addTOCartBtn));
        click(this.addTOCartBtn);
    }
    public void clickContinueShopping()
    {
        wait=new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(ContinueShopping));
        click(this.ContinueShopping);
    }
}
