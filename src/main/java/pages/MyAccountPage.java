package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class MyAccountPage {
    WebDriver webDriver;

    private By accountSection = By.cssSelector("div#center_column span");


    public MyAccountPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public String getMyAccountPageTitle()
    {
        return webDriver.getTitle();
    }

    public int getAccountSectionCount()
    {
        return webDriver.findElements(accountSection).size();
    }
    public List<String> getAccountSectionsList()
    {
        List<String> accountList = new ArrayList<>();
        List<WebElement> accountHeaderList = webDriver.findElements(accountSection);
        for (WebElement webElement: accountHeaderList)
        {
            String text = webElement.getText();
            System.out.println(text);
            accountList.add(text);
        }
        return accountList;
    }

}
