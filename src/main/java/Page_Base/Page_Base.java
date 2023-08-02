package Page_Base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Page_Base {
    WebDriver driver;
    public WebDriverWait wait;
    Actions actions;
    public Page_Base(WebDriver driver) {
        this.driver=driver;
    }

    public void click(By byElement)
    {
        driver.findElement(byElement).click();
    }
    public void clearAndSendText(By byElement, String text)
    {
        driver.findElement(byElement).clear();
        driver.findElement(byElement).sendKeys(text);
    }
    public String getText(By byElement)
    {
        return driver.findElement(byElement).getText();
    }
    Select select;
    public void selectFromList(By byElement,String value)
    {
        select = new Select(driver.findElement(byElement));
        select.selectByValue(value);
    }

    public void hoverOnElement(WebElement Element)
    {
        actions=new Actions(driver);
        actions.moveToElement(Element).build().perform();
    }


}
