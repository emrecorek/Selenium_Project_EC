package com.cydeo.myWork;

import com.cydeo.utilities.Driver;
import com.cydeo.utilities.HandleWait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class YoutubeTask {

    static WebDriver driver;

    @Test
    public void youtubeSearch(){

        driver = Driver.getDriver();

        driver.get("https://youtube.com");

        //click accept
        WebElement accept = driver.findElement(By.xpath("//yt-formatted-string[.='Tümünü kabul et']"));
        accept.click();

        HandleWait.staticWait(5);

        WebElement searchInput = driver.findElement(By.xpath("//div[@id='thumbnail-container']"));

        System.out.println(searchInput.isDisplayed());

       searchInput.click();


    }
}
