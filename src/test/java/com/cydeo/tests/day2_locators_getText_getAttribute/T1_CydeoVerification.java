package com.cydeo.tests.day2_locators_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class T1_CydeoVerification {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();


        driver.navigate().to("https://google.com");


        driver.get("https://practice.cydeo.com");



        System.out.println(driver.getCurrentUrl());

        System.out.println(driver.getCurrentUrl().contains("cydeo"));


        String expectedTitle = "Practice";
        String actualTitle = driver.getTitle();

        if (actualTitle.equals(expectedTitle)){
            System.out.println("Title verification passed!..");
        }else {
            System.out.println("Title verification failed!..");
        }

        System.out.println(driver.getTitle());

        System.out.println(driver.getTitle().contains("Practice"));




        driver.navigate().back();


        Thread.sleep(5000);
        driver.close();





    }
}
