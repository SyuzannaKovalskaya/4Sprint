package com.scooter.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderRentPage {
    //2 страница заказа
    private WebDriver driver;

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

    public void setDateWhenInput(String text) {
        driver.findElement(dateWhenInput).sendKeys(text);
    }

    public void setRentPeriodInput(String text) {
        driver.findElement(rentPeriodInput)
                .findElement(By.xpath("//span"))
                .click();
        driver.findElement(rentPeriodInput)
                .findElement(By.xpath("//div[@class='Dropdown-menu']/div[text()='" + text + "']"))
                .click();
    }

    public void setBlackCheckBox() {
        driver.findElement(blackCheckBox).click();
    }

    public void setGreyCheckBox() {
        driver.findElement(greyCheckBox).click();
    }

    public void setCommentInput(String text) {
        driver.findElement(commentInput).sendKeys(text);
    }

    public OrderBox clickOrderButton() {
        driver.findElement(orderButton).click();
        return new OrderBox(driver);
    }

    public void clickBackButton() {
        driver.findElement(backButton).click();
    }

    public void fillOrderRentPage(String date, String period, String comment) {
        setDateWhenInput(date);
        setRentPeriodInput(period);
        setBlackCheckBox();
        setCommentInput(comment);
    }

}
