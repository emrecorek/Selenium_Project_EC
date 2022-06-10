package com.cydeo.tests.day10_Uploads;

import com.cydeo.utilities.Driver;
import com.cydeo.utilities.HandleWait;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class T7_JavascriptExecutor {

    @Test
    public void task7(){

        //TC #7: Scroll using JavascriptExecutor
        //1- Open a chrome browser
        //2- Go to: https://practice.cydeo.com/large
        Driver.getDriver().get("https://practice.cydeo.com/large");

        WebElement home = Driver.getDriver().findElement(By.partialLinkText("Hom"));
        WebElement cydeo = Driver.getDriver().findElement(By.partialLinkText("CYDE"));

        //3- Scroll down to “Cydeo” link
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();

        js.executeScript("arguments[0].scrollIntoView(true)", cydeo);

        HandleWait.staticWait(3);


        //4- Scroll up to “Home” link

        js.executeScript("arguments[0].scrollIntoView(true)", home);

        //5- Use below provided JS method only
        //JavaScript method to use : arguments[0].scrollIntoView(true)
        //Note: You need to locate the links as web elements and pass them as
        //arguments into executeScript() method


    }
}
