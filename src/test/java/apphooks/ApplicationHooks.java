package apphooks;

import factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import utils.ConfigReader;

import java.util.Properties;

public class ApplicationHooks {
    private DriverFactory driverFactory;
    private WebDriver webDriver;
    private ConfigReader configReader;
    Properties properties;

    @Before(order =0)
    public void getProperty ()
    {
        configReader = new ConfigReader();
        properties = configReader.init_prop();
    }

    @Before(order = 1)
    public  void launchBrowser()
    {
        String browserName = properties.getProperty("browser");
        driverFactory=new DriverFactory();
        webDriver = driverFactory.init_driver(browserName);
    }

    @After(order = 0)
    public void quitBrowser()
    {
        webDriver.quit();
    }

    @After (order = 1)
    public void tearDown(Scenario scenario)
    {
        if (scenario.isFailed())
        {
            //Take a Screenshot

            String screenshotName = scenario.getName().replaceAll("","_");
            byte[] sourcePath = ((TakesScreenshot)webDriver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(sourcePath, "image/png", screenshotName);
        }
    }

}
