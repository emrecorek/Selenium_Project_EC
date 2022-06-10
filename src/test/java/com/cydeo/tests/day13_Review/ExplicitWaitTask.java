package com.cydeo.tests.day13_Review;

import com.cydeo.pages.ExplicitWaitPage;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ExplicitWaitTask {

    WebDriverWait wait=new WebDriverWait(Driver.getDriver(), 10);
    ExplicitWaitPage waitPage;

    @BeforeMethod
    public void setup(){
        Driver.getDriver().get("https://practice.cydeo.com/dynamic_controls");
        waitPage = new ExplicitWaitPage();
    }


    @Test
    public void explicitWaitTest1(){

        //TC #2: Explicit wait practice
        //1- Open a chrome browser
        //2- Go to: https://practice.cydeo.com/dynamic_controls

        //3- Click to “Remove” button
        waitPage.removeButton.click();

        //4- Wait until “loading bar disappears”

        wait.until(ExpectedConditions.invisibilityOf(waitPage.loadingBar));

        //5- Verify:
        //a. Checkbox is not displayed
        Assert.assertTrue(waitPage.checkbox.isDisplayed());


        //b. “It’s gone!” message is displayed.
        Assert.assertTrue(waitPage.message.isDisplayed());

        Driver.closeDriver();

    }

    @Test
    public void explicitWaitTest2(){

        //TC #3: Explicit wait practice
        //1- Open a chrome browser
        //2- Go to: https://practice.cydeo.com/dynamic_controls

        //3- Click to “Enable” button
        waitPage.enableButton.click();



        //4- Wait until “loading bar disappears”
        wait.until(ExpectedConditions.invisibilityOf(waitPage.loadingBar));

        //5- Verify:
        //a. Input box is enabled.
        Assert.assertTrue(waitPage.inputBox.isDisplayed());


        //b. “It’s enabled!” message is displayed.
        Assert.assertTrue(waitPage.enableMessage.isDisplayed());

        Driver.closeDriver();


    }
}
