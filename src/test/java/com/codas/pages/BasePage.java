package com.codas.pages;

import com.codas.utilities.Driver;
import org.jsoup.Connection;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class BasePage {
    public BasePage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(xpath = "//*[@id=\"menu-item-920\"]/a/span")
    public WebElement News;

    @FindBy (id = "main")
    public WebElement mainContent;

    @FindBy (xpath = "//*[@id=\"post-2\"]/div/div[1]/div/div[2]/div/div[2]/div[2]/div/div[1]/a/h2")
    public WebElement CODASIQO;


}
