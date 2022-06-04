package com.cydeo.tests.day5_DynamicWebElements;

import com.cydeo.utilities.HandleWait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class T3_RadioButton {

    public static void clickAndVerifyRadioButton(WebDriver driver, String nameAtt, String idAtt){

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://practice.cydeo.com/radio_buttons");

        HandleWait.staticWait(1);

        WebElement radioButton = driver.findElement(By.xpath("//input[@name='" + nameAtt + "']" + "[@id='" + idAtt + "']"));

        radioButton.click();

        System.out.println(radioButton.getAttribute("id") + " radio button is selected: " + radioButton.isSelected());

    }
}

/*
TC #3: Utility method task for (continuation of Task2)
1. Open Chrome browser
2. Go to https://practice.cydeo.com/radio_buttons
3. Click to “Hockey” radio button
4. Verify “Hockey” radio button is selected after clicking.
USE XPATH LOCATOR FOR ALL WEBELEMENT LOCATORS
Create a utility method to handle above logic.
Method name: clickAndVerifyRadioButton
Return type: void or boolean
Method args:
1. WebDriver
2. Name attribute as String (for providing which group of radio buttons)
3. Id attribute as String (for providing which radio button to be clicked)
Method should loop through the given group of radio buttons. When it finds the
matching option, it should click and verify option is Selected.
Print out verification: true
 */