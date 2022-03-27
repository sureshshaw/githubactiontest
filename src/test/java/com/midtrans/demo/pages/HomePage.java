package com.midtrans.demo.pages;

import com.midtrans.demo.utility.WaitForElementToPresent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


public class HomePage {
    WebDriver driver;

    By buyNow = By.xpath("//a[.='BUY NOW']");
    String successMsg = "//span[.='Thank you for your purchase.']";

    public HomePage(WebDriver driver){
        this.driver=driver;
    }

    public void clickBuyNow(){
        driver.findElement(buyNow).click();
    }

    public boolean isPurchaseSuccessful(){
        return WaitForElementToPresent.isElementPresent(driver, successMsg);
    }
}
