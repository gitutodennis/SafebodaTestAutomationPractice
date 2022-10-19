package stepdefinition;

import factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.LandingPage;

public class AddingToCartSteps {

    private LandingPage landingPage = new LandingPage(DriverFactory.getDriver());

    @Given("User has clicked on the Women Section")
    public void userHasClickedOnTheWomenSection() {
        landingPage.clickWomenMenu();
    }

    @And("User clicks on the TShirt Section")
    public void userClicksOnTheTShirtSection() {
        landingPage.clickTShirtsMenu();
    }

    @And("User Click on the Tops Menu on the Dashboard")
    public void userClickOnTheTopsMenuOnTheDashboard() {
        landingPage.clickTopsMenu();


    }

    @Then("Dresses are filtered using size \\(Large), color\\(Orange) and Style \\(Casuals)")
    public void dressesAreFilteredUsingSizeLargeColorOrangeAndStyleCasuals() {
        Assert.assertTrue(landingPage.verifySizeLIsFiltered());
        Assert.assertTrue(landingPage.verifyColorOrangeIsFiltered());
        Assert.assertTrue(landingPage.verifyStylesCasualIsFiltered());
    }

    @And("User is on Catalog and selects LARGE")
    public void userIsOnCatalogAndSelectsLARGE() {
        landingPage.checkLargeSize();
    }

    @And("User Selects color ORANGE")
    public void userSelectsColorORANGE() throws InterruptedException {
        landingPage.checkOrangeColor();
    }

    @And("User selects CASUAL Style")
    public void userSelectsCASUALStyle() {
        landingPage.checkCasualStyle();
    }

    @And("The product is displayed and User clicks on More")
    public void theProductIsDisplayedAndUserClicksOnMore() {
        landingPage.clickMoreOnTheTShirt();
    }

    @And("User enters the Quantity {string}")
    public void userEntersTheQuantity(String quantity) {
        landingPage.enterQuantityWanted(quantity);
    }

    @And("user enters the Size")
    public void userEntersTheSize() {
        landingPage.selectTheSize();
    }

    @And("User selects the color")
    public void userSelectsTheColor() {
        landingPage.selectColor();
    }

    @And("User Adds the Items to the Cart")
    public void userAddsTheItemsToTheCart() {
        landingPage.addToCart();
    }


    @And("User Proceeds to Checkout")
    public void userProceedsToCheckout() {
        landingPage.proceedToCheckOut();
    }

    @Then("The color and size should be should be  {string}")
    public void theColorAndSizeShouldBeShouldBe(String expectedColorAndSize) {
       String actualColorSize =  landingPage.getColorAndSizeInfo();
       System.out.println("The Color and Size is:" + actualColorSize);
       Assert.assertTrue(expectedColorAndSize.contains(actualColorSize));
    }

    @And("the Shipping Cost is {string}")
    public void theShippingCostIs(String expectedShippingCost) {
        String actualShippingCost = landingPage.getShippingCost();
        System.out.println("The Shipping Cost is: "+ actualShippingCost);
        Assert.assertTrue(expectedShippingCost.contains(actualShippingCost));
    }

    @And("The Quantity is {string}")
    public void theQuantityIs(String expectedQuantity) {
        String actualQuantity = landingPage.getQuantityInfo();
        System.out.println("The Quantity is:"+actualQuantity);
        Assert.assertTrue(expectedQuantity.contains(actualQuantity));
    }

    @And("The TOTAL COST is {string}")
    public void theTOTALCOSTIs(String expectedTotalCost) {
        String actualTotalCost = landingPage.getTotalCartCost();
        System.out.println("The Total Cost is:" + actualTotalCost);
        Assert.assertTrue(expectedTotalCost.contains(actualTotalCost));
    }

    @And("The quantity , size,color, total product cost, shipping cost, total cost are displayed on the Console")
    public void theQuantitySizeColorTotalProductCostShippingCostTotalCostAreDisplayedOnTheConsole() {
        String actualColorSize =  landingPage.getColorAndSizeInfo();
        System.out.println("The Color and Size is:" + actualColorSize);
        String actualShippingCost = landingPage.getShippingCost();
        System.out.println("The Shipping Cost is: "+ actualShippingCost);
        String actualQuantity = landingPage.getQuantityInfo();
        System.out.println("The Quantity is:"+actualQuantity);
        String actualTotalCost = landingPage.getTotalCartCost();
        System.out.println("The Total Cost is:" + actualTotalCost);
        String totalProductCost = landingPage.getTotalProductCost();
        System.out.println("The Total Product Cost:" + totalProductCost);

    }
}
