import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.io.File;

public abstract class BaseTest {
    protected WebDriver driver;

    @BeforeMethod
    public void setUp(){

        File file = new File("src/test/resources/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
        driver = new ChromeDriver();
        driver.navigate().to("https://www.google.com/");
      //  driver.manage().window().maximize();
    }


    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    /*@AfterMethod
    public void goBack(){
        driver.navigate().back();
    }*/
    @DataProvider(name = "dataprovider")
    public Object[][] dataproviderMethod(){
        return new Object[][]{{"selenium java"},{"selenium javascript"}};
    }

}
