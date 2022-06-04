package com.cydeo.myWork;

import com.cydeo.utilities.HandleWait;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;

public class DeleteAllCookies {

    public static void main(String[] args) {


        WebDriver driver = WebDriverFactory.getDriver("chrome");

        HandleWait.staticWait(5);

       // driver.get("https://yahoo.com");

        System.out.println();


    }
}
