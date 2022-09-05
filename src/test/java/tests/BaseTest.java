package tests;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseTest {
    //Вход, драйвера, выход
    public WebDriver driver;
    String url = "https://qa-scooter.praktikum-services.ru/";

    @Before
    public void before() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        //System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver");
        this.driver = new ChromeDriver();
        //driver = new FirefoxDriver();
        this.driver.manage().window().maximize();
        this.driver.get(url);
    }

    @After
    public void after() {
        driver.quit();
    }

}
