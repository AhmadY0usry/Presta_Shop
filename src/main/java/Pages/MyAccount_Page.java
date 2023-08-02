package Pages;

import Page_Base.Page_Base;
import org.openqa.selenium.WebDriver;

public class MyAccount_Page extends Page_Base {
    WebDriver driver;

    public MyAccount_Page(WebDriver driver) {
        super(driver);
        this.driver=driver;
    }


}
