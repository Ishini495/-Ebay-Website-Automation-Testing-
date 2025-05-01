package com.ebay.pages;

import com.ebay.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage {

    @FindBy(xpath = "//h1[@class='x-item-title__mainTitle']//span")
    private WebElement productTitle;

    @FindBy(xpath = "//div[contains(@class, 'x-price-primary')]//span")
    private WebElement productPrice;

    @FindBy(id = "binBtn_btn")
    private WebElement addToCartButton;

    @FindBy(id = "atcRedesignId_btn")
    private WebElement alternateAddToCartButton;

    @FindBy(xpath = "//a[contains(@class, 'gh-cart')]")
    private WebElement cartIcon;

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public String getProductName() {
        waitForElementToBeVisible(productTitle);
        return getElementText(productTitle);
    }

    public String getProductPrice() {
        waitForElementToBeVisible(productPrice);
        return getElementText(productPrice);
    }

    public void addToCart() {
        try {
            // Try the primary add to cart button
            waitForElementToBeClickable(addToCartButton);
            clickElement(addToCartButton);
        } catch (Exception e) {
            // Try the alternate add to cart button
            waitForElementToBeClickable(alternateAddToCartButton);
            clickElement(alternateAddToCartButton);
        }
    }

    public void goToCart() {
        waitForElementToBeClickable(cartIcon);
        clickElement(cartIcon);
    }
}