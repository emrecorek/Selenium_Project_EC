package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ExplicitWaitPage {

    public ExplicitWaitPage(){

        PageFactory.initElements(Driver.getDriver(), this);

    }


    @FindBy(css = "button")
    public WebElement removeButton;

    @FindBy(css = "input")
    public WebElement checkbox;

    @FindBy(tagName = "img")
    public WebElement loadingBar;

    @FindBy(id = "message")
    public WebElement message;

    @FindBy(css = "button[onclick='swapInput()']")
    public WebElement enableButton;

    @FindBy(css = "input[type='text']")
    public WebElement inputBox;

    @FindBy(css = "input[type='text']")
    public WebElement enableMessage;
    
    

}
