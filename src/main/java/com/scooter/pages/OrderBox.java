package com.scooter.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OrderBox {
    //Подтверждение заказа
    WebDriver driver;

    public OrderBox(WebDriver driver) {
        this.driver = driver;
    }

    private By yesButton = By.xpath(".//button[text()='Да']");

    public WebElement getYesButton() {
        return driver.findElement(yesButton);
    }

    public SuccsessBox clickYesButton() {
        getYesButton().click();
        return new SuccsessBox(driver);
    }
}
