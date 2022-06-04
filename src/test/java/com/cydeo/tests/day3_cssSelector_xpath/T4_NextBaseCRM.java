package com.cydeo.tests.day3_cssSelector_xpath;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T4_NextBaseCRM {

    public static void main(String[] args) {

        //1- Open a chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");

        //2- Go to: https://login1.nextbasecrm.com/?forgot_password=yes
        driver.get("https://login1.nextbasecrm.com/?forgot_password=yes");


        //3- Verify “Reset password” button text is as expected:
       // WebElement resetPasswordButton = driver.findElement(By.cssSelector(".login-btn"));
        WebElement resetPasswordButton = driver.findElement(By.cssSelector("button[value='Reset password']"));

        String expectedButtonText = "Reset password";
        String actualButtonText = resetPasswordButton.getAttribute("value");

        if (actualButtonText.equals(expectedButtonText)){
            System.out.println("Button text verification PASSED");
        }else {
            System.out.println("actualButtonText = " + actualButtonText);
            System.out.println("expectedButtonText = " + expectedButtonText);
            System.out.println("Button text verification FAILED");
        }

        driver.close();





    }
}
