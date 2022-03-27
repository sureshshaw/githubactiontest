package com.midtrans.demo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderSummaryPage {
    WebDriver driver;

    By continueBtn = By.xpath("//a[.='Continue']");

    public OrderSummaryPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickContinue() {
        driver.switchTo().frame("snap-midtrans");
        driver.findElement(continueBtn).click();
        driver.switchTo().defaultContent();
    }

}
