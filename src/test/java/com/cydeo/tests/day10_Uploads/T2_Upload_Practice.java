package com.cydeo.tests.day10_Uploads;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T2_Upload_Practice {

    @Test
    public void upload_practice(){

        //go to website
        Driver.getDriver().get("https://practice.cydeo.com/upload");

        //path of file to upload
        String path = "C:\\Users\\emrec\\Desktop\\Java SDET E8\\userPicture.png";

        //click method doesn't work in this situation
        //Driver.getDriver().findElement(By.id("file-upload")).click();

        //Upload file with sendKeys() method
        Driver.getDriver().findElement(By.id("file-upload")).sendKeys(path);

        //Click upload button
        Driver.getDriver().findElement(By.id("file-submit")).click();

        //Assert

        String expectedFileName = "";
        String actualFileName = Driver.getDriver().findElement(By.id("uploaded-files")).getText();

        Assert.assertEquals(expectedFileName,actualFileName);

        //this way didn't work. ıt should be find header element "file upload".



    }
}
