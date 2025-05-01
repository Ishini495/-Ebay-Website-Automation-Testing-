package com.ebay.utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

public class TestUtils {

    // Method to load test data from properties file
    public static Properties loadProperties(String filepath) {
        Properties properties = new Properties();
        try {
            FileInputStream file = new FileInputStream(filepath);
            properties.load(file);
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }

    // Method to take screenshot
    public static void takeScreenshot(WebDriver driver, String testName) {
        try {
            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            String screenshotName = testName + "_" + timestamp + ".png";
            Path screenshotPath = Paths.get("test-output", "screenshots");

            // Create directory if it doesn't exist
            Files.createDirectories(screenshotPath);

            // Take screenshot and save it
            File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            Files.copy(screenshotFile.toPath(), screenshotPath.resolve(screenshotName));

            System.out.println("Screenshot saved: " + screenshotPath.resolve(screenshotName));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method to handle test result and take screenshot on failure
    public static void handleTestResult(WebDriver driver, org.testng.ITestResult result) {
        if (result.getStatus() == org.testng.ITestResult.FAILURE) {
            takeScreenshot(driver, result.getName());
        }
    }
}