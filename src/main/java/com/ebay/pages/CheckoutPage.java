package com.ebay.pages;

import com.ebay.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage extends BasePage {

    @FindBy(id = "email")
    private WebElement emailField;

    @FindBy(id = "btnEmail")
    private WebElement continueButton;

    @FindBy(id = "firstName")
    private WebElement firstNameField;

    @FindBy(id = "lastName")
    private WebElement lastNameField;

    @FindBy(id = "addressLine1")
    private WebElement addressLine1Field;

    @FindBy(id = "city")
    private WebElement cityField;

    @FindBy(id = "stateOrProvince")
    private WebElement stateField;

    @FindBy(id = "postalCode")
    private WebElement zipCodeField;

    @FindBy(id = "phoneNumber")
    private WebElement phoneNumberField;

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public void enterEmail(String email) {
        sendKeysToElement(emailField, email);
    }

    public void clickContinue() {
        clickElement(continueButton);
    }

    public void enterShippingDetails(String firstName, String lastName, String address,
                                     String city, String state, String zipCode, String phone) {
        sendKeysToElement(firstNameField, firstName);
        sendKeysToElement(lastNameField, lastName);
        sendKeysToElement(addressLine1Field, address);
        sendKeysToElement(cityField, city);
        sendKeysToElement(stateField, state);
        sendKeysToElement(zipCodeField, zipCode);
        sendKeysToElement(phoneNumberField, phone);
    }
}