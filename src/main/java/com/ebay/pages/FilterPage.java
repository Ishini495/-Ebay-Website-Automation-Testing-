package com.ebay.pages;

import com.ebay.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FilterPage extends BasePage {

    @FindBy(xpath = "//span[text()='Screen Size']")
    private WebElement screenSizeFilter;

    @FindBy(xpath = "//input[@aria-label='5.0 - 5.4 in']")
    private WebElement screenSizeOption;

    @FindBy(xpath = "//button[contains(text(), 'Apply')]")
    private WebElement applyButton;

    @FindBy(xpath = "//div[@class='srp-river-results']/ul/li[1]//a[@class='s-item__link']")
    private WebElement firstProductLink;

    public FilterPage(WebDriver driver) {
        super(driver);
    }

    public void selectScreenSizeFilter() {
        waitForElementToBeVisible(screenSizeFilter);
        clickElement(screenSizeFilter);
    }

    public void selectSpecificScreenSize() {
        waitForElementToBeVisible(screenSizeOption);
        clickElement(screenSizeOption);
    }

    public void clickApply() {
        clickElement(applyButton);
    }

    public void clickFirstProduct() {
        waitForElementToBeVisible(firstProductLink);
        clickElement(firstProductLink);
    }
}