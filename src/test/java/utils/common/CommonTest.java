package utils.common;

import net.bytebuddy.utility.RandomString;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.safari.SafariDriver;

import static java.lang.Thread.sleep;

public class CommonTest {
    private static SafariDriver driver = new SafariDriver();

    @Before
    public void setDriver() {
        System.setProperty("webdriver.safari.driver", "/usr/bin/safaridriver");
        driver.get("https://appfollow.io/ru");
        driver.manage().window().maximize();
    }

    @After
    public void quitDriver() {
        driver.quit();
    }

    public static void errorRegistrationTest() throws InterruptedException {
        //Поиск кнопки "Создать аккаунт"
        driver.findElementByXPath("/html/body/header/div/div/div/form/button[1]").click();
        //Поиск поля "Рабочий адрес электронной почты"
        driver.findElementByXPath("//*[@id=\"signup-payed-email\"]")
                .sendKeys(RandomString.make() + "@gmail.ru");
        //Поиск кнопки Allow
        sleep(2000L);
        driver.findElementByXPath("//*[@id=\"adroll_allow_all\"]/div").click();
        // Поиск кнопки Создать аккаунт
        sleep(2000L);
        driver.findElementByCssSelector("#payed-signup-button").click();
        driver.findElementByXPath("//*[@id=\"signup-payed-error\"]").click();
        driver.findElementByXPath("//*[@id=\"signup-payed-error\"]");
        sleep(10000L);
    }

}
