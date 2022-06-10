package com.cydeo.tests.day13_Review;

import com.cydeo.pages.DoubleClickPage;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DoubleClickTask {


    @Test
    public void doubleClickTest(){

        //TC #1: Double Click Test
        //1. Go to
        //https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick2
        Driver.getDriver().get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick2");

        DoubleClickPage doubleClickPage = new DoubleClickPage();

        doubleClickPage.acceptCookies.click();


        //2. Switch to iframe.

        Driver.getDriver().switchTo().frame("iframeResult");



        //3. Double click on the text “Double-click me to change my text color.”
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(doubleClickPage.textDoubleClick).doubleClick().perform();




        //4. Assert: Text’s “style” attribute value contains “red”.

        String expectedColor = "red";
        String actualColor = doubleClickPage.textDoubleClick.getAttribute("style");

        Assert.assertTrue(actualColor.contains(expectedColor));


    }
}
