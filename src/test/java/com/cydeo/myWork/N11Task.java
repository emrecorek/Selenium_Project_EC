package com.cydeo.myWork;

import com.cydeo.utilities.Driver;
import com.cydeo.utilities.HandleWait;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;

public class N11Task {

    //N11 Favorite Product Scenario
    @Test
    public void n11_test(){

        //     • Open the page: www.n11.com .
        Driver.getDriver().get("https://n11.com");

        //     • Verify that the main page is opened.
        String currentUrl = Driver.getDriver().getCurrentUrl();
        String expectedUrl = "https://www.n11.com/";

        Assert.assertEquals(currentUrl, expectedUrl);


        //     • Login to the site.
        HandleWait.staticWait(2);
        Driver.getDriver().findElement(By.className("btnSignIn")).click();

        /* The website doesn't allow to login for automation by this way
        Driver.getDriver().findElement(By.xpath("//input[@id='email']")).sendKeys("emrecorek@hotmail.com" +
                Keys.TAB + "4868008Ee" + Keys.ENTER);

         */

        HandleWait.staticWait(2);
        Driver.getDriver().findElement(By.xpath("//div[@data-connecturl]")).click();

        String firstWindowHandle = Driver.getDriver().getWindowHandle();

        Set<String> windowHandles = Driver.getDriver().getWindowHandles();


        for (String windowHandle : windowHandles) {
            Driver.getDriver().switchTo().window(windowHandle);
            HandleWait.staticWait(1);
        }

        HandleWait.staticWait(2);
        Driver.getDriver().findElement(By.xpath("//button[@value='1']")).click();


        HandleWait.staticWait(2);
        WebElement emailInput = Driver.getDriver().findElement(By.xpath("//input[@type='text']"));
        emailInput.sendKeys("montekristo3533@gmail.com");



        HandleWait.staticWait(2);
        WebElement passwordInput = Driver.getDriver().findElement(By.xpath("//input[@type='password']"));
        passwordInput.sendKeys("3533montekristo" + Keys.ENTER);



        try {
            WebElement acceptCookies = Driver.getDriver().findElement(By.xpath("(//span[@class='a8c37x1j ni8dbmo4 stjgntxs l9j0dhe7 ltmttdrg g0qnabr5'])[3]"));
            acceptCookies.click();

            HandleWait.staticWait(2);
            WebElement continueButton = Driver.getDriver().findElement(By.xpath("//span[@class='a8c37x1j ni8dbmo4 stjgntxs l9j0dhe7 ltmttdrg g0qnabr5 ojkyduve']"));
            continueButton.click();

            System.out.println("try block");
        }catch (NotFoundException e){

            try{
                HandleWait.staticWait(2);
                WebElement continueButton = Driver.getDriver().findElement(By.xpath("//span[@class='a8c37x1j ni8dbmo4 stjgntxs l9j0dhe7 ltmttdrg g0qnabr5 ojkyduve']"));
                continueButton.click();

                System.out.println("try2");
            }catch (NotFoundException p){
                System.out.println("catch 2");
            }

            System.out.println("catch block");
        }


        //     • Verify Login process.






        //     • The word "iphone" is searched.
        //     • Verify that the word "iphone" is searched.
        //     • Go to the 2nd page on the search results page.
        //     • Verify that the 2nd page is opened.
        //     • The 3rd product on the page is added to favourites.
        //     • Go to My Account -> My Favorites / My Lists page.
        //     • Verify that the “My Favorites” page is opened.
        //     • The added product is deleted from the favorites and verify the deletion process.
        //     • Log out process is done.




    }
}
