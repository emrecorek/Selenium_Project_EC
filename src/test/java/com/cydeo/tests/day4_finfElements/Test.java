package com.cydeo.tests.day4_finfElements;

import com.cydeo.tests.day5_DynamicWebElements.T3_RadioButton;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;

public class Test {

    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        T3_RadioButton.clickAndVerifyRadioButton(driver, "sport", "football");
        T3_RadioButton.clickAndVerifyRadioButton(driver, "color", "yellow");
        System.out.println();


    }
}
