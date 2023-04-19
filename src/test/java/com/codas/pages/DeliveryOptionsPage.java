package com.codas.pages;

import com.codas.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeliveryOptionsPage {
    public DeliveryOptionsPage(){
        PageFactory.initElements(Driver.get(),this);
    }
    @FindBy (xpath = "//*[@id=\"options\"]/tbody/tr[3]/td[5]/span/span")
    public WebElement NextDayDelivery;
}
