package com.scooter.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OrderRentPage {
    //2 страница заказа
    WebDriver driver;

    public OrderRentPage(WebDriver driver) {
        this.driver = driver;
    }

    private By dateWhenInput = By.xpath(".//input[contains(@placeholder, '* Когда привезти самокат')]");
    private By rentPeriodInput = By.xpath(".//div[contains(text(), '* Срок аренды')]/../..");
    private By blackCheckBox = By.id("black");
    private By greyCheckBox = By.id("gray");
    private By commentInput = By.xpath(".//input[@placeholder='Комментарий для курьера']");
    private By orderButton = By.xpath("(.//button[text()='Заказать'])[2]");
    private By backButton = By.xpath(".//button[text()='Назад']");

    public WebElement getDateWhenInput() {
        return driver.findElement(dateWhenInput);
    }

    public void setDateWhenInput(String text) {
        getDateWhenInput().sendKeys(text);
    }

    public WebElement getRentPeriodInput() {
        return driver.findElement(rentPeriodInput);
    }

    public void setRentPeriodInput(String text) {
        getRentPeriodInput()
                .findElement(By.xpath("//span"))
                .click();
        getRentPeriodInput()
                .findElement(By.xpath("//div[@class='Dropdown-menu']/div[text()='" + text + "']"))
                .click();
    }

    public WebElement getBlackCheckBox() {
        return driver.findElement(blackCheckBox);
    }

    public void setBlackCheckBox() {
        getBlackCheckBox().click();
    }

    public WebElement getGreyCheckBox() {
        return driver.findElement(greyCheckBox);
    }

    public void setGreyCheckBox() {
        getGreyCheckBox().click();
    }

    public WebElement getCommentInput() {
        return driver.findElement(commentInput);
    }

    public void setCommentInput(String text) {
        getCommentInput().sendKeys(text);
    }

    public WebElement getOrderButton() {
        return driver.findElement(orderButton);
    }

    public OrderBox clickOrderButton() {
        getOrderButton().click();
        return new OrderBox(driver);
    }

    public WebElement getBackButton() {
        return driver.findElement(backButton);
    }

    public void clickBackButton() {
        getBackButton().click();
    }
}
