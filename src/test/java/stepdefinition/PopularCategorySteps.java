package stepdefinition;

import factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LandingPage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PopularCategorySteps {

    private LandingPage landingPage = new LandingPage(DriverFactory.getDriver());
    @Given("User is on the Landing Page")
    public void userIsOnTheLandingPage() {
        landingPage.navigateToLandingPage();
    }
    @When("User clicks on the Popular Category Button")
    public void userClicksOnThePopularCategoryButton() {
        landingPage.navigateToPopularSection();
    }
    @Then("User is able to get the Apparels List")
    public void userIsAbleToGetTheApparelsList() {
        List<String> apparelList = landingPage.getPopularApparels();
        System.out.println("Apparel List:" + apparelList);
    }
}
