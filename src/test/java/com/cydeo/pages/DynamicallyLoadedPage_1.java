package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DynamicallyLoadedPage_1 {


    public DynamicallyLoadedPage_1(){

        PageFactory.initElements(Driver.getDriver(), this);
    }

    //start button
    @FindBy(xpath = "//div//button")
    public WebElement startButton;

    //bar image
    @FindBy(id = "loading")
    public WebElement barImage;

    //username inputbox
    @FindBy(id = "username")
    public WebElement usernameInputbox;

    //password inputbox
    @FindBy(id = "pwd")
    public WebElement passwordInputbox;

    //submit button
    @FindBy(xpath = "//button[.='Submit']")
    public WebElement submitButton;

    //message
    @FindBy(id = "flash")
    public WebElement message;


}
