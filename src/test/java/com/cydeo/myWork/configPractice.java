package com.cydeo.myWork;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class configPractice {

    //TC #4: Google search

    //    1- Open a chrome browser
    @Test
    public void configPractice() throws IOException {

       // 2- Go to: https://google.com

        Properties properties = new Properties();

        FileInputStream file = new FileInputStream("config.properties");

        properties.load(file);

        file.close();

        Driver.getDriver().get(properties.getProperty("url"));

        Driver.getDriver().findElement(By.id("W0wltc")).click();




       // 3- Write “apple” in search box
        Driver.getDriver().findElement(By.xpath("//input[@name='q']")).sendKeys( properties.getProperty("searchKeyword") + Keys.ENTER);

        //4- Verify title:
        //Expected: apple - Google Search

    }





}

/*

Use `configuration.properties` for the following:


1. The browser type
2. The URL
3. The search keyword
4. Make title verification dynamic. If search value changes, title
assertion should not fail.
 */