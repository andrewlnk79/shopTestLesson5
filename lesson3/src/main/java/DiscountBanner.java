import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DiscountBanner {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options= new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("start-maximized");

        WebDriver driver= new ChromeDriver(options);
        driver.get("http://automationpractice.com");
        WebElement baner1 = driver.findElement(By.cssSelector("#htmlcontent_top > ul > li.htmlcontent-item-1.col-xs-4 > a > img"));
        baner1.click();

    }

}
