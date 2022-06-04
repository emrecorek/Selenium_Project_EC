package com.cydeo.tests.day2_locators_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class T5_RegistrationForm {

    public static void main(String[] args) throws InterruptedException {

        //Open write
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        //Go to
        driver.get("https://practice.cydeo.com/registration_form");

        //Verify header text: "Registration Form"
        WebElement headerText = driver.findElement(By.tagName("h2"));

        String expectedHeader = "Registration Form";
        String actualHeader = headerText.getText();

        System.out.println(actualHeader);

        if (actualHeader.equals(expectedHeader)){
            System.out.println("Header text verification Passed");
        }else {
            System.out.println("Header text verification Failed");
        }

        //Locate first name input box
        WebElement inputbox = driver.findElement(By.className("form-control"));
        String placeholder = inputbox.getAttribute("placeholder");
        String expectedValue = "first name";

        //Verify placeholder attribute's value
        if (placeholder.equals(expectedValue)){
            System.out.println("Verification PASSED");
        }else {
            System.out.println("Verification FAILED");
        }



        Thread.sleep(5000);

        driver.close();


    }
}
