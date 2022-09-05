package tests;

import com.scooter.pages.*;
import com.scooter.pages.testData.OrderData;
import com.scooter.pages.testData.User;
import org.junit.Assert;
import org.junit.Test;

public class OrderTest extends BaseTest {
    //Заказ с верхней кнопки заказать для Коли и Светы
    //Заказ с нижней кнопки заказать  для Коли и Светы

    @Test
    public void fullOrderTestOnUpButtonDataForKolya() {
        QaScooterPage qaScooterPage = new QaScooterPage(driver);
        OrderPage orderPage = qaScooterPage.clickOrderUpButton();
        User user = new User("Коля", "Иванов", "Самара", "Сокольники", "89995556677");
        OrderData orderData = new OrderData("22.02.2023", "трое суток", "Привет!");
        orderTestData(orderPage, user, orderData);
    }

    @Test
    public void fullOrderTestOnDownButtonDataForKolya() {
        QaScooterPage qaScooterPage = new QaScooterPage(driver);
        qaScooterPage.scrollToQuestionTitle();
        OrderPage orderPage = qaScooterPage.clickOrderDownButton();
        User user = new User("Коля", "Иванов", "Самара", "Сокольники", "89995556677");
        OrderData orderData = new OrderData("22.02.2023", "трое суток", "Привет!");
        orderTestData(orderPage, user, orderData);
    }

    @Test
    public void fullOrderTestOnUpButtonDataForSveta() {
        QaScooterPage qaScooterPage = new QaScooterPage(driver);
        OrderPage orderPage = qaScooterPage.clickOrderUpButton();
        User user = new User("Света", "Петрова", "Москва", "Черкизовская", "89995556611");
        OrderData orderData = new OrderData("11.01.2023", "двое суток", "Пока!");
        orderTestData(orderPage, user, orderData);
    }

    @Test
    public void fullOrderTestOnDownButtonDataForSveta() {
        QaScooterPage qaScooterPage = new QaScooterPage(driver);
        qaScooterPage.scrollToQuestionTitle();
        OrderPage orderPage = qaScooterPage.clickOrderDownButton();
        User user = new User("Света", "Петрова", "Москва", "Черкизовская", "89995556611");
        OrderData orderData = new OrderData("11.01.2023", "двое суток", "Пока!");
        orderTestData(orderPage, user, orderData);
    }

    private void orderTestData(OrderPage orderPage, User user, OrderData orderData) {
        orderPage.fillOrderPage(user.name, user.secondName, user.address, user.station, user.phone);
        OrderRentPage orderRentPage = orderPage.clickNextButton();
        orderRentPage.fillOrderRentPage(orderData.date, orderData.period, orderData.comment);
        OrderBox orderBox = orderRentPage.clickOrderButton();
        SuccessBox successBox = orderBox.clickYesButton();
        Assert.assertEquals("Заказ оформлен", successBox.getTitle());
    }

}

