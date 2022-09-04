package com.scooter.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OrderPage {
    //1 страница заказа
    WebDriver driver;

    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }

    private By nameInput = By.cssSelector("input[placeholder='* Имя']");
    private By secondNameInput = By.cssSelector("input[placeholder='* Фамилия']");
    private By addressInput = By.cssSelector("input[placeholder='* Адрес: куда привезти заказ']");
    private By stationInput = By.xpath(".//input[contains(@placeholder, '* Станция метро')]/../..");
    private By phoneInput = By.cssSelector("input[placeholder='* Телефон: на него позвонит курьер']");
    private By nextButton = By.xpath(".//button[contains(text(), 'Далее')]");

    public WebElement getNameInput() {
        return driver.findElement(nameInput);
    }

    public WebElement getSecondNameInput() {
        return driver.findElement(secondNameInput);
    }

    public WebElement getAddressInput() {
        return driver.findElement(addressInput);
    }

    public WebElement getStationInput() {
        return driver.findElement(stationInput);
    }

    public WebElement getPhoneInput() {
        return driver.findElement(phoneInput);
    }

    public WebElement getNextButton() {
        return driver.findElement(nextButton);
    }

    public void setNameInput(String text) {
        getNameInput().sendKeys(text);
    }

    public void setSecondNameInput(String text) {
        getSecondNameInput().sendKeys(text);
    }

    public void setAddressInput(String text) {
        getAddressInput().sendKeys(text);
    }

    public void setStationInput(String text) {
        getStationInput()
                .findElement(By.xpath(".//input[contains(@placeholder, '* Станция метро')]"))
                .sendKeys(text);
        getStationInput()
                .findElement(By.xpath("(.//button[contains(@class, 'select-search__option')])[1]"))
                .click();
    }

    public void setPhoneInput(String text) {
        getPhoneInput().sendKeys(text);
    }

    public OrderRentPage clickNextButton() {
        getNextButton().click();
        return new OrderRentPage(driver);
    }
}
