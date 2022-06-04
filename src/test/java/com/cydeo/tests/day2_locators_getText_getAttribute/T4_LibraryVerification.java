package com.cydeo.tests.day2_locators_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class T4_LibraryVerification {

    public static void main(String[] args) {

        //Open Chrome
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        //Go to http://library2.cybertekschool.com/login.html
        driver.get("http://library2.cybertekschool.com/login.html");

        //Enter username
        WebElement userName = driver.findElement(By.className("form-control"));
        userName.sendKeys("emrecor@gmail.com");

        //Enter password
        WebElement password = driver.findElement(By.id("inputPassword"));
        password.sendKeys("12456");

        //sign in
        WebElement signIn = driver.findElement(By.tagName("button"));
        signIn.click();



    }
}

/*
TC #4: Library verifications
1. Open Chrome browser
2. Go to http://library2.cybertekschool.com/login.html
3. Enter username: “incorrect@email.com”
4. Enter password: “incorrect password”
5. Verify: visually “Sorry, Wrong Email or Password”
displayed
PS: Locate username input box using “className” locator
Locate password input box using “id” locator
Locate Sign in button using “tagName” locator
 */
