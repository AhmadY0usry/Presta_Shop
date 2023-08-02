package Pages;

import Page_Base.Page_Base;
import org.apache.poi.ss.formula.atp.Switch;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Home_Page extends Page_Base {
    WebDriver driver;

    public Home_Page(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    By SignUp_Btn= By.cssSelector("#_desktop_user_info > div > a");
    By accountName= By.cssSelector(".user-info a span");
    By Contact_us= By.partialLinkText("Contact us");
    By All_products= By.partialLinkText("All products");
    By SearchField= By.name("s");
    By SubscribeField =By.name("email");
    By SubscribeBtn=By.name("submitNewsletter");
    By SubscribeSuccessMsg=By.cssSelector(".block_newsletter_alert");
    By CartBtn=By.id("_desktop_cart");
    By ClothesBtn=By.cssSelector("#category-3 a");
    By Men=By.cssSelector("#category-4 a");

    By Women=By.cssSelector("#category-5 a");

    public Login_Page clickOnSignUpBtn()
{
    wait= new WebDriverWait(driver,Duration.ofSeconds(10));
    wait.withTimeout(Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(SignUp_Btn));
    click(SignUp_Btn);
    return new Login_Page(driver);
}
    public ContactUs_Page clickOnContactUs()
    {
        click(Contact_us);
        return new ContactUs_Page (driver);
    }

public String getAccountName()
{
    return getText(accountName);
}
public void clickOnSignOutBtn()
    {
        click(SignUp_Btn);
    }
public void clickOnAllProducts() {click(All_products);}
public SearchResults_Page searchFor(String item)
{
    clearAndSendText(SearchField,item);
    driver.findElement(SearchField).sendKeys(Keys.ENTER);
    return new SearchResults_Page(driver);
}
public void enterEmailSubscribeField(String Email)
{
    clearAndSendText(SubscribeField,Email);
}
public void clickOnSubscribeBtn(){
        click(SubscribeBtn);
    };
public String getSubscribeMsg()
{
    wait=new WebDriverWait(driver,Duration.ofSeconds(10));
    wait.until(ExpectedConditions.visibilityOfElementLocated(SubscribeSuccessMsg));
    return getText(SubscribeSuccessMsg);
}
public Cart_Page clickOnCartBtn()
{
    click(this.CartBtn);
    return new Cart_Page(driver);
}
public CategoryResult_Page navigateToClothesAndSelect(String Gender){
    hoverOnElement(driver.findElement(ClothesBtn));
    switch(Gender.toUpperCase()){
        case "MEN"
            -> click(Men);
            default -> click(Women);
    }
    return new CategoryResult_Page(driver);

}
}
