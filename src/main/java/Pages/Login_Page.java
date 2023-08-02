package Pages;

import Page_Base.Page_Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login_Page extends Page_Base {
    WebDriver driver;

    public Login_Page(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
    By Email_Field=By.id("field-email");
    By Password_Field=By.id("field-password");
    By SignInBtn=By.id("submit-login");
    By createAccountBtn=By.partialLinkText("No account? Create one here");
    By AuthenticationErrorMsg=By.cssSelector(".alert.alert-danger");

    public void Enter_email_and_password(String Email,String Password)

    {
        clearAndSendText(Email_Field,Email);
        clearAndSendText(Password_Field,Password);
    }
    public void clickOnSignInBtn()
    {
        click(SignInBtn);
    }
    public Signup_Page clickOnCreateAccountBtn()
    {
        click(createAccountBtn);
        return new Signup_Page(driver);
    }

    public String getAuthenticationErrorMsg() {
        return getText(AuthenticationErrorMsg);
    }
}
