package com.cydeo.tests.day12_PageObjectModel;

import com.cydeo.pages.DynamicLoad7Page;
import com.cydeo.pages.DynamicallyLoadedPage_1;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DynamicLoad7Test {

    @Test
    public void test1(){

        //TC#4 : Dynamically Loaded Page Elements 7
        //1. Go to https://practice.cydeo.com/dynamic_loading/7
        Driver.getDriver().get("https://practice.cydeo.com/dynamic_loading/7");

        DynamicLoad7Page dynamicLoad7Page = new DynamicLoad7Page();

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);

        wait.until(ExpectedConditions.titleIs("Dynamic title"));

        Assert.assertTrue(dynamicLoad7Page.doneMessage.isDisplayed());
        //Assert.assertTrue(dynamicLoad7Page.sungerBobImage.isDisplayed());



        //2. Wait until title is “Dynamic title”
        //3. Assert: Message “Done” is displayed.
        //4. Assert: Image is displayed.
    }

    @Test
    public void test2(){

        //TC#5 : Dynamically Loaded Page Elements 1
        //1. Go to https://practice.cydeo.com/dynamic_loading/1
        Driver.getDriver().get("https://practice.cydeo.com/dynamic_loading/1");

        DynamicallyLoadedPage_1 loadedPage_1 = new DynamicallyLoadedPage_1();

        //2. Click to start
        loadedPage_1.startButton.click();


        //3. Wait until loading bar disappears
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);

        wait.until(ExpectedConditions.invisibilityOf(loadedPage_1.barImage));


        //4. Assert username inputbox is displayed



        //5. Enter username: tomsmith
        loadedPage_1.usernameInputbox.sendKeys("asd");

        //6. Enter password: incorrectpassword
        loadedPage_1.passwordInputbox.sendKeys("asd");

        //7. Click to Submit button
        loadedPage_1.submitButton.click();


        //8. Assert “Your password is invalid!” text is displayed.
        Assert.assertTrue(loadedPage_1.message.isDisplayed());


        //Note: Follow POM Design Pattern
    }



}
