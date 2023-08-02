package Pages;

import Page_Base.Page_Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CategoryResult_Page extends Page_Base {
    WebDriver driver;
    public CategoryResult_Page(WebDriver driver) {
        super(driver);
        this.driver=driver;
    }
By ListHeader=By.className("h1");

    public String getListHeader()
    {
        return getText(ListHeader);
    }


}
