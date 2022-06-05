package com.cydeo.liveSession.week05;

import com.cydeo.tests.base.TestBase;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SmartbearTest extends TestBase {

    @Test
    public void SmartbearTest(){

        //    2. Go to website:
        //    http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx

        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");

        //    3. Enter username: “Tester”
        driver.findElement(By.className("txt")).sendKeys("Tester");

        //    4. Enter password: “test”
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("test");

        //    5. Click on Login button
        driver.findElement(By.className("button")).click();

        //    6. Click on Order
        driver.findElement(By.xpath("//a[@href=\"Process.aspx\"]")).click();

        //    7. Select familyAlbum from product, set quantity to 2
        new Select(driver.findElement(By.xpath("//select"))).selectByValue("FamilyAlbum");

        driver.findElement(By.xpath("//input[@style='width:40px;']")).sendKeys(Keys.BACK_SPACE + "2");

        //    8. Click to “Calculate” button
        driver.findElement(By.className("btn_dark")).click();

        //    9. Fill address Info with JavaFaker
        Faker faker = new Faker();
        driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_txtName']")).sendKeys(faker.name().fullName());
        driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox2']")).sendKeys(faker.address().streetName());
        driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox3']")).sendKeys(faker.address().city());
        driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox4']")).sendKeys(faker.address().state());
        driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox5']")).sendKeys(faker.numerify("#####"));

        //    10. Click on “visa” radio button
        driver.findElement(By.name("ctl00$MainContent$fmwOrder$cardList")).click();

        //    11. Generate card number using JavaFaker
        driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox6")).sendKeys(faker.numerify("################"));
        driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox1")).sendKeys("12/12");

        //    12. Click on “Process”
        driver.findElement(By.className("btn_light")).click();

        //    13. Verify success message “New order has been successfully added.”
        String expectedMessage = "New order has been successfully added.";
        String actualMessage = driver.findElement(By.tagName("strong")).getText();

        Assert.assertEquals(actualMessage, expectedMessage);

    }
}
