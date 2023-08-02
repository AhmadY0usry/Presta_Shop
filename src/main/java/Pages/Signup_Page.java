package Pages;

import Page_Base.Page_Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Signup_Page extends Page_Base {
    WebDriver driver;
    public Signup_Page(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    By MaleGender = By.cssSelector("#field-id_gender-1");
    By FirstName = By.id("field-firstname");
    By LastName = By.id("field-lastname");
    By EmailField =By.id("field-email");
    By PasswordField = By.id("field-password");
    By Field_birthday = By.id("field-birthday");
    By partner_box = By.name("optin");
    By Terms_box = By.name("psgdpr");
    By newsletter_box = By.name("newsletter");
    By customer_privacy_box = By.name("customer_privacy");
    By registerBtn =By.cssSelector(".form-control-submit,#customer-form > footer > button");
    By ErrorMSGs=By.cssSelector(".help-block li");

    public void selectMaleFromTitle()
    {
        click(MaleGender);
    }
    public void selectNewsLetterChkBox()
    {
        click(newsletter_box);
    }
    public void selectPartnerChkBox()
    {
        click(partner_box);
    }
    public void selectTermsChkBox()
    {
        click(Terms_box);
    }
    public void selectCustomerPrivacyChkBox()
    {
        click(customer_privacy_box);
    }

    public void FillDetails(String Fname,String Lname,String email,String pass, String date)
    {
        clearAndSendText(this.FirstName,Fname.toString());
        clearAndSendText(this.LastName,Lname.toString());
        clearAndSendText(this.EmailField,email.toString());
        clearAndSendText(this.PasswordField,pass.toString());
        clearAndSendText(this.Field_birthday,date.toString());

    }

    public void clickOnSaveBtn()
    {
        click(registerBtn);
    }

    public String getErrorText (int errorIndex)
    {
        return driver.findElements(this.ErrorMSGs).get(errorIndex).getText();
    }


}
