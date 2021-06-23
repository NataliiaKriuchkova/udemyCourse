package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import steps.SearchSteps;
import utils.Browser;
import utils.DriverFactory;
import utils.PropertyReader;

import java.io.File;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public abstract class BaseTest {

    private static WebDriver driver;
    SearchSteps steps;

    public static WebDriver getDriver() {
        return driver;
    }

    @BeforeMethod
    public void setUp() {

        driver = DriverFactory.getDriver(PropertyReader.getBrowser());
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.navigate().to(PropertyReader.getUrl());
        driver.manage().window().maximize();
        steps = new SearchSteps();
    }


    @AfterMethod
    public void tearDown() {
        //   driver.quit();
    }

    @AfterMethod
    public void goBack() {
        driver.navigate().back();
    }

    @DataProvider(name = "dataprovider")
    public Object[][] dataproviderMethod() {
        return new Object[][]{{"selenium java"}};
    }

}
