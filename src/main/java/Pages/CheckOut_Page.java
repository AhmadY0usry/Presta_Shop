package Pages;

import Page_Base.Page_Base;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class CheckOut_Page extends Page_Base {
    WebDriver driver;
    Signup_Page signupPage;

    public CheckOut_Page(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    By Continue = By.xpath("//button[@value=\"1\"]");
    By Address = By.name("address1");
    By Postcode = By.name("postcode");
    By City = By.name("city");
    By Country = By.name("id_country");
    By ConfirmDeliveryOption = By.cssSelector("#js-delivery > button");
    By ConfirmAddresses = By.name("confirm-addresses");
    By Agree =By.id("conditions_to_approve[terms-and-conditions]");
    By PlaceOrder=By.cssSelector(".btn-primary.center-block");
    By OrderSuccessMsg=By.cssSelector(".h1.card-title");
    public void clickOnContinue() {
        click(Continue);
    }

    public void fillPersonalInformation(String FName, String LName, String Email, String Pass, String Date) {
        signupPage = new Signup_Page(driver);
        signupPage.selectMaleFromTitle();
        signupPage.selectNewsLetterChkBox();
        signupPage.selectTermsChkBox();
        signupPage.selectPartnerChkBox();
        signupPage.selectCustomerPrivacyChkBox();
        signupPage.FillDetails(FName, LName, Email, Pass, Date);
    }
    public void fillAddressAndConfirm(String Postcode, String City, String Address) {
        wait=new WebDriverWait(driver,Duration.ofSeconds(60));
        wait.until(ExpectedConditions.presenceOfElementLocated(this.Postcode));
        clearAndSendText(this.Postcode,Postcode);
        wait.until(ExpectedConditions.presenceOfElementLocated(this.City));
        clearAndSendText(this.City,City);
        wait.until(ExpectedConditions.presenceOfElementLocated(this.Address));
        clearAndSendText(this.Address,Address);
        selectFromList(this.Country,"8");
        wait.ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(ConfirmAddresses));
        do{click(ConfirmAddresses);}
        while(driver.findElement(ConfirmAddresses).isDisplayed());
    }
    public void ConfirmDeliveryOption() {
        wait=new WebDriverWait(driver,Duration.ofSeconds(60));
        wait.ignoring(StaleElementReferenceException.class)
                .ignoring(ElementNotInteractableException.class)
                .until(ExpectedConditions.elementToBeClickable(ConfirmDeliveryOption));
        do{click(ConfirmDeliveryOption);}
        while(driver.findElement(ConfirmDeliveryOption).isDisplayed());
    }
    public void clickOnAgreeToTerms ()
    {
        wait=new WebDriverWait(driver,Duration.ofSeconds(60));
        wait.ignoring(ElementNotInteractableException.class).until(ExpectedConditions.presenceOfElementLocated(Agree));
        wait.ignoring(StaleElementReferenceException.class).until(ExpectedConditions.presenceOfElementLocated(Agree));
        click(this.Agree);
    }
    public void choosePaymentOption(String Option)
    {
        driver.findElement(By.id("payment-option-"+Option)).click();
    }
    public void clickOnPlaceOrder()
    {
        click(this.PlaceOrder);
    }
    public String getOrderSuccessMsg()
    {
        return getText(this.OrderSuccessMsg);
    }

}
