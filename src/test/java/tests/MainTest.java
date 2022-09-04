package tests;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class MainTest {
    //Вход, драйвера, выход
    WebDriver driver;
    String url = "https://qa-scooter.praktikum-services.ru/";

    @Before
    public void before() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
//        System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver");
        driver = new ChromeDriver();
//        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get(url);
    }

    @After
    public void after() {
        driver.quit();
    }

}
