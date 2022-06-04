package com.cydeo.tests.day2_locators_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HW1_EtsyTitleVerification {

    public static void main(String[] args) throws InterruptedException {

        System.out.println();
        //Open chrome
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        //Go to https://www.etsy.com
        driver.get("https://www.etsy.com");
        Thread.sleep(3000);

        //Click agree button
        WebElement acceptButton=driver.findElement(By.cssSelector("button[class='wt-btn wt-btn--filled wt-mb-xs-0']"));
        acceptButton.click();

        //Search wooden spoon
        WebElement searchBox = driver.findElement(By.name("search_query"));
        searchBox.sendKeys("wooden spoon" + Keys.ENTER);

        //Verify title
        String expectedTitle = "Wooden spoon | Etsy";
        String actualTitle = driver.getTitle();

        System.out.println(actualTitle);

        if (actualTitle.equals(expectedTitle)){
            System.out.println("Title verification PASSED");
        }else {
            System.out.println("Title verification FAILED");
        }

        driver.close();
    }
}

/*
TC #1: Etsy Title Verification
1. Open Chrome browser
2. Go to https://www.etsy.com
3. Search for “wooden spoon”
4. Verify title:
Expected: “Wooden spoon | Etsy”
 */
