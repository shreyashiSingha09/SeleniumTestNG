package PracticeTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class Login {
    WebDriver driver;
    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://magento.softwaretestingboard.com/");
    }

    @Test
    public void LoginPage() {
        driver.findElement(By.xpath("//a[contains(text(),'Sign In')]")).click();
        driver.findElement(By.id("email")).sendKeys("singhashreyashi75@gmail.com");
        driver.findElement(By.id("pass")).sendKeys("Shreyashi1009.");
        driver.findElement(By.id("send2")).click();
    }

    @Test
    public void searchItems() {
        driver.findElement(By.cssSelector("input[placeholder='Search entire store here...']")).sendKeys("tops");
        List<WebElement> items = driver.findElements(By.xpath("//li[@class='selected']"));
        for ( WebElement option:items){
            if(option.getText().equalsIgnoreCase("tops")){
                option.click();
                break;
            }
        }

    }
    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
