package com.cydeo.tests.day2_locators_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HW2_ZeroBankHeaderVerification {

    public static void main(String[] args) {

        //Open chrome
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        //Go to http://zero.webappsecurity.com/login.html
        driver.get("http://zero.webappsecurity.com/login.html");

        //Locate
        WebElement headerText = driver.findElement(By.tagName("h3"));

        //Verify header text
        String actualHeaderText = headerText.getText();
        String expectedHeaderText = "Log in to ZeroBank";

        if (actualHeaderText.equals(expectedHeaderText)) {
            System.out.println("Header text verification PASSED");
        } else {
            System.out.println("Header text verification FAILED");
        }

        driver.close();
    }
}

/*
TC #2: Zero Bank header verification
1. Open Chrome browser
2. Go to http://zero.webappsecurity.com/login.html
3. Verify header text
Expected: “Log in to ZeroBank”
 */
