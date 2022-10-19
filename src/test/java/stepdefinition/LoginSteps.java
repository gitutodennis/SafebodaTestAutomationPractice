package stepdefinition;

import factory.DriverFactory;
import io.cucumber.java.en.But;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;

public class LoginSteps {

    //We have  a constructor on Login Page  - We are getting the Driver from the Driver Factory Class.
    private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
    private static String pageTitleName;


    @Given("User is on the Login Page")
    public void user_is_on_the_login_page() {
     DriverFactory.getDriver().get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
    }

    @When("User gets the Title of the Page")
    public void user_gets_the_title_of_the_page() {
        pageTitleName = loginPage.getLoginPageTitle();

    }

    @Then("Page Title should be {string}")
    public void page_title_should_be(String expectedTitleName) {
        Assert.assertTrue(pageTitleName.contains(expectedTitleName));

    }

    @Then("Forgot your password link should be Visible")
    public void forgot_your_password_link_should_be_visible() {

        Assert.assertTrue(loginPage.isForgotPasswordExist());
    }

    @When("user enters username {string}")
    public void user_enters_username(String username) {
        loginPage.enterUserName(username);
    }

    @But("user enters invalid password {string}")
    public void userEntersInvalidPassword(String invalidPassword) {

        loginPage.enterPassword(invalidPassword);
    }

    @Then("Error message is Displayed")
    public void errorMessageIsDisplayed() {
        Assert.assertTrue(loginPage.invalidPasswordMsgIsDisplayed());
    }

    @When("user enter valid password {string}")
    public void user_enter_valid_password(String password) {
    loginPage.enterPassword(password);

    }

    @When("user click the Login Button")
    public void user_click_the_login_button() {
        loginPage.clickLoginButton();

    }



}
