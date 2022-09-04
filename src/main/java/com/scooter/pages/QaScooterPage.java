package com.scooter.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class QaScooterPage {
    //Вопросы о важном
    //Кноки заказать вверху и внизу
    WebDriver driver;

    public QaScooterPage(WebDriver driver) {
        this.driver = driver;
    }

    private By questionElementTitle = By.xpath(".//div[contains(text(), 'Вопросы о важном')]");
    private By orderUpButton = By.xpath("(.//button[contains(text(), 'Заказать')])[1]");
    private By orderDownButton = By.xpath("(.//button[contains(text(), 'Заказать')])[2]");

    public WebElement getOrderUpButton() {
        return driver.findElement(orderUpButton);
    }

    public WebElement getOrderDownButton() {
        return driver.findElement(orderDownButton);
    }

    public WebElement getQuestionElementTitle() {
        return driver.findElement(questionElementTitle);
    }

    public OrderPage clickOrderUpButton() {
        getOrderUpButton().click();
        return new OrderPage(driver);
    }

    public OrderPage clickOrderDownButton() {
        getOrderDownButton().click();
        return new OrderPage(driver);
    }

    public void scrollToElement(WebElement element) {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView();", element);
    }

    public String getTextPanel(By heading, By panel) {
        WebElement accordionHeading = driver.findElement(heading);
        accordionHeading.click();
        WebElement accordionPanel = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(panel));
        return accordionPanel.getText();
    }
}

