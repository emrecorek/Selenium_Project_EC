package com.cydeo.myWork;

import com.cydeo.utilities.HandleWait;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Task1_14_05_2022 {

    WebDriver driver;

    @BeforeMethod
    public void setupMethod(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //1.    Go to http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");

        //Give Username: "Tester"
        WebElement usernameSection = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_username']"));
        usernameSection.sendKeys("Tester");

        //Give password: "test"
        WebElement passwordSection = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_password']"));
        passwordSection.sendKeys("test"+ Keys.ENTER);

    }

    @AfterMethod
    public void closeBrowser(){

        HandleWait.staticWait(3);
        //driver.close();

    }

    @Test
    public void TC1(){

        //Click: "Check All"
        WebElement checkAllButton = driver.findElement(By.xpath("//a[@id='ctl00_MainContent_btnCheckAll']"));
        checkAllButton.click();

        //Verify all the checkboxes are checked
        List<WebElement> checkBoxes = driver.findElements(By.xpath("//input[@type='checkbox']"));

        boolean allChecked = true;

        for (WebElement checkBox : checkBoxes) {
            if (!checkBox.isSelected()){
                allChecked = false;
            }
        }

        Assert.assertTrue(allChecked, "Unchecked verification failed");

        //Click on uncheck all button
        WebElement uncheckAllButton = driver.findElement(By.xpath("//a[@id='ctl00_MainContent_btnUncheckAll']"));
        uncheckAllButton.click();

        //Verify all the checkboxes are unchecked
        boolean allUnchecked = true;

        checkBoxes = driver.findElements(By.xpath("//input[@type='checkbox']"));
        for (WebElement checkBox : checkBoxes) {
            if (checkBox.isSelected()){
                allUnchecked = false;
            }
        }

        Assert.assertTrue(allUnchecked, "Unchecked verification failed");

    }

    @Test
    public void TC2(){

        //Select one of the checkbox
        WebElement boxSteveJohns = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_orderGrid_ctl04_OrderSelector']"));
        boxSteveJohns.click();

        //delete one person
        WebElement deleteSelected = driver.findElement(By.xpath("//input[@type='submit']"));
        deleteSelected.click();

        //4.    Then verify that deleted item is no longer exists
        boolean b = boxSteveJohns.isEnabled();

        System.out.println(b);


    }


}

