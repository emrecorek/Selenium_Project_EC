package com.cydeo.tests.day3_cssSelector_xpath;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T3_NextBaseCRM {

    public static void main(String[] args) {


        //1- Open a chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");


        //2- Go to: https://login1.nextbasecrm.com/
        driver.get("https://login1.nextbasecrm.com/");



        //3- Verify “Log in” button text is as expected: Expected: Log In
        WebElement loginButton = driver.findElement(By.cssSelector(".login-btn"));
        System.out.println(loginButton.getAttribute("value"));

        String expectedLoginButtonText = "Log In";
        String actualLoginButtonText = loginButton.getAttribute("value");

        if (actualLoginButtonText.equals(expectedLoginButtonText)){
            System.out.println("“Log in” button text verification PASSED");
        }else {
            System.out.println("expectedLoginButtonText = " + expectedLoginButtonText);
            System.out.println("actualLoginButtonText = " + actualLoginButtonText);
            System.out.println("“Log in” button text verification FAILED");
        }

        driver.close();
    }
}
