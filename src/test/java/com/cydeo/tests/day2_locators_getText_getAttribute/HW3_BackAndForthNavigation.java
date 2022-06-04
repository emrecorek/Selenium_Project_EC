package com.cydeo.tests.day2_locators_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HW3_BackAndForthNavigation {

    public static void main(String[] args) {

        //Open chrome
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        //Go to https://www.google.com
        driver.get("https://google.com");

        //Agree button
        WebElement agree = driver.findElement(By.id("L2AGLb"));
        agree.click();

        //Click to Gmail
        WebElement gmail = driver.findElement(By.linkText("Gmail"));
        gmail.click();

        //Verify Title Contains: "Gmail"
        String actualTitle = driver.getTitle();
        String expectedTitle = "Gmail";

        if (actualTitle.contains(expectedTitle)){
            System.out.println("Title verification Gmail page PASSED");
        } else {
            System.out.println("Title verification Gmail page FAILED");
        }

        System.out.println("\n********************************\n");

        //Go back
        driver.navigate().back();

        //Verifiy title equals: "Google"
        String actualTitle2 = driver.getTitle();
        String expectedTitle2 = "Google";

        if (actualTitle2.equals(expectedTitle2)){
            System.out.println("Title verification Google page PASSED");
        } else {
            System.out.println("Title verification Google page FAILED");
        }

        driver.close();
    }
}

/*
TC #3: Back and forth navigation
1- Open a chrome browser
2- Go to: https://google.com
3- Click to Gmail from top right.
4- Verify title contains:
Expected: Gmail
5- Go back to Google by using the .back();
6- Verify title equals:
Expected: Google
 */