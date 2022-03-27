package com.midtrans.demo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CardPage {
    WebDriver driver;
    By cardNo = By.name("cardnumber");
    By expiryDate = By.xpath("//label[.='Expiry date']/parent::div/input");
    By cvv = By.xpath("//label[.='CVV']/parent::div/input");
    By payNow = By.xpath("//a[.='Pay Now']");
    By password = By.id("PaRes");
    By ok = By.name("ok");

    public CardPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setCardNo(String cardNum){
        driver.switchTo().frame("snap-midtrans");
        driver.findElement(cardNo).sendKeys(cardNum);
    }

    public void setExpiryDate(String date){
        driver.findElement(expiryDate).sendKeys(date);
    }

    public void setCVV(String cvvNum){
        driver.findElement(cvv).sendKeys(cvvNum);
    }

    public void clickPayNow(){
        driver.findElement(payNow).click();
        driver.switchTo().defaultContent();
    }

    public void setPassword(String pwd){
        driver.switchTo().frame("snap-midtrans");
        List<WebElement> frames = driver.findElements(By.tagName("iframe"));
        for(WebElement frame : frames){
            driver.switchTo().frame(frame);
            if(driver.findElements(By.id("PaRes")).size() > 0){
                driver.findElement(password).sendKeys(pwd);
                break;
            }
            driver.switchTo().defaultContent();
        }
    }

    public void clickOK(){
        driver.findElement(ok).click();
        driver.switchTo().defaultContent();
        driver.switchTo().defaultContent();
    }

}
