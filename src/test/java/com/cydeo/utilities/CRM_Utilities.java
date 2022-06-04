package com.cydeo.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CRM_Utilities {

    public static void crm_login(WebDriver driver){

        //3. Enter valid username
        WebElement userName = driver.findElement(By.xpath("//input[@type=\"text\"]"));
        userName.sendKeys("helpdesk1@cybertekschool.com");

        //4. Enter valid password
        WebElement password = driver.findElement(By.xpath("//input[@placeholder='Password']"));
        password.sendKeys("UserUser");

        //5. Click to `Log In` button
        WebElement loginButton = driver.findElement(By.xpath("//input[@type=\"submit\"]"));
        loginButton.click();

    }


    public static void crm_login(WebDriver driver, String userName, String password){

        //3. Enter valid username
        WebElement userNameElement = driver.findElement(By.xpath("//input[@type=\"text\"]"));
        userNameElement.sendKeys(userName);

        //4. Enter valid password
        WebElement passwordElement = driver.findElement(By.xpath("//input[@placeholder='Password']"));
        passwordElement.sendKeys(password);

        //5. Click to `Log In` button
        WebElement loginButton = driver.findElement(By.xpath("//input[@type=\"submit\"]"));
        loginButton.click();

    }




}
