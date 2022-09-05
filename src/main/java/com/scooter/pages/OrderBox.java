package com.scooter.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderBox {
    //Подтверждение заказа
    WebDriver driver;

    public OrderBox(WebDriver driver) {
        this.driver = driver;
    }

    public By yesButton = By.xpath(".//button[text()='Да']");

    public SuccessBox clickYesButton() {
        driver.findElement(yesButton).click();
        return new SuccessBox(driver);
    }
}
