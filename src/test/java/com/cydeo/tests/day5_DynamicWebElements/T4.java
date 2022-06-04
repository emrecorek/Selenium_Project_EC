package com.cydeo.tests.day5_DynamicWebElements;

import com.cydeo.utilities.HandleWait;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class T4 {

    WebDriver driver;

    @BeforeMethod
    public void setupBrowser(){
        //1. Open Chrome browser
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //2. Go to https://practice.cydeo.com/dropdown
        driver.get("https://practice.cydeo.com/dropdown");

    }

    @AfterMethod
    public void closeBrowser(){
        HandleWait.staticWait(3);
        driver.close();
    }

    //3. Verify “Simple dropdown” default selected value is correct
    //Expected: “Please select an option”
    @Test
    public void verifySimpleDropdown(){

        Select simpleDropdown = new Select(driver.findElement(By.xpath("//select[@id='dropdown']")));

        String actualDefaultValue = simpleDropdown.getFirstSelectedOption().getText();
        String expectedDefaultValue = "Please select an option";

        System.out.println(actualDefaultValue);
        System.out.println(simpleDropdown);
        System.out.println();
        System.out.println(simpleDropdown.getFirstSelectedOption());

        Assert.assertEquals(actualDefaultValue, expectedDefaultValue, "Value verification failed");

    }


    //4. Verify “State selection” default selected value is correct
    //Expected: “Select a State”
    @Test
    public void verifyStateSelection(){

        Select stateSelection = new Select(driver.findElement(By.xpath("//select[@id='state']")));

        WebElement defaultStateSelection = stateSelection.getFirstSelectedOption();

        String actualDefaultValue = defaultStateSelection.getText();
        String expectedDefaultValue = "Select a State";

        Assert.assertTrue(actualDefaultValue.equals(expectedDefaultValue), "Value verification failed");

    }


}

/*
1. Open Chrome browser
2. Go to https://practice.cydeo.com/dropdown
3. Verify “Simple dropdown” default selected value is correct
Expected: “Please select an option”
4. Verify “State selection” default selected value is correct
Expected: “Select a State”
 */
