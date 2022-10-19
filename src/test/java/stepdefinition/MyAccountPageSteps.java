package stepdefinition;

import factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.datatable.DataTable;
import org.junit.Assert;
import pages.LoginPage;
import pages.MyAccountPage;

import java.util.*;

public class MyAccountPageSteps {

    private MyAccountPage myAccountPage;
    private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());

   @Given("user has already logged in to application")
    public void user_has_already_logged_in_to_application(DataTable dataTable) {
       List<Map<String,String>> credentialsList =  dataTable.asMaps();
       String username = credentialsList.get(0).get("username");
       String password =credentialsList.get(0).get ("password");
       DriverFactory.getDriver().get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
       myAccountPage = loginPage.doLogin(username,password);

    }

    @Given("user is on Account Page")
    public void user_is_on_account_page() {
        String title = myAccountPage.getMyAccountPageTitle();
        System.out.println("My Account Page Title is:" + title);
    }

    @Then("user gets account sections")
    public void user_gets_account_sections(DataTable sectionsTable) {
        List<String> expectedAccountSectionsList = sectionsTable.asList();
        System.out.println("Expected Accounts Section List:" + expectedAccountSectionsList);
        List<String> actualAccountSectionList = myAccountPage.getAccountSectionsList();
        System.out.println("Actual Accounts Section List:" + actualAccountSectionList);
        Assert.assertTrue(expectedAccountSectionsList.containsAll(actualAccountSectionList));
    }

    @Then("the Sections should be {int}")
    public void the_sections_should_be(Integer expectedSectionCount) {

        Assert.assertTrue(myAccountPage.getAccountSectionCount() == expectedSectionCount);

    }


}
