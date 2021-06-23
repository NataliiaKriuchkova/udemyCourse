package tests;

import org.testng.annotations.Test;

public class SearchTest extends BaseTest {

    @Test(dataProvider = "dataprovider")
    public void practisAssertionD(String text) throws InterruptedException {
        steps.executeSearchByKeyword(text)
                .verifyThatTopResultContainsCorrectText("Selenium Webdriver ...")
                .verifyThatTopResultContainsProperAttributeText("LC");
    }
}