package com.cydeo.tests.day11_ActionsPractice;

import com.cydeo.utilities.Driver;
import com.cydeo.utilities.HandleWait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T1_DropAndDrag {

    @Test
    public void dropAndDrag(){

        //TC #: Drag and drop
        //1. Go to https://demos.telerik.com/kendo-ui/dragdrop/index
        Driver.getDriver().get("https://demos.telerik.com/kendo-ui/dragdrop/index");



        //accept button
        Driver.getDriver().findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']")).click();

        Actions actions = new Actions(Driver.getDriver());

        //2. Drag and drop the small circle to bigger circle.
        WebElement drag = Driver.getDriver().findElement(By.xpath("//div[@id='draggable']"));
        WebElement drop = Driver.getDriver().findElement(By.xpath("//div[@id='droptarget']"));

        // actions.dragAndDrop(drag,drop).perform();

        actions.clickAndHold(drag).
                pause(2000).
                moveToElement(drop).
                pause(2000).
                release().
                perform();

        /*
        HandleWait.staticWait(2);
        actions.clickAndHold(drag).perform();

        HandleWait.staticWait(2);
        actions.moveToElement(drop).perform();

        HandleWait.staticWait(2);
        actions.release().perform();

         */


        //3. Assert:
        //-Text in big circle changed to: “You did great!”


        String actualText = drop.getText();
        String expectedText = "You did great!";

        Assert.assertEquals(actualText,expectedText);


    }
}
