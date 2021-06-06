import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.Locale;

import static org.assertj.core.api.Assertions.assertThat;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class SearchTest extends BaseTest {

    @Test(dataProvider = "dataprovider")
    public void openGoogleComInChromeTest(String text) throws InterruptedException{

        WebElement searchField = driver.findElement(By.xpath("//input[@class='gLFyf gsfi']"));
        searchField.clear();
        searchField.sendKeys(text);
        searchField.sendKeys(Keys.RETURN);
        WebElement resaltRow = driver.findElement(By.xpath("//div[@class='g']//h3"));
        System.out.println(resaltRow.getText());
        assertThat(resaltRow.getText().toLowerCase(Locale.ROOT)).as("Wrong text").contains("selenium");
        assertThat(resaltRow.getText().toLowerCase(Locale.ROOT)).as("Wrong text").contains("webdriver");
        assertTrue(resaltRow.isDisplayed());
        assertEquals(resaltRow.getText(), "Пишем автотест с использованием Selenium Webdriver ...", "Text hasn't been displayed");// System.out.println(resaltRow.getText());
        System.out.println(resaltRow.getAttribute("class"));
        assertEquals(resaltRow.getAttribute("class"), "LC20lb DKV0Md", "Wrong");
        assertThat(resaltRow.isDisplayed()).as("Wrong").isTrue();
        assertThat(resaltRow.getText()).as("Wrong text").isEqualTo("Пишем автотест с использованием Selenium Webdriver ...");
        assertThat(resaltRow.getText()).as("Пишем автотест с использованием Selenium Webdriver ...").containsIgnoringCase("webdriver ...");
    }

   /* @Test
    public void openGoogleComInChromeShortTest() throws InterruptedException{

        WebElement searchField = driver.findElement(By.xpath("//input[@class='gLFyf gsfi']"));
      //  searchField.clear();
        Thread.sleep(3000);
        searchField.sendKeys("java selenium");
        searchField.sendKeys(Keys.RETURN);
        WebElement resaltRow = driver.findElement(By.xpath("//div[@class='g']//h3"));
        assertEquals(resaltRow.getAttribute("class"), "LC20lb DKV0Md", "Wrong");
        assertThat(resaltRow.isDisplayed()).as("Wrong").isTrue();
        assertThat(resaltRow.getText()).as("Wrong text").isEqualTo("Пишем автотест с использованием Selenium Webdriver ...");
        assertThat(resaltRow.getText()).as("Пишем автотест с использованием Selenium Webdriver ...").containsIgnoringCase("webdriver ...");



    }*/

  /*  @Test
    public void openYoutubeInEdgeTest(){
        File file1 = new File("src/test/resources/msedgedriver.exe");
        System.setProperty("webdriver.edge.driver", file1.getAbsolutePath());
        WebDriver driver = new EdgeDriver();
        driver.get("https://www.youtube.com/");
        driver.navigate().refresh();
        System.out.println(driver.getTitle());
        WebElement hghg = driver.findElement(By.cssSelector("input#search"));
        WebElement hghgButton = driver.findElement(By.cssSelector("button#search-icon-legacy"));
        hghg.click();
        hghg.sendKeys("маршал");
        WebElement searchXpath = driver.findElement(By.xpath("//input[@id='search']"));
        WebElement buttonSearchXpath = driver.findElement(By.xpath("//button[@id='search-icon-legacy']"));
        searchXpath.clear();
        searchXpath.sendKeys("kkkkkk");
        buttonSearchXpath.submit();
        //hghgButton.submit();
       // driver.quit();

}*/


}