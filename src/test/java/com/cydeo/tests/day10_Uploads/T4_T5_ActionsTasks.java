package com.cydeo.tests.day10_Uploads;

import com.cydeo.utilities.Driver;
import com.cydeo.utilities.HandleWait;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import javax.swing.*;

public class T4_T5_ActionsTasks {

    //TC #4: Scroll practice
    @Test
    public void task4(){

        //1- Open a chrome browser
        //2- Go to: https://practice.cydeo.com/
        Driver.getDriver().get("https://practice.cydeo.com/");

        //3- Scroll down to “Powered by CYDEO”
        Actions actions = new Actions(Driver.getDriver());

        WebElement element = Driver.getDriver().findElement(By.xpath("//div[@style]"));



        //4- Scroll using Actions class “moveTo(element)” method
        actions.moveToElement(element).perform();

        HandleWait.staticWait(2);

        //TC #5: Scroll practice 2
        //1- Continue from where the Task 4 is left in the same test.
        //2- Scroll back up to “Home” link using PageUP

        actions.sendKeys(Keys.PAGE_UP, Keys.PAGE_UP).perform();
        actions.sendKeys(Keys.PAGE_UP, Keys.PAGE_UP).perform();




    }
}
