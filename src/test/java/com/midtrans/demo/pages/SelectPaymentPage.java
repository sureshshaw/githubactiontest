package com.midtrans.demo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class SelectPaymentPage {
    WebDriver driver;

    By creditDebitCard = By.xpath("//div[.='Credit/Debit Card']");

    public SelectPaymentPage(WebDriver driver) {
        this.driver =  driver;
        PageFactory.initElements(driver, this);
    }

    public void clickCreditDebitCard(){
        driver.switchTo().frame("snap-midtrans");
        driver.findElement(creditDebitCard).click();
        driver.switchTo().defaultContent();
    }

}
