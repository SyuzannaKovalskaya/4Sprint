package com.scooter.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SuccessBox {
    //Итоговый экран в firefox, с номером заказа
    WebDriver driver;

    public SuccessBox(WebDriver driver) {
        this.driver = driver;
    }

    public By messageTitle = By.xpath(".//div[text()='Заказ оформлен']");

    public String getTitle() {
        String message = driver.findElement(messageTitle).getText();
        String[] messageArr = message.split("\n");
        return messageArr[0];
    }

}
