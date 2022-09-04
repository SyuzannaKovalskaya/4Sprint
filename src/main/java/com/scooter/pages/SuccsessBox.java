package com.scooter.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SuccsessBox {
    //Итоговый экран в firefox, с номером заказа
    WebDriver driver;

    public SuccsessBox(WebDriver driver) {
        this.driver = driver;
    }

    private By messageTitle = By.xpath(".//div[text()='Заказ оформлен']");

    public WebElement getMessageTitle() {
        return driver.findElement(messageTitle);
    }

    public String getTitle() {
        String message = getMessageTitle().getText();
        String[] messageArr = message.split("\n");
        return messageArr[0];
    }

}
