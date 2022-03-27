package com.midtrans.demo.utility;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitForElementToPresent {

    public static WebElement getElementIfPresent(WebDriver driver, String xpath) {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        WebElement element = wait.until((driver1) -> {
            if (driver.findElement(By.xpath(xpath)) != null) {
                return driver.findElement(By.xpath(xpath));
            }
            return null;
        });
        return element;
    }

    public static boolean isElementPresent(WebDriver driver, String xpath) {
        boolean isPresent = false;
        long curTime = System.currentTimeMillis();
        WebElement element = null;
        while (curTime + Constants.WAIT_TIME > System.currentTimeMillis()){
            try{
                Thread.sleep(500);
                element = driver.findElement(By.xpath(xpath));
            } catch (InterruptedException e) {
            }
            catch (NoSuchElementException e) {
            }
            if(element != null) {
                isPresent = true;
                break;
            }
        }
        return isPresent;
    }
}
