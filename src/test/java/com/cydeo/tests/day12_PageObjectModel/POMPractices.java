package com.cydeo.tests.day12_PageObjectModel;

import com.cydeo.pages.LibraryLoginPage;
import com.cydeo.utilities.Driver;
import com.cydeo.utilities.HandleWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class POMPractices {

    LibraryLoginPage libraryLoginPage;

    @BeforeMethod
    public void setup(){

        Driver.getDriver().get("https://library1.cydeo.com");

        libraryLoginPage = new LibraryLoginPage();

    }

    @Test
    public void required_field_error_message_test(){

        //TC #1: Required field error message test
        //1- Open a chrome browser
        //2- Go to: https://library1.cydeo.com

        //3- Do not enter any information
        //4- Click to “Sign in” button

        libraryLoginPage.signInButton.click();

        //5- Verify expected error is displayed:
        String actualMessage = libraryLoginPage.fieldRequiredErrorMessage.getText();
        String expectedMessage = "This field is required.";

        Assert.assertEquals(actualMessage,expectedMessage);

        //Expected: This field is required.



    }


    @Test
    public void invalid_email_format_error_message_test(){

        //TC #2: Invalid email format error message test
        //1- Open a chrome browser
        //2- Go to: https://library1.cydeo.com
        //3- Enter invalid email format
        LibraryLoginPage libraryLoginPage = new LibraryLoginPage();

        libraryLoginPage.inputUsername.sendKeys("email");


        libraryLoginPage.signInButton.click();

        //4- Verify expected error is displayed:

        Assert.assertTrue(libraryLoginPage.enterValidEmailErrorMessage.isDisplayed());

        //Expected: Please enter a valid email address.
        //NOTE: FOLLOW POM DESIGN PATTERN


    }


    @Test
    public void library_negative_login (){

        //TC #3: Library negative login
        //1- Open a chrome browser
        //2- Go to: https://library1.cydeo.com
        //3- Enter incorrect username or incorrect password

        LibraryLoginPage libraryLoginPage = new LibraryLoginPage();

        libraryLoginPage.inputUsername.sendKeys("email@email.com");

        libraryLoginPage.inputPassword.sendKeys("11111");

        libraryLoginPage.signInButton.click();

        Assert.assertTrue(libraryLoginPage.wrongEmailOrPasswordErrorMessage.isDisplayed());

        //4- Verify title expected error is displayed:
        //Expected: Sorry, Wrong Email or Password
        //NOTE: FOLLOW POM DESIGN PATTERN
    }




}






