package com.scooter.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderPage {
    //1 страница заказа
    WebDriver driver;

    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }

    public By nameInput = By.cssSelector("input[placeholder='* Имя']");
    public By secondNameInput = By.cssSelector("input[placeholder='* Фамилия']");
    public By addressInput = By.cssSelector("input[placeholder='* Адрес: куда привезти заказ']");
    public By stationInput = By.xpath(".//input[contains(@placeholder, '* Станция метро')]/../..");
    public By phoneInput = By.cssSelector("input[placeholder='* Телефон: на него позвонит курьер']");
    public By nextButton = By.xpath(".//button[contains(text(), 'Далее')]");


    public void setNameInput(String text) {
        driver.findElement(nameInput).sendKeys(text);
    }

    public void setSecondNameInput(String text) {
        driver.findElement(secondNameInput).sendKeys(text);
    }

    public void setAddressInput(String text) {
        driver.findElement(addressInput).sendKeys(text);
    }

    public void setStationInput(String text) {
        driver.findElement(stationInput)
                .findElement(By.xpath(".//input[contains(@placeholder, '* Станция метро')]"))
                .sendKeys(text);
        driver.findElement(stationInput)
                .findElement(By.xpath("(.//button[contains(@class, 'select-search__option')])[1]"))
                .click();
    }

    public void setPhoneInput(String text) {
        driver.findElement(phoneInput).sendKeys(text);
    }

    public OrderRentPage clickNextButton() {
        driver.findElement(nextButton).click();
        return new OrderRentPage(driver);
    }

    public void fillOrderPage(String name, String secondName, String address, String station, String phone) {
        setNameInput(name);
        setSecondNameInput(secondName);
        setAddressInput(address);
        setStationInput(station);
        setPhoneInput(phone);
    }

}
