package com.cydeo.tests.day4_finfElements;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class T3_1 {

    static WebDriver driver;
    static WebElement button;

    public static void main(String[] args) {

        //TC #6:  XPATH LOCATOR practice
        //1. Open Chrome browser

        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        //2. Go to http://practice.cydeo.com/multiple_buttons
        driver.get("http://practice.cydeo.com/multiple_buttons");

        //3. Click on Button 1
        String buttonText = "Button 1";
        getButton(buttonText);
       // WebElement button = driver.findElement(By.xpath("//button[.='"+buttonText+"']"));
       //button.click();

        //4. Verify text displayed is as expected:
        //Expected: “Clicked on button one!”

        if ((driver.findElement(By.xpath("//p[@id='result']")).getText()).equals("Clicked on button one!")){
            System.out.println("Verification PASSED!");
        }else {
            System.out.println("Verification FAİLED!");
        }

       /* if (resultText().equals("Clicked on button one!")){
            System.out.println("Verification PASSED!");
        }else {
            System.out.println("Verification FAİLED!");
        }*/



    }

    public static void getButton(String buttonText){
        button = driver.findElement(By.xpath("//button[.='"+buttonText+"']"));
        button.click();
    }
    public static String resultText(){
        return driver.findElement(By.xpath("//p[@id='result']")).getText();
    }

}