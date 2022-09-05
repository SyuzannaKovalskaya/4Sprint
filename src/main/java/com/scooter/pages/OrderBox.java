package com.scooter.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderBox {
    //Подтверждение заказа
    private WebDriver driver;

    public OrderBox(WebDriver driver) {
        this.driver = driver;
    }

    private By yesButton = By.xpath(".//button[text()='Да']");

    public SuccessBox clickYesButton() {
        driver.findElement(yesButton).click();
        return new SuccessBox(driver);
    }
}
