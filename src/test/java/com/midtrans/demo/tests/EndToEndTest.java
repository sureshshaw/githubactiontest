package com.midtrans.demo.tests;

import com.midtrans.demo.pages.*;
import com.midtrans.demo.utility.ReadData;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

public class EndToEndTest extends BaseTest {
    WebDriver driver;
    HomePage homePage;
    CustomerDetailPage customerDetailPage;
    OrderSummaryPage orderSummaryPage;
    SelectPaymentPage selectPaymentPage;
    CardPage cardPage;

    @BeforeMethod
    public void setUp() {
        driver = startSession();
        homePage = new HomePage(driver);
        customerDetailPage = new CustomerDetailPage(driver);
        orderSummaryPage = new OrderSummaryPage(driver);
        selectPaymentPage = new SelectPaymentPage(driver);
        cardPage = new CardPage(driver);
    }

    @Test(priority = 0)
    public void testPositive() throws InterruptedException {
        List<Map<String, String>> data = ReadData.readJSON();
        homePage.clickBuyNow();
        customerDetailPage.setName(data.get(0).get("name"));
        customerDetailPage.setEmail(data.get(0).get("email"));
        customerDetailPage.setPostal(data.get(0).get("phoneNum"));
        customerDetailPage.setCity(data.get(0).get("city"));
        customerDetailPage.setAddress(data.get(0).get("address"));
        customerDetailPage.setPostal(data.get(0).get("postalCode"));
        customerDetailPage.clickCheckOut();
        orderSummaryPage.clickContinue();
        selectPaymentPage.clickCreditDebitCard();
        cardPage.setCardNo(data.get(0).get("creditCardNum"));
        cardPage.setExpiryDate(data.get(0).get("expirayDate"));
        cardPage.setCVV(data.get(0).get("cvv"));
        cardPage.clickPayNow();
        cardPage.setPassword("112233");
        cardPage.clickOK();
        Assert.assertTrue(homePage.isPurchaseSuccessful(),"Purchase is not successful");
    }

    @Test(priority = 1)
    public void testNegative() throws InterruptedException {
        List<Map<String, String>> data = ReadData.readJSON();
        homePage.clickBuyNow();
        customerDetailPage.setName(data.get(1).get("name"));
        customerDetailPage.setEmail(data.get(1).get("email"));
        customerDetailPage.setPostal(data.get(1).get("phoneNum"));
        customerDetailPage.setCity(data.get(1).get("city"));
        customerDetailPage.setAddress(data.get(1).get("address"));
        customerDetailPage.setPostal(data.get(1).get("postalCode"));
        customerDetailPage.clickCheckOut();
        orderSummaryPage.clickContinue();
        selectPaymentPage.clickCreditDebitCard();
        cardPage.setCardNo(data.get(1).get("creditCardNum"));
        cardPage.setExpiryDate(data.get(1).get("expirayDate"));
        cardPage.setCVV(data.get(1).get("cvv"));
        cardPage.clickPayNow();
        Assert.assertFalse(homePage.isPurchaseSuccessful(),"Purchase is successful");
    }


//    @DataProvider(name = "testDataProvider")
//    public Object[][] dataPro() {
//        return new Object[][]{
//            {"India","test8@gmail.com","1234567890","Kolkata","GM Road Kolkata-10", "7000010"},
//            {"india","test8@gmail.com","1234567890","Kolkata","MG Road Kolkata-10", "7000010"}
//        };
//    }
}