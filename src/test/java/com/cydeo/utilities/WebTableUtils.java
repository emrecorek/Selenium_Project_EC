package com.cydeo.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class WebTableUtils {

    public static String returnOrderDate(WebDriver driver, String customerName){

            return driver.findElement(By.xpath("//td[.='" + customerName + "']/following-sibling::td[3]")).getText();

        }

    public static void orderVerify(WebDriver driver, String customerName, String expectedOrderDate){

        Assert.assertEquals(driver.findElement(By.xpath("//td[.='" + customerName + "']/following-sibling::td[3]")).getText(), expectedOrderDate);

    }

    public static void getTableGetMail(WebDriver driver, String tableNum, String firstName){

        driver.get("https://practice.cydeo.com/tables");

        System.out.println(driver.findElement(By.xpath("(//table)[" + tableNum + "]//td[.='" + firstName + "']/following-sibling::td[1]")).getText());

    }


    }
