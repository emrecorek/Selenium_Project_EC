package com.cydeo.tests.day10_Uploads;

import com.cydeo.utilities.Driver;
import com.cydeo.utilities.HandleWait;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

public class T6_JavascriptExecutor {

    @Test
    public void javascriptExecutor(){

        //TC #6: Scroll using JavascriptExecutor
        //1- Open a chrome browser
        //2- Go to: https://practice.cydeo.com/infinite_scroll
        Driver.getDriver().get("https://practice.cydeo.com/infinite_scroll");

        //((JavascriptExecutor)Driver.getDriver()).executeScript("");

        //3- Use below JavaScript method and scroll
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();


        //a. 750 pixels down 10 times.

        for (int i = 0; i < 5; i++) {
            HandleWait.staticWait(1);
            js.executeScript("window.scrollBy(0,750)");
        }

        //b. 750 pixels up 10 times
        for (int i = 0; i < 5; i++) {
            HandleWait.staticWait(1);
            js.executeScript("window.scrollBy(0,-750)");
        }


        System.out.println(Driver.getDriver().getTitle());


        //JavaScript method to use : window.scrollBy(0,0)






    }
}
