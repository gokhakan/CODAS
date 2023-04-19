package com.codas.pages;

import com.codas.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class QuoteAndOrderPage extends BasePage{
    public QuoteAndOrderPage(){
        PageFactory.initElements(Driver.get(),this);
    }
    @FindBy (id ="Postcode")
    public WebElement Postcode;

    @FindBy (id = "btnGetQuote")
    public WebElement GetQuote;
}
