package com.cydeo.reviewWeek;

import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import com.cydeo.utilities.HandleWait;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class T1_AmazonTask {

    static WebDriver driver;

    @AfterMethod
    public void closeBrowser() {
        HandleWait.staticWait(3);
        //driver.close();
    }

    @Test
    public void amazonTask() {

        driver = Driver.getDriver();

        //1.	Go to https://www.amazon.com
        driver.get("https://www.amazon.com");

        //2.	Search for "hats for men" (Call from Configuration.properties file)
        String searchKeyword = ConfigurationReader.getProperty("searchKeyword");
        WebElement searchBox = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        searchBox.sendKeys(searchKeyword + Keys.ENTER);


        //3.	Add the first hat appearing to Cart with quantity 2

        //3.1. Click first hat
        WebElement firstHat = driver.findElement(By.xpath("(//img[@class='s-image' ])[1]"));
        firstHat.click();

        //3.2. fix quantity 2
        Select quantity = new Select(driver.findElement(By.xpath("//select[@id='quantity']")));
        quantity.selectByIndex(1);

        //3.3. add to cart
        WebElement addCartButton = driver.findElement(By.xpath("//input[@id='add-to-cart-button']"));
        addCartButton.click();


        //4.	Open cart and assert that the total price and quantity are correct

        //4.1. open cart
        WebElement cart = driver.findElement(By.xpath("//a[@id='nav-cart']"));
        cart.click();

        //4.2. assert total price

        //price
        WebElement priceWhole = driver.findElement(By.xpath("(//span[@class='a-price-whole'])[2]"));
        WebElement priceDecimal = driver.findElement(By.xpath("(//span[@class='a-price-fraction'])[2]"));

        Double price = Double.valueOf(priceWhole.getText() + "." + priceDecimal.getText());

        //total price
        WebElement totalPriceWhole = driver.findElement(By.xpath("(//span[@class='a-price-whole'])[3]"));
        WebElement totalPriceDecimal = driver.findElement(By.xpath("(//span[@class='a-price-fraction'])[3]"));

        Double totalPrice = Double.valueOf(totalPriceWhole.getText() + "." + totalPriceDecimal.getText());

        Assert.assertEquals(totalPrice, price * 2);


        //4.3. assert quantity

        WebElement quantityElement = driver.findElement(By.xpath("//span[@class='a-size-medium sc-number-of-items']"));


        String expectedQuantity = "2 items";
        String actualQuantity = quantityElement.getText();

        Assert.assertTrue(actualQuantity.contains(expectedQuantity));


        //5.	Reduce the quantity from 2 to 1 in Cart for the item selected in the step 3

        Select quantity2 = new Select(driver.findElement(By.xpath("//select[@name='quantity']")));
        quantity2.selectByVisibleText("1");

        //6.	Assert that the total price and quantity has been correctly changed

        HandleWait.staticWait(3);

        WebElement totalPriceWhole2 = driver.findElement(By.xpath("(//span[@class='a-price-whole'])[3]"));
        WebElement totalPriceDecimal2 = driver.findElement(By.xpath("(//span[@class='a-price-fraction'])[3]"));
        totalPrice = Double.valueOf(totalPriceWhole2.getText() + "." + totalPriceDecimal2.getText());

        Assert.assertEquals(totalPrice, price);
    }
}
