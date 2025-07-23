package pages;

import org.openqa.selenium.*;
import java.util.List;

public class CoordinatorDashboardPage extends BasePage {
    public CoordinatorDashboardPage(WebDriver driver) { super(driver); }

    private By statCard = By.cssSelector(".stat-card");
    private By statValue = By.cssSelector(".stat-value");
    private By courseListLink = By.cssSelector(".list-group-item");
    private By pagination = By.cssSelector(".pagination .page-link");
    private By activityItem = By.cssSelector(".activity-item");
    private By errorAlert = By.cssSelector(".alert-danger");
    private By filterInput = By.id("courseFilter");

    public int getStatCardCount() { return driver.findElements(statCard).size(); }
    public String getStatValue(int idx) { return driver.findElements(statValue).get(idx).getText(); }
    public int getCourseListCount() { return driver.findElements(courseListLink).size(); }
    public void clickPagination(int idx) { driver.findElements(pagination).get(idx).click(); }
    public int getActivityCount() { return driver.findElements(activityItem).size(); }
    public boolean hasErrorAlert() { return driver.findElements(errorAlert).size() > 0; }
    public void selectFilterByIndex(int idx) {
        if (driver.findElements(filterInput).size() > 0) {
            WebElement select = driver.findElement(filterInput);
            List<WebElement> options = select.findElements(By.tagName("option"));
            if (idx >= 0 && idx < options.size()) options.get(idx).click();
        }
    }
    public void clickCourseListLink(int idx) {
        List<WebElement> links = driver.findElements(courseListLink);
        if (idx >= 0 && idx < links.size()) links.get(idx).click();
    }
    public void clickActivityItem(int idx) {
        List<WebElement> items = driver.findElements(activityItem);
        if (idx >= 0 && idx < items.size()) items.get(idx).click();
    }
} 