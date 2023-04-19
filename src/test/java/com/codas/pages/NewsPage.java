package com.codas.pages;

import com.codas.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewsPage extends BasePage{
    public NewsPage(){
        PageFactory.initElements(Driver.get(), this);
    }
    @FindBy (id= "blog-1-post-5457")
    public WebElement ReadMore;
}
