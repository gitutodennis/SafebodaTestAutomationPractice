package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LoginPage {
private WebDriver webDriver;

private By txtEmailAddress =  By.xpath("//input[@id='email']");
private By txtPassword = By.xpath("//input[@id='passwd']");
private By forgotPasswordLnk = By.xpath("//a[contains(text(),'Forgot your password?')]");
private By btnLogin = By.xpath("//span[normalize-space()='Sign in']");
private By msgInvalidPasswordError = By.xpath("//p[normalize-space()='There is 1 error']");

    public LoginPage(WebDriver webDriver) {
        this.webDriver = webDriver;

    }

    public String getLoginPageTitle()
    {
        return webDriver.getTitle();
    }


    public boolean isForgotPasswordExist()
    {
        return webDriver.findElement(forgotPasswordLnk).isDisplayed();
    }

    public void enterUserName(String username)
    {
        webDriver.findElement(txtEmailAddress).sendKeys(username);
    }

    public void enterPassword(String password)
    {
        webDriver.findElement(txtPassword).sendKeys(password);
    }

    public void clickLoginButton()
    {
       webDriver.findElement(btnLogin).click();
    }

    public boolean invalidPasswordMsgIsDisplayed()
    {
        return webDriver.findElement(msgInvalidPasswordError).isDisplayed();
    }

    public MyAccountPage doLogin(String username, String password)
    {

        System.out.println("Login with:" +username + "and" + password);
        webDriver.findElement(txtEmailAddress).sendKeys(username);
        webDriver.findElement(txtPassword).sendKeys(password);
        webDriver.findElement(btnLogin).click();
        return new MyAccountPage(webDriver);
    }

}
