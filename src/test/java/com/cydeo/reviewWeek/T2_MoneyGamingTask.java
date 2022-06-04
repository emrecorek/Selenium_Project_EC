package com.cydeo.reviewWeek;

import com.cydeo.utilities.Driver;
import com.cydeo.utilities.HandleWait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class T2_MoneyGamingTask {

    static WebDriver driver;
    @Test
    public void moneyGamingTask(){
        driver = Driver.getDriver();

        //1. Navigate to: https://moneygaming.qa.gameaccount.com/
        driver.get("https://moneygaming.qa.gameaccount.com/");

        //2. Click the JOIN NOW button to open the registration page
        WebElement joinNowButton = driver.findElement(By.xpath("//a[@href='/sign-up.shtml']"));
        joinNowButton.click();

        //3. Select a title value from the dropdown
        Select selectTitle = new Select(driver.findElement(By.xpath("//select[@id='title']")));
        selectTitle.selectByIndex(1);

        //4. Enter your first name and surname in the form
        WebElement firstNameBox = driver.findElement(By.xpath("//input[@name='map(firstName)']"));
        firstNameBox.sendKeys("Monte");

        WebElement surNameBox = driver.findElement(By.xpath("//input[@name='map(lastName)']"));
        surNameBox.sendKeys("Kristo");

        //5. Check the tick box with text 'I accept the Terms and Conditions and certify that I am over the age of 18.'
        WebElement acceptTickBox = driver.findElement(By.xpath("//div[@class='validation']"));

        String actualTickBoxText = acceptTickBox.getText();
        String expectedTickBoxText = "I accept the Terms and Conditions and certify that I am over the age of 18.";

        Assert.assertEquals(actualTickBoxText, expectedTickBoxText);

        //6. Submit the form by clicking the JOIN NOW button
        WebElement joinNowButton2 = driver.findElement(By.xpath("//input[@id='form']"));
        joinNowButton2.click();

        //7. Validate that a validation message with text ‘ This field is required’ appears under the date of birth box
        WebElement message = driver.findElement(By.xpath("//label[@for='dob']"));

        String actualMessage = message.getText();
        String expectedMessage = "This field is required";

        Assert.assertEquals(actualMessage, expectedMessage);
    }

    @AfterMethod
    public void closeBrowser() {
        HandleWait.staticWait(3);
        //driver.close();
    }
}
