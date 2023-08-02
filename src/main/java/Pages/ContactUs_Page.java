package Pages;

import Page_Base.Page_Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactUs_Page extends Page_Base {
    WebDriver driver;

    public ContactUs_Page(WebDriver driver) {
        super(driver);
        this.driver =driver;
    }

    By ContactUsText = By.cssSelector(".col-md-offset-3");
    By Subject = By.id("id_contact");
    By EmailAddress = By.id("email");
    By AttachmentBtn = By.className("buttonText");
    By ContactForm_message = By.id("contactform-message");
    By SendBtn = By.name("submitMessage");
    By SuccessMsg =By.cssSelector(".alert-success");


    public String getContactUsText ()
    {
        return getText(this.ContactUsText);
    }

    public void selectSubject()
    {
        selectFromList(Subject,"1");
    }
    public void setEmailAddress(String Text)
    {
        clearAndSendText(EmailAddress,Text);
    }
//    public void attach_File(String filePath)
//    {
//        WebElement fileInput = driver.findElement(AttachmentBtn);
//        fileInput.sendKeys(filePath);
//    }
    public void ContactForm_message(String Text)
    {
        clearAndSendText(ContactForm_message,Text);
    }

    public void clickOnSendBtn()
    {
        click(SendBtn);
    }

    public String getSuccessMsg() {
        return getText(SuccessMsg);
    }
}
