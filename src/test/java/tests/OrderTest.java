package tests;

import com.scooter.pages.*;
import com.scooter.pages.constans.ConstantsDataForKolya;
import com.scooter.pages.constans.ConstantsDataForSveta;
import org.junit.Assert;
import org.junit.Test;

public class OrderTest extends BaseTest {
    //Заказ с верхней кнопки заказать для Коли и Светы
    //Заказ с нижней кнопки заказать  для Коли и Светы

    @Test
    public void fullOrderTestOnUpButtonDataForKolya() {
        QaScooterPage qaScooterPage = new QaScooterPage(driver);
        OrderPage orderPage = qaScooterPage.clickOrderUpButton();
        orderTestData(orderPage,
                ConstantsDataForKolya.NAME,
                ConstantsDataForKolya.SECOND_NAME,
                ConstantsDataForKolya.ADDRESS,
                ConstantsDataForKolya.STATION,
                ConstantsDataForKolya.PHONE,
                ConstantsDataForKolya.DATE,
                ConstantsDataForKolya.PERIOD,
                ConstantsDataForKolya.COMMENT
        );
    }

    @Test
    public void fullOrderTestOnDownButtonDataForKolya() {
        QaScooterPage qaScooterPage = new QaScooterPage(driver);
        qaScooterPage.scrollToElement(
                driver.findElement(qaScooterPage.orderDownButton)
        );
        OrderPage orderPage = qaScooterPage.clickOrderDownButton();
        orderTestData(orderPage,
                ConstantsDataForKolya.NAME,
                ConstantsDataForKolya.SECOND_NAME,
                ConstantsDataForKolya.ADDRESS,
                ConstantsDataForKolya.STATION,
                ConstantsDataForKolya.PHONE,
                ConstantsDataForKolya.DATE,
                ConstantsDataForKolya.PERIOD,
                ConstantsDataForKolya.COMMENT
        );
    }

    @Test
    public void fullOrderTestOnUpButtonDataForSveta() {
        QaScooterPage qaScooterPage = new QaScooterPage(driver);
        OrderPage orderPage = qaScooterPage.clickOrderUpButton();
        orderTestData(orderPage,
                ConstantsDataForSveta.NAME,
                ConstantsDataForSveta.SECOND_NAME,
                ConstantsDataForSveta.ADDRESS,
                ConstantsDataForSveta.STATION,
                ConstantsDataForSveta.PHONE,
                ConstantsDataForSveta.DATE,
                ConstantsDataForSveta.PERIOD,
                ConstantsDataForSveta.COMMENT
        );
    }

    @Test
    public void fullOrderTestOnDownButtonDataForSveta() {
        QaScooterPage qaScooterPage = new QaScooterPage(driver);
        qaScooterPage.scrollToElement(
                driver.findElement(qaScooterPage.orderDownButton)
        );
        OrderPage orderPage = qaScooterPage.clickOrderDownButton();
        orderTestData(orderPage,
                ConstantsDataForSveta.NAME,
                ConstantsDataForSveta.SECOND_NAME,
                ConstantsDataForSveta.ADDRESS,
                ConstantsDataForSveta.STATION,
                ConstantsDataForSveta.PHONE,
                ConstantsDataForSveta.DATE,
                ConstantsDataForSveta.PERIOD,
                ConstantsDataForSveta.COMMENT
        );
    }

    private void orderTestData(OrderPage orderPage, String name, String secondName, String address, String station, String phone, String date, String period, String comment) {
        orderPage.fillOrderPage(name, secondName, address, station, phone);
        OrderRentPage orderRentPage = orderPage.clickNextButton();
        orderRentPage.fillOrderRentPage(date, period, comment);
        OrderBox orderBox = orderRentPage.clickOrderButton();
        SuccessBox successBox = orderBox.clickYesButton();
        Assert.assertEquals("Заказ оформлен", successBox.getTitle());
    }

}

