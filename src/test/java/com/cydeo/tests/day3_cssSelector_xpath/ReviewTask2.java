package com.cydeo.tests.day3_cssSelector_xpath;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ReviewTask2 {

    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        //- Go to:  http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");


        //- Verify title equals: String expectedTitle = "Web Orders Login"
        String actualTitle = driver.getTitle();
        String expectedTitle = "Web Orders Login";

        if (actualTitle.equals(expectedTitle)){
            System.out.println("Title verification PASSED");
        }else {
            System.out.println("Title verification FAILED");
        }

        //- Enter username: Tester
        WebElement username = driver.findElement(By.name("ctl00$MainContent$username"));
        username.sendKeys("Tester");

        //- Enter password: test
        WebElement password = driver.findElement(By.name("ctl00$MainContent$password"));
        password.sendKeys("test");


        //- Click “Sign In” button
        WebElement login = driver.findElement(By.name("ctl00$MainContent$login_button"));
        login.click();

        //- Verify title equals: String expectedHomePageTitle = "Web Orders"
        String actualHomePageTitle = driver.getTitle();
        String expectedHomePageTitle = "Web Orders";

        if (actualHomePageTitle.equals(expectedHomePageTitle)){
            System.out.println("Home page title verification PASSED");
        }else {
            System.out.println("Home page title verification FAILED");
        }


       // driver.close();
    }
}
