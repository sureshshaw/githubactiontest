package com.midtrans.demo.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragDropTest {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://demo.guru99.com/test/drag_drop.html");
        WebElement drag = driver.findElement(By.xpath("(//li[@id='fourth'])[1]/a"));
        WebElement drop = driver.findElement(By.xpath("//ol[@id='amt7']/li[@class='placeholder']"));
        Actions actions = new Actions(driver);
        actions.dragAndDrop(drag,drop).build().perform();
        driver.quit();
    }
}
