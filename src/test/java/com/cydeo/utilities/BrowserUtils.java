package com.cydeo.utilities;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class BrowserUtils {

    //Switch window and verify
    public static void switchWindowAndVerify(WebDriver driver, String expectedInUrl, String expectedTitle){

        Set<String> windowHandles = driver.getWindowHandles();

        for (String each : windowHandles) {

            driver.switchTo().window(each);

            if (driver.getCurrentUrl().contains(expectedInUrl)){
                break;
            }
        }

        Assert.assertTrue(driver.getTitle().contains(expectedTitle));
    }


    public static void setupBrowser(WebDriver driver){
        //1. Open browser
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }


    //Title verification
    public static void verifyTitle(WebDriver driver, String expectedTitle){

        Assert.assertEquals(driver.getTitle(), expectedTitle);

    }

}
