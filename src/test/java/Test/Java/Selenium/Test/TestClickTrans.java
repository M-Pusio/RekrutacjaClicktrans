package Test.Java.Selenium.Test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import static org.junit.Assert.*;

public class TestClickTrans {

    private WebDriver driver;
    private String baseURL = "https://dev-1.clicktrans.pl/register-test/courier";

    @Before
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\Monik\\geckodriver.exe");
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Monik\\Webdriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseURL);
    }

    @Test
    public void testTitle() {
        driver.findElement(By.id("user_register_company_name")).sendKeys("nazwafirmy");
        driver.findElement(By.id("user_register_email")).sendKeys("mail@wp.pl");
        driver.findElement(By.id("user_register_name")).sendKeys("Jan Kowalski");
        driver.findElement(By.id("user_register_phone")).sendKeys("123123123");
        driver.findElement(By.id("user_register_plainPassword")).sendKeys("Haslo1234");
        driver.findElement(By.id("user_register_settings_agreementRegulations")).click();
        driver.findElement(By.id("user_register_settings_agreementPersonalData")).click();
        driver.findElement(By.id("user_register_settings_agreementMarketing")).click();
        driver.findElement(By.id("user_register_submit")).click();

        WebElement element = driver.findElement(By.xpath("//div[@class='ui container flashmsg']/div[1]"));
        assertEquals("OK - some registration logic is mocked", element.getText());
    }

    @After
    public void quit() {
        driver.quit();
    }
}