package tests;

import com.scooter.pages.*;
import org.junit.Assert;
import org.junit.Test;

public class OrderTest extends MainTest {
    //Заказ с верхней кнопки заказать и для Вовы и для Коли
    //Заказ с нижней кнопки заказать и для Вовы и для Коли

    @Test
    public void fullOrderTestOnUpButtonData1() {
        QaScooterPage qaScooterPage = new QaScooterPage(driver);
        OrderPage orderPage = qaScooterPage.clickOrderUpButton();
        orderTestData1(orderPage);
    }

    @Test
    public void fullOrderTestOnDownButtonData1() {
        QaScooterPage qaScooterPage = new QaScooterPage(driver);
        qaScooterPage.scrollToElement(qaScooterPage.getOrderDownButton());
        OrderPage orderPage = qaScooterPage.clickOrderDownButton();
        orderTestData1(orderPage);
    }

    @Test
    public void fullOrderTestOnUpButtonData2() {
        QaScooterPage qaScooterPage = new QaScooterPage(driver);
        OrderPage orderPage = qaScooterPage.clickOrderUpButton();
        orderTestData1(orderPage);
    }

    @Test
    public void fullOrderTestOnDownButtonData2() {
        QaScooterPage qaScooterPage = new QaScooterPage(driver);
        qaScooterPage.scrollToElement(qaScooterPage.getOrderDownButton());
        OrderPage orderPage = qaScooterPage.clickOrderDownButton();
        orderTestData1(orderPage);
    }

    private void orderTestData1(OrderPage orderPage) {
        orderPage.setNameInput("Вова");
        orderPage.setSecondNameInput("Васильев");
        orderPage.setAddressInput("Москва");
        orderPage.setStationInput("Черкизовская");
        orderPage.setPhoneInput("89998888888");
        OrderRentPage orderRentPage = orderPage.clickNextButton();
        orderRentPage.setDateWhenInput("22.02.2023");
        orderRentPage.setRentPeriodInput("двое суток");
        orderRentPage.setBlackCheckBox();
        orderRentPage.setCommentInput("привет");
        OrderBox orderBox = orderRentPage.clickOrderButton();
        SuccsessBox succsessBox = orderBox.clickYesButton();
        Assert.assertEquals("Заказ оформлен", succsessBox.getTitle());
    }

    private void orderTestData2(OrderPage orderPage) {
        orderPage.setNameInput("Коля");
        orderPage.setSecondNameInput("Токарев");
        orderPage.setAddressInput("Самара");
        orderPage.setStationInput("Сокольники");
        orderPage.setPhoneInput("89997778811");
        OrderRentPage orderRentPage = orderPage.clickNextButton();
        orderRentPage.setDateWhenInput("19.01.2023");
        orderRentPage.setRentPeriodInput("четверо суток");
        orderRentPage.setBlackCheckBox();
        orderRentPage.setCommentInput("пока");
        OrderBox orderBox = orderRentPage.clickOrderButton();
        SuccsessBox succsessBox = orderBox.clickYesButton();
        Assert.assertEquals("Заказ оформлен", succsessBox.getTitle());
    }

}

