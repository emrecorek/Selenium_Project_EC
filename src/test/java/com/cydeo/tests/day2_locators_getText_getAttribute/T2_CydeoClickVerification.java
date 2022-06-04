package com.cydeo.tests.day2_locators_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class T2_CydeoClickVerification {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();

        //Open a chrome browser
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        //Go to https://practice.cydeo.com
        driver.get("https://practice.cydeo.com");

        Thread.sleep(5000);


        //Find element: A/B Testing


        WebElement testing = driver.findElement(By.linkText("A/B Testing"));
        //WebElement testing = driver.findElement(By.partialLinkText(" Testing"));

        //driver.findElement(By.linkText("A/B Testing")).click();



        //click
        testing.click();


        //Verify title
        String expectedTitle = "No A/B Test";
        String actualTitle = driver.getTitle();

        Thread.sleep(2000);


        if (actualTitle.equals(expectedTitle)){
            System.out.println("Title verification PASSED");
        }else{
            System.out.println("Title verification FAILED");
        }


        //Go back
        driver.navigate().back();


        //Verify title
        expectedTitle = "Practice";
        actualTitle = driver.getTitle();

        if (actualTitle.equals(expectedTitle)){
            System.out.println("Verification title PASSED!..");
        }else {
            System.out.println("Verification title FAILED!..");
        }

        Thread.sleep(5000);
       // driver.close();






    }
}
