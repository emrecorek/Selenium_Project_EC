package com.cydeo.tests.day1_selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task1_YahooTitleVerification {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        //.get(url) method used for navigation to page


        driver.get("https://www.yahoo.com");

        Thread.sleep(3000);

        WebElement agreeButton=driver.findElement(By.name("agree"));
        agreeButton.click();

        Thread.sleep(2000);

       // agreeButton=driver.findElement(By.name("agree"));


        Thread.sleep(5000);


        String currentTitle = driver.getTitle();

        System.out.println(currentTitle);

        driver.close();

        if (currentTitle.equals("Yahoo France | Actualités, mail et recherche")){
            System.out.println("It works perfect!");
        }else{
            throw new RuntimeException("It should be written \"Yahoo!\"");
        }




    }
}
