package com.ebay.tests;

import com.ebay.base.BaseTest;
import com.ebay.pages.*;
import com.ebay.utils.TestUtils;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Properties;

public class EbayMobilePhoneTest extends BaseTest {

    private HomePage homePage;
    private FilterPage filterPage;
    private ProductPage productPage;
    private CartPage cartPage;
    private CheckoutPage checkoutPage;
    private Properties config;

    private String productName;
    private String productPrice;

    @BeforeMethod
    @Parameters({"browser"})
    public void setup(String browser) {
        super.setUp(browser);

        // Initialize page objects
        homePage = new HomePage(driver);
        filterPage = new FilterPage(driver);
        productPage = new ProductPage(driver);
        cartPage = new CartPage(driver);
        checkoutPage = new CheckoutPage(driver);

        // Load test data
        config = TestUtils.loadProperties("src/test/resources/config.properties");
    }

    @Test
    public void testEbayMobilePhonePurchase() {
        // Step 1: Launch browser and navigate to eBay
        homePage.navigateToHomePage(config.getProperty("url"));

        // Verify URL is correct
        String currentUrl = homePage.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("ebay.com"), "URL validation failed");
        System.out.println("Successfully navigated to: " + currentUrl);

        // Step 2: Navigate to Electronics > Cell Phones & Smartphones
        homePage.navigateToElectronics();
        homePage.navigateToCellPhonesAndSmartphones();

        // Step 3: Click See All
        homePage.clickSeeAll();

        // Step 4: Select Screen Size filter
        filterPage.selectScreenSizeFilter();
        filterPage.selectSpecificScreenSize();
        filterPage.clickApply();

        // Step 5: Select first product from results
        filterPage.clickFirstProduct();

        // Step 6: Get product details
        productName = productPage.getProductName();
        productPrice = productPage.getProductPrice();

        System.out.println("Selected Product Name: " + productName);
        System.out.println("Selected Product Price: " + productPrice);

        // Step 7: Add to cart
        productPage.addToCart();

        // Step 8: Go to cart
        productPage.goToCart();

        // Step 9: Verify cart details
        String cartItemName = cartPage.getCartItemName();
        String cartItemPrice = cartPage.getCartItemPrice();

        Assert.assertTrue(cartItemName.contains(productName) || productName.contains(cartItemName),
                "Product name in cart doesn't match selected product");
        Assert.assertTrue(cartItemPrice.contains(productPrice) || productPrice.contains(cartItemPrice),
                "Product price in cart doesn't match selected product");

        // Step 10: Get estimated total
        String estimatedTotal = cartPage.getEstimatedTotal();
        System.out.println("Estimated Total: " + estimatedTotal);

        // Step 11: Proceed to checkout
        cartPage.proceedToCheckout();

        // Step 12: Enter email for guest checkout
        checkoutPage.enterEmail(config.getProperty("email"));
        checkoutPage.clickContinue();

        // Step 13: Fill shipping information
        checkoutPage.enterShippingDetails(
                config.getProperty("firstName"),
                config.getProperty("lastName"),
                config.getProperty("address"),
                config.getProperty("city"),
                config.getProperty("state"),
                config.getProperty("zipCode"),
                config.getProperty("phoneNumber")
        );

        // Test ends here (login would be required to proceed further)
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            System.out.println("❌ Test FAILED: " + result.getName());
            // Optional: TestUtils.takeScreenshot(driver, result.getName());
        } else {
            System.out.println("✅ Test PASSED: " + result.getName());
        }

        super.tearDown();
    }
}
