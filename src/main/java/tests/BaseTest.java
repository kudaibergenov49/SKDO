package tests;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    public WebDriver driver;
    public WebDriverWait wait;
    public JavascriptExecutor javascriptExecutor;

    private final String path = "chrome_driver/chromedriver.exe";//путь к драйверу
    private final String property = "webdriver.chrome.driver";// property драйвера

    @BeforeTest
    public void setup () {
        System.setProperty(property, path);
        driver = new ChromeDriver();//Create a Chrome driver. All test and page classes use this driver.
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver,30);//Create a wait. All test and page classes use this wait.
        javascriptExecutor = (JavascriptExecutor) driver;//Create a jsExecuror. All test and page classes use this executor.
        driver.manage().window().maximize();//Maximize Window
    }

    @AfterTest
    public void teardown () {
        driver.quit();
    }
}
