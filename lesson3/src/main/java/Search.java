import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Search {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options= new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("start-maximized");

        WebDriver driver= new ChromeDriver(options);
        driver.get("http://automationpractice.com");
        WebElement searchFild = driver.findElement(By.xpath("//*[@id=\"search_query_top\"]"));
        searchFild.click();
        searchFild.sendKeys("top");
        WebElement searchButton = driver.findElement(By.xpath("//*[@id=\"searchbox\"]/button"));
        searchButton.click();




    }
}
