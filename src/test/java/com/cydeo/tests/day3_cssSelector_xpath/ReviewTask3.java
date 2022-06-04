package com.cydeo.tests.day3_cssSelector_xpath;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;

public class ReviewTask3 {

    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        //You have to implement the following Web automated checks over our DEMO ONLINE SHOP: https://www.demoblaze.com/index.html
        driver.get("https://www.demoblaze.com/index.html");



        //    • Customer navigation through product categories: Phones, Laptops and Monitors
        //    Navigate to "Laptop" → "Sony vaio i5" and verify the price is 790 dollars

    }
}
