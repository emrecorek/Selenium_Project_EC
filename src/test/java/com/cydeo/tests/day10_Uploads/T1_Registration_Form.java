package com.cydeo.tests.day10_Uploads;

import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Locale;
import java.util.Properties;

public class T1_Registration_Form {

    @Test
    public void registration_form_test(){

        //1. Open browser
        //2. Go to website: https://practice.cydeo.com/registration_form
        Driver.getDriver().get(ConfigurationReader.getProperty("registration.form.url"));

        Faker faker = new Faker();


        //3. Enter first name
        //4. Enter last name
        //5. Enter username
        //6. Enter email address
        //7. Enter password
        //8. Enter phone number
        Driver.getDriver().findElement(By.xpath("//input[@name='firstname']")).sendKeys(faker.name().firstName() + Keys.TAB
                + faker.name().lastName() + Keys.TAB + faker.name().username().replace(".","") + Keys.TAB + faker.bothify("?????????##")
                + "@gmail.com" + Keys.TAB + faker.bothify("???###???#") + Keys.TAB + faker.numerify("505-###-####"));

        //9. Select a gender from radio buttons
        Driver.getDriver().findElement(By.xpath("//input[@value='male']")).click();

        //10. Enter date of birth
        Driver.getDriver().findElement(By.name("birthday")).sendKeys("05/17/1985");

        //11. Select Department/Office
        new Select(Driver.getDriver().findElement(By.xpath("//select"))).selectByIndex(faker.number().numberBetween(1,9));

        //12. Select Job Title
        new Select(Driver.getDriver().findElement(By.name("job_title"))).selectByVisibleText("SDET");

        //13. Select programming language from checkboxes
        Driver.getDriver().findElement(By.id("inlineCheckbox2")).click();

        //14. Click to sign up button
        Driver.getDriver().findElement(By.id("wooden_spoon")).click();


        //15. Verify success message “You’ve successfully completed registration.” is displayed.
        String expectedMessage = "You've successfully completed registration!";
        String actualMessage = Driver.getDriver().findElement(By.tagName("p")).getText();

        System.out.println(actualMessage);

        Assert.assertEquals(actualMessage, expectedMessage);




        //Note:
        //1. Use new Driver utility class and method
        //2. User JavaFaker when possible
        //3. User ConfigurationReader when it makes sense



    }
}


