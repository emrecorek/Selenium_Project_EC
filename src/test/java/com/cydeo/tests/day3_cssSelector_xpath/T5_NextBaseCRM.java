package com.cydeo.tests.day3_cssSelector_xpath;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T5_NextBaseCRM {

    public static void main(String[] args) {

        //1- Open a chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");

        //2- Go to: https://login1.nextbasecrm.com/?forgot_password=yes
        driver.get("https://login1.nextbasecrm.com/?forgot_password=yes");


        //3- Enter incorrect username into login box:
        WebElement username = driver.findElement(By.cssSelector("input[maxlength='50']"));
        username.sendKeys("punisher");


        //4- Click to `Reset password` button
        WebElement resetPasswordButton = driver.findElement(By.cssSelector(".login-btn"));
        resetPasswordButton.click();


        //5- Verify “error” label is as expected: Expected: Login or E-mail not found
        WebElement errorLabel = driver.findElement(By.cssSelector(".errortext"));

        String expectedErrorMessage = "Login or E-mail not found";
        String actualErrorMessage = errorLabel.getText();

       if (actualErrorMessage.equals(expectedErrorMessage)){
           System.out.println("Error message verification PASSED");
       }else {
           System.out.println("actualErrorMessage = " + actualErrorMessage);
           System.out.println("expectedErrorMessage = " + expectedErrorMessage);
           System.out.println("Error message verification FAILED");
       }



        //driver.close();

    }
}
