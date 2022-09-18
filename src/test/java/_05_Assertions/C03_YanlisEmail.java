package _05_Assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_YanlisEmail {

    /*
    1. Bir Class olusturalim YanlisEmailTesti
    2. http://automationpractice.com/index.php sayfasina gidelim
    3. Sign in butonuna basalim
    4. Email kutusuna @isareti olmayan bir mail yazip enter’a
    bastigimizda “Invalid email address” uyarisi ciktigini test edelim
     */

    static WebDriver driver;

    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("http://automationpractice.com/index.php");
    }

    @Test
    public void test1(){
        // 3. Sign in butonuna basalim
        driver.findElement(By.xpath("//*[@class='login']")).click();
    }

    @Test
    public void test2() throws InterruptedException {
        //4. Email kutusuna @isareti olmayan bir mail yazip enter’a
        //    bastigimizda “Invalid email address” uyarisi ciktigini test edelim
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@class='inputNew form-control grey newsletter-input']")).sendKeys("zxcgmail.com", Keys.ENTER);
        Assert.assertTrue(driver.findElement(By.xpath("//*[@class='alert alert-danger']")).isDisplayed());
    }

    @AfterClass
    public static void tearDown(){
        driver.close();

    }


}
