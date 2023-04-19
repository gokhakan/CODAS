package com.codas.pages;

import com.codas.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CODASIQOPage extends BasePage{
    public CODASIQOPage(){
        PageFactory.initElements(Driver.get(), this);
    }
    @FindBy (xpath = "//*[@id=\"post-462\"]/div/div[1]/div/div[3]/div/div[2]/a/span")
    public WebElement IQODemo;

}
