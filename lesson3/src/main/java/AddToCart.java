import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class AddToCart {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options= new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("start-maximized");

        WebDriver driver= new ChromeDriver(options);
        driver.get("http://automationpractice.com");










    }
}
