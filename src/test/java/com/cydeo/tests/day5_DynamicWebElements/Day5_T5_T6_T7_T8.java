package com.cydeo.tests.day5_DynamicWebElements;

import com.cydeo.utilities.HandleWait;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Day5_T5_T6_T7_T8 {

    WebDriver driver;

    @BeforeMethod
    public void setupBrowser(){
        //1. Open Chrome browser
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //2. Go to https://practice.cydeo.com/dropdown
        driver.get("https://practice.cydeo.com/dropdown");

    }

    @AfterMethod
    public void closeBrowser(){
        HandleWait.staticWait(3);
        //driver.close();
    }


    //TC #5: Selecting state from State dropdown and verifying result
    @Test
    public void selectStateVerify(){

        Select stateDropdown = new Select(driver.findElement(By.xpath("//select[@id='state']")));

        //3. Select Illinois
        stateDropdown.selectByValue("IL");
        HandleWait.staticWait(2);

        //4. Select Virginia
        stateDropdown.selectByVisibleText("Virginia");
        HandleWait.staticWait(2);


        //5. Select California
        stateDropdown.selectByIndex(5);

        //6. Verify final selected option is California.
        String actualSelectedValue = stateDropdown.getFirstSelectedOption().getText();
        String expectedSelectedValue = "California";

        Assert.assertEquals(actualSelectedValue, expectedSelectedValue, "Selected value verification failed");

    }

    //TC #6: Selecting date on dropdown and verifying
    @Test
    public void selectDateVerify(){

        //Select “December 1st, 1923” and verify it is selected.

        //Select year
        Select yearDropdown = new Select(driver.findElement(By.xpath("//select[@id='year']")));
        yearDropdown.selectByVisibleText("1923");
        HandleWait.staticWait(1);

        //Verify selected year
        String actualYearValue = yearDropdown.getFirstSelectedOption().getText();
        String expectedYearValue = "1923";
        Assert.assertEquals(actualYearValue, expectedYearValue, "Year value verification failed");

        //Select month
        Select monthDropdown = new Select(driver.findElement(By.xpath("//select[@id='month']")));
        monthDropdown.selectByValue("11");
        HandleWait.staticWait(1);

        //Verify selected month
        String actualMonthValue = monthDropdown.getFirstSelectedOption().getText();
        String expectedMonthValue = "December";
        Assert.assertEquals(actualMonthValue, expectedMonthValue, "Month value verification failed");


        //Select day
        Select dayDropdown = new Select(driver.findElement(By.xpath("//select[@id='day']")));
        dayDropdown.selectByIndex(0);
        HandleWait.staticWait(1);

        //Verify selected day
        String actualDayValue = dayDropdown.getFirstSelectedOption().getText();
        String expectedDayValue = "1";
        Assert.assertEquals(actualDayValue, 15, "Day value verification failed");

    }

    //TC #7: Selecting value from non-select dropdown
    @Test
    public void nonSelectDropdown(){

        //3. Click to non-select dropdown
        WebElement nonSelectDropdown = driver.findElement(By.xpath("//a[@role]"));
        nonSelectDropdown.click();
        HandleWait.staticWait(2);

        //4. Select Facebook from dropdown
        WebElement facebook = driver.findElement(By.xpath("//a[@href='https://www.facebook.com/']"));
        facebook.click();
        HandleWait.staticWait(3);

        driver.findElement(By.xpath("(//button[@value='1'])[3]")).click();

        //5. Verify title is “Facebook - Log In or Sign Up”
        String actualTitle = driver.getTitle();
        String expectedTitle = "Facebook - Log In or Sign Up";

        Assert.assertEquals(actualTitle, expectedTitle, "Title verification failed");

    }

    //TC #8: Selecting value from multiple select dropdown
    @Test
    public void multipleSelectDropdown(){

        //3. Select all the options from multiple select dropdown.
        Select languages = new Select(driver.findElement(By.xpath("//select[@name]")));
        languages.selectByIndex(0);
        languages.selectByIndex(1);
        languages.selectByIndex(2);
        languages.selectByIndex(3);
        languages.selectByIndex(4);
        languages.selectByIndex(5);

        HandleWait.staticWait(3);

        //4. Print out all selected values.
        List<WebElement> languagesOptions = languages.getAllSelectedOptions();
        for (WebElement language : languagesOptions) {
            System.out.println(language.getText());
        }

        //5. Deselect all values.
        languages.deselectAll();
    }


    @Test
    public void nonSelect(){
        driver.get("https://practice.cydeo.com/dropdown");

        WebElement webSiteButton= driver.findElement(By.xpath("//a[@role]"));
        webSiteButton.click();

        HandleWait.staticWait(3);
        WebElement facebookButton=   driver.findElement(By.xpath("//a[@href='https://www.facebook.com/']"));

        facebookButton.click();

    }


}
