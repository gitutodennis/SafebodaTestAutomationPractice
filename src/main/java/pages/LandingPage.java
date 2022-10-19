package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LandingPage {
    WebDriver webDriver;

    public LandingPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    private By imageYourLogo = By.xpath("//img[@alt='My Store']");
    private By btnPopular = By.xpath("//a[normalize-space()='Popular']");
    private By sectionPopularApparelsList = By.xpath("//ul[@id='homefeatured']");
    private By lnkWomen = By.xpath("//div[@id='block_top_menu']//a[@title='Women'][normalize-space()='Women']");
    private By lnkTops = By.xpath("//div[@class='block_content']//a[normalize-space()='Tops']");
    private By lnkTShirts = By.xpath("//div[@class='block_content']//a[contains(@title,'The must have of your wardrobe, take a look at our different colors,')][normalize-space()='T-shirts']");

    private By chkBoxLargeSize = By.xpath("//label[@for='layered_id_attribute_group_3']//a[1]");
    private By chkBoxOrangeColor = By.xpath("//label[@name='layered_id_attribute_group_13']//a[1]");
    private By chkBoxCasual = By.xpath("//ul[@id='ul_layered_id_feature_6']//a[1]");


    //Faded Short Sleeve T-shirt Section
    private By inputQuantity = By.xpath("//input[@id='quantity_wanted']");
    private By imageColor = By.xpath("//a[@id='color_13']");
    private By btnAddTocart = By.xpath("//span[normalize-space()='Add to cart']");

    public void navigateToLandingPage() {
        webDriver.findElement(imageYourLogo).click();
    }

    public void navigateToPopularSection() {
        webDriver.findElement(btnPopular).click();
    }

    // After Adding The Item on the Cart
    private By lblQuantity = By.xpath("//span[@id='layer_cart_product_quantity']");
    private By lblColorSizeInfo = By.xpath("//span[@id='layer_cart_product_attributes']");
    private By lblShippingCost = By.xpath("//span[@class='ajax_cart_shipping_cost']");
    private By btnProceedToCheckout = By.xpath("//span[normalize-space()='Proceed to checkout']");
    private  By lblCartTotal = By.xpath("//span[@class='ajax_block_cart_total']");
    private By lblTotalProductCost = By.xpath("//span[@class='ajax_block_products_total']");



    public List<String> getPopularApparels() {
        List<String> popularApparelList = new ArrayList<>();
        List<WebElement> popularSection = webDriver.findElements(sectionPopularApparelsList);
        for (WebElement webElement : popularSection) {
            String text = webElement.getText();
            System.out.println(text);
            popularApparelList.add(text);
        }
        ArrayList<String> sortedList = new ArrayList<>();
        for (String s : popularApparelList) {
            sortedList.add(s);
        }
        Collections.sort(sortedList);

        return popularApparelList;
    }

    public void clickWomenMenu() {
        webDriver.findElement(lnkWomen).click();
    }

    public void clickTopsMenu() {
        webDriver.findElement(lnkTops).click();
    }

    public void clickTShirtsMenu() {
        WebDriverWait webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(5));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(lnkTShirts)).click();
    }

    public void checkLargeSize() {
        webDriver.findElement(chkBoxLargeSize).click();
    }

    public void checkOrangeColor() throws InterruptedException {
        WebDriverWait webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(chkBoxOrangeColor)).click();
        Thread.sleep(3000);

    }

    public void checkCasualStyle() {
        webDriver.findElement(chkBoxCasual).click();
    }

    public boolean verifySizeLIsFiltered() {
        WebDriverWait webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        return webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[normalize-space()='Size: L']"))).isDisplayed();
    }

    public boolean verifyColorOrangeIsFiltered() {
        WebDriverWait webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        return webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[normalize-space()='Color: Orange']"))).isDisplayed();
    }

    public boolean verifyStylesCasualIsFiltered() {
        WebDriverWait webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        return webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[normalize-space()='Styles: Casual']"))).isDisplayed();
    }

    public void clickMoreOnTheTShirt() {
        WebElement imageTShirt = webDriver.findElement(By.xpath("//img[@title='Faded Short Sleeve T-shirts']"));
        Actions actions = new Actions(webDriver);
        actions.moveToElement(imageTShirt);
        WebElement moreButton = webDriver.findElement(By.xpath("//span[normalize-space()='More']"));
        actions.moveToElement(moreButton).click().build().perform();

    }

    public void enterQuantityWanted(String quantity) {
        webDriver.findElement(inputQuantity).clear();
        webDriver.findElement(inputQuantity).sendKeys(quantity);
    }

    public void addToCart() {
        webDriver.findElement(btnAddTocart).click();
    }

    public void selectTheSize() {
        Select select = new Select(webDriver.findElement(By.xpath("//select[@id='group_1' and @name='group_1']")));
        select.selectByValue("3");
    }

    public void selectColor() {
        webDriver.findElement(imageColor);
    }

    public String getColorAndSizeInfo() {

        webDriver.findElement(lblColorSizeInfo).click();
        String webElement = webDriver.findElement(lblColorSizeInfo).getText();
        return webElement;
    }

    public String getQuantityInfo() {

        webDriver.findElement(lblQuantity).click();
        String quantity = webDriver.findElement(lblQuantity).getText();
        return quantity;
    }

    public String getShippingCost() {

        webDriver.findElement(lblShippingCost).click();
        String shippingCost = webDriver.findElement(lblShippingCost).getText();
        return shippingCost;

    }

    public String getTotalCartCost()
    {
        webDriver.findElement(lblCartTotal).click();
        String totalCartCost = webDriver.findElement(lblCartTotal).getText();
        return totalCartCost;
    }

    public String getTotalProductCost()
    {
        webDriver.findElement(lblTotalProductCost).click();
        String totalProductCost = webDriver.findElement(lblTotalProductCost).getText();
        return totalProductCost;
    }

    public void proceedToCheckOut() {
        webDriver.findElement(btnProceedToCheckout).click();
    }

}
