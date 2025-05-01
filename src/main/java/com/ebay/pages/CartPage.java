package com.ebay.pages;

import com.ebay.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage {

    @FindBy(xpath = "//div[contains(@class, 'cart-item-title')]//span")
    private WebElement cartItemName;

    @FindBy(xpath = "//div[contains(@class, 'item-price')]//span")
    private WebElement cartItemPrice;

    @FindBy(xpath = "//div[contains(@class, 'cart-summary')]//span[contains(text(), 'Total')]/..//span[2]")
    private WebElement estimatedTotal;

    @FindBy(xpath = "//button[contains(text(), 'Go to checkout')]")
    private WebElement checkoutButton;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public String getCartItemName() {
        waitForElementToBeVisible(cartItemName);
        return getElementText(cartItemName);
    }

    public String getCartItemPrice() {
        waitForElementToBeVisible(cartItemPrice);
        return getElementText(cartItemPrice);
    }

    public String getEstimatedTotal() {
        waitForElementToBeVisible(estimatedTotal);
        return getElementText(estimatedTotal);
    }

    public void proceedToCheckout() {
        clickElement(checkoutButton);
    }
}