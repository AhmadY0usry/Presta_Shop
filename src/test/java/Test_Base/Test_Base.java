package Test_Base;

import Pages.Home_Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public class Test_Base {
    WebDriver driver;
    protected Home_Page homePage;
    @BeforeClass
    public void setup()
    {
        driver = new ChromeDriver();
        driver.get("https://demo.prestashop.com");
        homePage= new Home_Page(driver);
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));
        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector("#loadingMessage img"))));
        driver.manage().window().maximize();
        driver.switchTo().frame(0);
    }
    @AfterClass
        public void tearDown()
    {
       driver.quit();
    }

}
