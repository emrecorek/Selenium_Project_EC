package com.cydeo.myWork;

import com.cydeo.utilities.HandleWait;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class YoutubeSearch {

    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        //Open https://youtube.com
        driver.get("https://youtube.com");

        //click accept
        WebElement accept = driver.findElement(By.xpath("//yt-formatted-string[.='Tümünü kabul et']"));
        accept.click();

        //search "arkadaşım eşşek"
        //WebElement search = driver.findElement(By.cssSelector("form>div[id='container']"));
        WebElement search = driver.findElement(By.cssSelector("input[id='search']"));
        //search.click();

        HandleWait.staticWait(3);

        search.sendKeys("arkadaşım eşşek");


        // driver.close();


    }
}
