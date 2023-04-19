package com.codas.step_definitions;

import com.codas.pages.*;
import com.codas.utilities.BrowserUtils;
import com.codas.utilities.ConfigurationReader;
import com.codas.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.codas.utilities.Driver.driver;

public class Steps {
    BasePage basePage = new BasePage();

    @Given("user is on the homepage")
    public void user_is_on_the_homepage() throws InterruptedException {
        Driver.get().get(ConfigurationReader.get("url"));
        driver.manage().window().maximize();
        Thread.sleep(3000);
    }

    @When("user clicks on {string}")
    public void user_clicks_on(String tabName) {
        switch (tabName) {
            case "News":
                BrowserUtils.waitForPageToLoad(10000);
                System.out.println("tabName = " + tabName);
                basePage.News.click();
                break;
            case "CODAS-IQO":
                BrowserUtils.waitForPageToLoad(10000);
                System.out.println("tabName = " + tabName);
                basePage.CODASIQO.click();
                break;
            case "IQO Demo":
                BrowserUtils.waitForPageToLoad(10000);
                System.out.println("tabName = " + tabName);
                new CODASIQOPage().IQODemo.click();
                break;

            default:
                System.out.println("No option found");
        }
    }

    @Then("user sees an article dated {string}")
    public void user_sees_an_article_dated(String testArticleDate) {
        String mainContent = basePage.mainContent.getText().replaceAll("\\s", "");
        System.out.println("mainContent = " + mainContent);
        System.out.println("testArticleDate = " + testArticleDate);
        System.out.println("mainContent.contains(testArticleDate) = " + mainContent.contains(testArticleDate));
        Assert.assertTrue(mainContent.contains(testArticleDate));
    }

    @Then("user click on Read More")
    public void user_click_on_Read_More() throws InterruptedException {
        BrowserUtils.waitFor(3);
        new NewsPage().ReadMore.click();
        BrowserUtils.waitFor(3);
    }

    @Then("user navigates to home page")
    public void user_navigates_to_home_page() {
        BrowserUtils.waitForPageToLoad(5000);
        driver.navigate().to(ConfigurationReader.get("url"));
    }

    @Then("user enters the postcode {string} and Get Quote")
    public void user_enters_the_postcode_and_Get_Quote(String postcode) {
        ArrayList tabs = new ArrayList(driver.getWindowHandles());
        System.out.println("First tabs.size() = " + tabs.size());
        BrowserUtils.waitForPageToLoad(40000);
        driver.switchTo().window((String) tabs.get(1));
        driver.findElement(By.id("Postcode")).sendKeys(postcode);
        driver.findElement(By.id("btnGetQuote")).click();
    }

    @Given("user selects the {string} option")
    public void user_selects_the_option(String deliveryOption) {
        System.out.println("deliveryOption = " + deliveryOption);
        BrowserUtils.waitForPageToLoad(40000);
        switch (deliveryOption) {
            case "3 Day Delivery":
                BrowserUtils.waitForClickablility(By.xpath("//*[@id=\"options\"]/tbody/tr[2]/td[5]/span/span"), 40);
                driver.findElement(By.xpath("//*[@id=\"options\"]/tbody/tr[2]/td[5]/span/span")).click();
                break;
            case "5 Day Delivery":
                BrowserUtils.waitForClickablility(By.xpath("//*[@id=\"options\"]/tbody/tr[1]/td[5]/span"), 40);
                driver.findElement(By.xpath("//*[@id=\"options\"]/tbody/tr[1]/td[5]/span")).click();
                break;
            default:
                System.out.println("option not available");
        }
    }

    @Then("user takes a screenshot of {string}")
    public void user_takes_a_screenshot_of(String pageName) throws IOException {
        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshotFile, new File("Target/Screenshots/" + pageName +".png"));
    }
}
