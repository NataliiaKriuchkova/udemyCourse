package steps;

import pages.SearchPage;
import pages.SearchResultsPage;

public class SearchSteps {
    private SearchPage searchPage = new SearchPage();

    public SearchResultSteps executeSearchByKeyword(String keyword) throws InterruptedException {
        searchPage.fillSearchField(keyword);
        searchPage.clickSearchButtonOrPressEnter();
        return new SearchResultSteps();
    }
}
