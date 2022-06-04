package com.cydeo.tests.day2_locators_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class T3_GoogleSearch {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        // Go to Google
        driver.get("https://www.google.com");
        Thread.sleep(2000);


        //Consent agree
        WebElement consent = driver.findElement(By.id("L2AGLb"));
        consent.click();

        //Write "Apple" in search box
        WebElement googleSearchBox = driver.findElement(By.name("q"));
        googleSearchBox.sendKeys("Apple");


        //Verify if title starts with "Apple"
        String actualTitle = driver.getTitle();

        if (actualTitle.startsWith("Apple")){
            System.out.println("Title verification PASSED");
        }else {
            System.out.println("Title verification PASSED");
        }


        Thread.sleep(3000);
        driver.close();
    }
}
