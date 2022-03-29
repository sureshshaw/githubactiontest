package com.midtrans.demo.tests;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestExecutionListener implements ITestListener {

        @Attachment(value = "Screenshot of {0}", type = "image/png")
        public byte[] saveScreenShot(String name, WebDriver driver){
        TakesScreenshot tss = (TakesScreenshot) driver;
        byte screenShot[] = tss.getScreenshotAs(OutputType.BYTES);
        return screenShot;
    }

    public void onTestFailure(ITestResult result) {
       BaseTest test = new BaseTest();
       saveScreenShot(result.getName(),test.getDriver());
    }
}
