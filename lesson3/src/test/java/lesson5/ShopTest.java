package lesson5;

import dev.failsafe.internal.util.Assert;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import java.time.Duration;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ShopTest {
    static WebDriver driver;


    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();

    }

    @BeforeEach
    void initDriver() {
        driver = new ChromeDriver();
        driver.get("http://automationpractice.com/index.php");


    }

    @Test
    public void addToCart() throws InterruptedException {


        driver.findElement(By.xpath("//*[@id=\"homefeatured\"]/li[1]/div/div[1]/div/a[1]/img")).click();
        driver.findElement(By.xpath("//*[@id=\"add_to_cart\"]/button/span")).click();
        Thread.sleep(5000);
        Assertions.assertEquals(driver.findElement(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a")).isDisplayed(), true);


    }

    @Test
    public void categoryMenuWomen() {
        driver.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[1]/a")).click();
        Assertions.assertEquals(driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/span[2]")).isDisplayed(), true);


    }

    @Test
    public void discountBanner() {
        driver.findElement(By.xpath("//div[@id='htmlcontent_top']//li[@class='htmlcontent-item-2 col-xs-4']//img[@class='item-img']")).click();
        Assertions.assertEquals(driver.getCurrentUrl().contains("prestashop"), true);
    }

    @Test
    public void checkSearch() throws InterruptedException {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("//*[@id=\"search_query_top\"]"))).click()
                .sendKeys("top")
                .moveToElement(driver.findElement(By.xpath("//*[@id=\"searchbox\"]/button")))
                .click()
                .build()
                .perform();
        Thread.sleep(5000);
        Assertions.assertEquals(driver.getCurrentUrl().contains("SEARCH"),true);

    }

    // @AfterEach
    void tearDown() {
        driver.quit();
    }
}
