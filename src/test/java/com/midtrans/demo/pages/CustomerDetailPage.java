package com.midtrans.demo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CustomerDetailPage {
    WebDriver driver;

    By name = By.xpath("//td[.='Name']/following-sibling::td/input");
    By email = By.xpath("//input[@type='email']");
    By phoneNo =By.xpath("//td[.='Phone no']/following-sibling::td/input");
    By city = By.xpath("//td[.='City']/following-sibling::td/input");
    By address = By.xpath("//td[.='Address']/following-sibling::td/textarea");
    By postalCode = By.xpath("//td[.='Address']/following-sibling::td/textarea");
    By checkOutBtn = By.xpath("//div[.='CHECKOUT']");

    public CustomerDetailPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setName(String customerName){
        driver.findElement(name).clear();
        driver.findElement(name).sendKeys(customerName);
    }

    public void setEmail(String emailId){
        driver.findElement(email).clear();
        driver.findElement(email).sendKeys(emailId);
    }

    public void setPhoneNo(String phoneNum){
        driver.findElement(phoneNo).clear();
        driver.findElement(phoneNo).sendKeys(phoneNum);
    }

    public void setCity(String cityName){
        driver.findElement(city).clear();
        driver.findElement(city).sendKeys(cityName);
    }

    public void setAddress(String addr){
        driver.findElement(address).clear();
        driver.findElement(address).sendKeys(addr);
    }

    public void setPostal(String postalNo){
        driver.findElement(postalCode).clear();
        driver.findElement(postalCode).sendKeys(postalNo);
    }

    public void clickCheckOut(){
        driver.findElement(checkOutBtn).click();
    }

}
