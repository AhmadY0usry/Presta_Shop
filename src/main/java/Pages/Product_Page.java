package Pages;

import Page_Base.Page_Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Product_Page extends Page_Base {
    WebDriver driver;

    public Product_Page(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    By WriteReview=By.cssSelector(".post-product-comment");
    By CommentTitle=By.id("comment_title");
    By CommentContent=By.id("comment_content");
    By SendBtn=By.xpath("//button[contains(text(),\"Send\")]");
    By Check_Circle=By.cssSelector("#product-comment-posted-modal .modal-header  i");

    public void clickOnWriteReview()
    {
        List<WebElement> elements=driver.findElements(this.WriteReview);
        elements.get(0).click();
    }
    public void enterTitleContentAndClickSend(String Title, String Content)
    {
        wait =new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(CommentTitle));
        clearAndSendText(this.CommentTitle,Title);
        clearAndSendText(this.CommentContent,Content);
        click(this.SendBtn);
    }
    public String getReviewSent()
    {
        return this.driver.findElement(this.Check_Circle).getAttribute("data-icon");
    }

}
