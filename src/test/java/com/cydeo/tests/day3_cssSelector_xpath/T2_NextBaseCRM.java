package com.cydeo.tests.day3_cssSelector_xpath;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T2_NextBaseCRM {

    public static void main(String[] args) throws InterruptedException {

        //1- Open a chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");

        //2- Go to: https://login1.nextbasecrm.com/
        driver.get("https://login1.nextbasecrm.com/");

        //3- Verify “remember me” label text is as expected: Expected: Remember me on this computer
        WebElement rememberMeLabel = driver.findElement(By.className("login-item-checkbox-label"));
        //System.out.println(rememberMeLabel.getText());

        String expectedRememberMeLabel = "Remember me on this computer";
        String actualRememberMeLabel = rememberMeLabel.getText();

        if (actualRememberMeLabel.equals(expectedRememberMeLabel)){
            System.out.println("Remember me label text verification PASSED");
        }else {
            System.out.println("Remember me label text verification FAILED");
        }

        System.out.println("----------------------------------------");

        //4- Verify “forgot password” link text is as expected: Expected: Forgot your password?

        WebElement ForgotPasswordLabel = driver.findElement(By.className("login-link-forgot-pass"));

        String expectedForgotPasswordText = "Forgot your password?";
        String actualForgotPasswordText = ForgotPasswordLabel.getText();

        if (actualForgotPasswordText.equals(expectedForgotPasswordText)){
            System.out.println("Forgot password label text verification PASSED");
        }else {
            System.out.println("actualForgotPasswordText = " + actualForgotPasswordText);
            System.out.println("expectedForgotPasswordText = " + expectedForgotPasswordText);
            System.out.println("Forgot password label text verification FAILED");
        }

        System.out.println("-----------------------------------");

        //5- Verify “forgot password” href attribute’s value contains expected: Expected: forgot_password=yes
        String expectedInHref = "forgot_password=yes";
        String actualInHref = ForgotPasswordLabel.getAttribute("href");

        if (actualInHref.contains(expectedInHref)){
            System.out.println("Forgot password href attribute’s value verification PASSED");
        }else {
            System.out.println("actualInHref = " + actualInHref);
            System.out.println("expectedInHref = " + expectedInHref);
            System.out.println("Forgot password href attribute’s value verification FAILED");
        }
        System.out.println("-------------------------------");



        Thread.sleep(3000);
        driver.close();

    }
}

