package factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class DriverFactory {

    public WebDriver driver;

    /*Threads will help in Parallel Execution
    * We are initializing and setting the Web Driver
    * @Param Browser
    * @Returns tlWebDriver*/

    public static ThreadLocal<WebDriver> tlWebDriver = new ThreadLocal<>();
    public WebDriver init_driver(String browser)
    {
        System.out.println("Browser value is:" + browser);

        if (browser.equals("chrome"))
        {
            WebDriverManager.chromedriver().setup();
            tlWebDriver.set(new ChromeDriver());
        }

        else if (browser.equals("firefox"))
        {
            WebDriverManager.firefoxdriver().setup();
            tlWebDriver.set(new FirefoxDriver());
        }

        else if (browser.equals("safari"))
        {
            WebDriverManager.safaridriver().setup();
            tlWebDriver.set(new SafariDriver());
        }

        else if (browser.equals("edge"))
        {
            WebDriverManager.edgedriver().setup();
            tlWebDriver.set(new EdgeDriver());
        }
        else
        {
            System.out.println("Please pass the correct browser value:" + browser);
        }
        getDriver().manage().deleteAllCookies();
        getDriver().manage().window().maximize();
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        return getDriver();
    }

    public  static synchronized WebDriver getDriver()
    {
        return tlWebDriver.get();
    }

}
