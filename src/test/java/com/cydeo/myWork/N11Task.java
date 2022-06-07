package com.cydeo.myWork;

import com.cydeo.utilities.Driver;
import com.cydeo.utilities.HandleWait;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
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

        /* Website doesn't allow login for automation like this
        Driver.getDriver().findElement(By.xpath("//input[@id='email']")).sendKeys("***********" +
                Keys.TAB + "**********" + Keys.ENTER);

         */


        HandleWait.staticWait(2);
        WebElement loginWithFacebook = Driver.getDriver().findElement(By.xpath("//div[@data-connecturl]"));
        loginWithFacebook.click();

            //Switch to other window
        String firstWindowHandle = Driver.getDriver().getWindowHandle();

        Set<String> windowHandles = Driver.getDriver().getWindowHandles();

        for (String windowHandle : windowHandles) {
            Driver.getDriver().switchTo().window(windowHandle);
            HandleWait.staticWait(2);
        }

            //click agree button
        HandleWait.staticWait(2);
        WebElement agreeButton = Driver.getDriver().findElement(By.xpath("//button[@value='1']"));
        agreeButton.click();

            //give email
        HandleWait.staticWait(2);
        WebElement emailInput = Driver.getDriver().findElement(By.xpath("//input[@type='text']"));
        emailInput.sendKeys("montekristo3533@gmail.com");


            //give password
        HandleWait.staticWait(2);
        WebElement passwordInput = Driver.getDriver().findElement(By.xpath("//input[@type='password']"));
        passwordInput.sendKeys("3533montekristo" + Keys.ENTER);


            //It should be switch to the first window again
        Driver.getDriver().switchTo().window(firstWindowHandle);


        //     • Verify Login process.
        HandleWait.staticWait(2);
        String actualUserName = Driver.getDriver().findElement(By.xpath("//a[.='Monte Kristo']")).getText();  //
        String expectedUserName = "Monte Kristo";

        Assert.assertEquals(actualUserName, expectedUserName);

        //     • The word "iphone" is searched.
        WebElement searchBox = Driver.getDriver().findElement(By.id("searchData"));
        searchBox.sendKeys("iphone" + Keys.ENTER);

        //     • Verify that the word "iphone" is searched.
        WebElement searchedElement = Driver.getDriver().findElement(By.tagName("h1"));
        String actualWord = searchedElement.getText();
        String expectedWord = "Iphone,";

        Assert.assertEquals(actualWord,expectedWord);

        //     • Go to the 2nd page on the search results page.
        HandleWait.staticWait(2);
        WebElement secondPage = Driver.getDriver().findElement(By.xpath("//a[.='2']"));
        secondPage.click();

        //     • Verify that the 2nd page is opened.
        HandleWait.staticWait(2);
        String actualPageNum = Driver.getDriver().findElement(By.xpath("//a[@class='active ']")).getText();
        String expectedPageNum = "2";

        Assert.assertEquals(actualPageNum,expectedPageNum);

        //     • The 3rd product on the page is added to favourites.
        WebElement thirdProductFavourite = Driver.getDriver().findElement(By.xpath("(//span[@title='Favorilere ekle'])[3]"));
        thirdProductFavourite.click();

        //     • Go to My Account -> My Favorites / My Lists page.

        HandleWait.staticWait(2);
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(Driver.getDriver().findElement(By.xpath("//div[@class='myAccount']"))).perform();

        HandleWait.staticWait(2);
        WebElement myFavouritesList = Driver.getDriver().findElement(By.xpath("//a[@title='Favorilerim / Listelerim']"));
        myFavouritesList.click();

        WebElement myFavourites = Driver.getDriver().findElement(By.xpath("//h4[@class='listItemTitle']"));
        myFavourites.click();

        //     • Verify that the “My Favorites” page is opened.
        String actualPageTitle = Driver.getDriver().findElement(By.xpath("//h2[.='Favorilerim']")).getText();
        String expectedPageTitle = "Favorilerim";

        Assert.assertEquals(actualPageTitle,expectedPageTitle);

        //     • The added product is deleted from the favorites and verify the deletion process.
        WebElement deleteButton = Driver.getDriver().findElement(By.xpath("//span[.='Sil']"));
        deleteButton.click();

        HandleWait.staticWait(2);
        WebElement confirmButton = Driver.getDriver().findElement(By.xpath("//span[@class='btn btnBlack confirm']"));
        confirmButton.click();

        HandleWait.staticWait(2);
        WebElement emptyFavourite = Driver.getDriver().findElement(By.xpath("//div[@class='emptyWatchList hiddentext']"));
        Assert.assertTrue(emptyFavourite.isDisplayed());

        //     • Log out process is done.

        HandleWait.staticWait(2);
        actions = new Actions(Driver.getDriver());
        actions.moveToElement(Driver.getDriver().findElement(By.xpath("//div[@class='myAccount']"))).perform();

        HandleWait.staticWait(2);
        WebElement logoutButton = Driver.getDriver().findElement(By.xpath("//a[@class='logoutBtn']"));
        logoutButton.click();

        WebElement title = Driver.getDriver().findElement(By.xpath("//h2"));
        String actualTitle = title.getText();
        String expectedTitle = "Giriş Yap";

        Assert.assertEquals(actualTitle, expectedTitle);
    }
}

//sometimes cookies and another accept section come into page. I created try catch block for this. but now it doesn't come so I move them here.
/*

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

 */
