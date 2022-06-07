package com.cydeo.myWork;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public class CydeoOpening {

    @Test
    public void cydeo(){

        Driver.getDriver().get("https://learn.cybertekschool.com/courses/672");

        Driver.getDriver().findElement(By.xpath("//input[@type='email']")).sendKeys("emrecorek@gmail.com" + Keys.ENTER);

        Driver.getDriver().findElement(By.xpath("//input[@type='password']")).sendKeys("4868008Ee" + Keys.ENTER);




    }
}
