package com.cydeo.reviewWeek;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WebAppSecurity {

    WebDriver driver;

    @BeforeMethod
    public void build_up(){
        driver = Driver.getDriver();

        driver.get("http://zero.webappsecurity.com/");

        driver.findElement(By.xpath("//button[@id='signin_button']")).click();
    }

    @AfterMethod
    public void tear_down(){

        Driver.closeDriver();
    }


    @Test
    public void loginWithValidCredentials(){


        WebElement loginBox = driver.findElement(By.xpath("//input[@id='user_login']"));
        loginBox.sendKeys("username");

        WebElement passwordBox = driver.findElement(By.xpath("//input[@id='user_password']"));
        passwordBox.sendKeys("password");

        driver.findElement(By.xpath("//input[@value='Sign in']")).click();


        Assert.assertTrue(driver.getTitle().contains("summary"));


    }
    @Test
    public void loginWithInvalidCredentials(){

        WebElement loginBox = driver.findElement(By.xpath("//input[@id='user_login']"));
        loginBox.sendKeys("fakeName");

        WebElement passwordBox = driver.findElement(By.xpath("//input[@id='user_password']"));
        passwordBox.sendKeys("fakePassword");

        driver.findElement(By.xpath("//input[@value='Sign in']")).click();

        String expectedWarning = "Login and/or password are wrong.";
        String actualWarning = driver.findElement(By.xpath("//div[@class='alert alert-error']")).getText();

        Assert.assertEquals(actualWarning,expectedWarning);

    }

    @Test
    public void loginWithoutCredentials(){

        driver.findElement(By.xpath("//input[@value='Sign in']")).click();

        String expectedWarning = "Login and/or password are wrong.";
        String actualWarning = driver.findElement(By.xpath("//div[@class='alert alert-error']")).getText();

        Assert.assertEquals(actualWarning,expectedWarning);

    }
    @Test
    public void accountSummary(){

        WebElement loginBox = driver.findElement(By.xpath("//input[@id='user_login']"));
        loginBox.sendKeys("username");

        WebElement passwordBox = driver.findElement(By.xpath("//input[@id='user_password']"));
        passwordBox.sendKeys("password");

        driver.findElement(By.xpath("//input[@value='Sign in']")).click();

        driver.navigate().back();

        driver.findElement(By.xpath("//a[@id='online-banking']")).click();

        driver.findElement(By.xpath("//span[@id='account_summary_link']")).click();

        String expectedSummaryTitle ="Zero - Account Summary";
        String actualSummaryTitle = driver.getTitle();

        Assert.assertEquals(actualSummaryTitle,expectedSummaryTitle);

        for (int i = 1; i <= 4; i++) {
            WebElement title = driver.findElement(By.xpath("(//h2[@class='board-header'])["+i+"]"));
            String expectedTitle = "";
            String actualTitle="";
            switch (title.getText()){
                case "Cash Accounts":
                    expectedTitle = "Cash Accounts";
                    actualTitle = title.getText();
                    Assert.assertEquals(actualTitle,expectedTitle);
                    break;
                case "Investment Accounts":
                    expectedTitle = "Investment Accounts";
                    actualTitle = title.getText();
                    Assert.assertEquals(actualTitle,expectedTitle);
                    break;
                case "Credit Accounts":
                    expectedTitle = "Credit Accounts";
                    actualTitle = title.getText();
                    Assert.assertEquals(actualTitle,expectedTitle);
                    break;
                case "Loan Accounts":
                    expectedTitle = "Loan Accounts";
                    actualTitle = title.getText();
                    Assert.assertEquals(actualTitle,expectedTitle);
                    break;
            }

        }

    }

    @Test
    public void accountActivity(){

        WebElement loginBox = driver.findElement(By.xpath("//input[@id='user_login']"));
        loginBox.sendKeys("username");

        WebElement passwordBox = driver.findElement(By.xpath("//input[@id='user_password']"));
        passwordBox.sendKeys("password");

        driver.findElement(By.xpath("//input[@value='Sign in']")).click();

        driver.navigate().back();

        driver.findElement(By.xpath("//a[@id='online-banking']")).click();

        driver.findElement(By.xpath("//span[@id='account_activity_link']")).click();

        String expectedSummaryTitle ="Zero - Account Activity";
        String actualSummaryTitle = driver.getTitle();

        Assert.assertEquals(actualSummaryTitle,expectedSummaryTitle);

        Select select = new Select(driver.findElement(By.xpath("//select[@id='aa_accountId']")));
        String actualDefaultOption = select.getFirstSelectedOption().getText();
        String expectedDefaultOption = "Savings";

        Assert.assertEquals(actualDefaultOption,expectedDefaultOption);

        List<WebElement> allSelectedOptions = select.getOptions();
        List<String> stringListOfOptions = new ArrayList<>();

        for (WebElement selectedOption : allSelectedOptions) {
            stringListOfOptions.add(selectedOption.getText());
        }

        Assert.assertTrue(stringListOfOptions.containsAll((Arrays.asList("Savings", "Brokerage", "Checking", "Loan", "Credit Card"))));
        List<String> columnNames = new ArrayList<>();
        for (int i = 1; i <=4 ; i++) {
            columnNames.add(driver.findElement(By.xpath("(//table[@class='table table-condensed table-hover']//tr//th)["+i+"]")).getText());
        }

        Assert.assertTrue(columnNames.containsAll(Arrays.asList("Date", "Deposit", "Withdrawal","Description")));
    }

}