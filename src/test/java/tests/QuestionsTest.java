package tests;

import com.scooter.pages.*;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

public class QuestionsTest extends MainTest {
    //Вопросы о важном на главной странице
    @Test
    public void test1() {
        QaScooterPage qaScooterPage = new QaScooterPage(driver);
        qaScooterPage.scrollToElement(qaScooterPage.getQuestionElementTitle());
        Assert.assertEquals("Сутки — 400 рублей. Оплата курьеру — наличными или картой.",
                qaScooterPage.getTextPanel(By.id("accordion__heading-0"), By.id("accordion__panel-0"))
        );
    }

    @Test
    public void test2() {
        QaScooterPage qaScooterPage = new QaScooterPage(driver);
        qaScooterPage.scrollToElement(qaScooterPage.getQuestionElementTitle());
        Assert.assertEquals("Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.",
                qaScooterPage.getTextPanel(By.id("accordion__heading-1"), By.id("accordion__panel-1"))
        );
    }

    @Test
    public void test3() {
        QaScooterPage qaScooterPage = new QaScooterPage(driver);
        qaScooterPage.scrollToElement(qaScooterPage.getQuestionElementTitle());
        Assert.assertEquals("Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.",
                qaScooterPage.getTextPanel(By.id("accordion__heading-2"), By.id("accordion__panel-2"))
        );
    }
}
