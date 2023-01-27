package test_case_auto;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Test_Case03 {
    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://automationexercise.com");
    }

    @After
    public void tearDown() {
        driver.close();
    }

    @Test
    public void test() {
        // 1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        //3. Verify that home page is visible successfully
        WebElement sayfaGorunur = driver.findElement(By.xpath("//i[@class='fa fa-envelope']"));
        Assert.assertTrue(sayfaGorunur.isDisplayed());

        //4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("//i[@class='fa fa-lock']")).click();

        //5. Verify 'Login to your account' is visible
        WebElement loginGorunur = driver.findElement(By.xpath("//h2[text()='Login to your account']"));
        Assert.assertTrue(loginGorunur.isDisplayed());

        //6. Enter incorrect email address and password
        driver.findElement(By.xpath("//input[@data-qa='login-email']")).sendKeys("eb@eb.com");
        driver.findElement(By.xpath("//input[@data-qa='login-password']")).sendKeys("12354");

        //7. Click 'login' button
        driver.findElement(By.xpath("//button[@data-qa='login-button']")).click();

        //8. Verify error 'Your email or password is incorrect!' is visible
        WebElement gorunurIncorret = driver.findElement(By.xpath("//p[text()='Your email or password is incorrect!']"));
        Assert.assertTrue(gorunurIncorret.isDisplayed());

    }


}
