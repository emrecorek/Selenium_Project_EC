package com.cydeo.tests.day4_finfElements;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T1_PracticeCydeo {

    public static void main(String[] args) throws NoSuchElementException {

        //1. Open Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");

        //2. Go to https://practice.cydeo.com/forgot_password
        driver.get("https://practice.cydeo.com/forgot_password");

        //3. Locate all the WebElements on the page using XPATH and/or CSS
        //locator only (total of 6)
        //a. “Home” link

        WebElement home = driver.findElement(By.cssSelector("a[cls='nav-link']"));
        WebElement home2 = driver.findElement(By.cssSelector("a.nav-link"));
        WebElement home3 = driver.findElement(By.cssSelector("a[href='/']"));
        WebElement home4 = driver.findElement(By.xpath("//a[@href='/']"));
        //home.click();


        //b. “Forgot password” header
         WebElement forgotPassword = driver.findElement(By.cssSelector("h2"));
         WebElement forgotPassword1 = driver.findElement(By.cssSelector("div>h2"));



        //c. “E-mail” text
        System.out.println(driver.findElement(By.cssSelector("label[for='email']")).getText());
       // System.out.println(driver.findElement(By.cssSelector("//label[.='E-mail']")).getText());


        System.out.println("home.isDisplayed() = " + home.isDisplayed());

        //d. E-mail input box
       // driver.findElement(By.xpath()



        //e. “Retrieve password” button
        //f. “Powered by Cydeo text
        //4. Verify all web elements are displayed.


    }
}

/*
TC #1: XPATH and cssSelector Practices
1. Open Chrome browser
2. Go to https://practice.cydeo.com/forgot_password
3. Locate all the WebElements on the page using XPATH and/or CSS
locator only (total of 6)
a. “Home” link
b. “Forgot password” header
c. “E-mail” text
d. E-mail input box
e. “Retrieve password” button
f. “Powered by Cydeo text
4. Verify all web elements are displayed.
First solve the task with using cssSelector only. Try to create 2 different
cssSelector if possible
Then solve the task using XPATH only. Try to create 2 different
XPATH locator if possible
 */
