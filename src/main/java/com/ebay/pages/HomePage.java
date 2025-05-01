package com.ebay.pages;

import com.ebay.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.interactions.Actions;

public class HomePage extends BasePage {

    @FindBy(linkText = "Electronics")
    private WebElement electronicsLink;

    @FindBy(xpath = "//a[contains(text(),'Cell Phones & Accessories')]")
    private WebElement cellPhonesLink;

    @FindBy(xpath = "//a[contains(text(),'See All')]")
    private WebElement seeAllLink;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void navigateToHomePage(String url) {
        driver.get(url);
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public void navigateToElectronics() {
        Actions actions = new Actions(driver);
        actions.moveToElement(electronicsLink).perform();
        clickElement(electronicsLink);
    }

    public void navigateToCellPhonesAndSmartphones() {
        Actions actions = new Actions(driver);
        actions.moveToElement(electronicsLink).perform();
        waitForElementToBeVisible(cellPhonesLink);
        clickElement(cellPhonesLink);
    }

    public void clickSeeAll() {
        clickElement(seeAllLink);
    }
}