import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Locale;

import static org.assertj.core.api.Assertions.assertThat;
import static org.testng.Assert.assertTrue;

public class STest extends BaseTest{
    @Test(dataProvider = "dataprovider")
    public void firstTest(String text){
        WebElement element = driver.findElement(By.xpath("//input[@class='gLFyf gsfi']"));
        element.clear();
        element.sendKeys(text);
    }

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
        Assert.assertEquals(resaltRow.getText(), "Пишем автотест с использованием Selenium Webdriver ...", "Text hasn't been displayed");// System.out.println(resaltRow.getText());
        System.out.println(resaltRow.getAttribute("class"));
        Assert.assertEquals(resaltRow.getAttribute("class"), "LC20lb DKV0Md", "Wrong");
        assertThat(resaltRow.isDisplayed()).as("Wrong").isTrue();
        assertThat(resaltRow.getText()).as("Wrong text").isEqualTo("Пишем автотест с использованием Selenium Webdriver ...");
        assertThat(resaltRow.getText()).as("Пишем автотест с использованием Selenium Webdriver ...").containsIgnoringCase("webdriver ...");
    }

}
