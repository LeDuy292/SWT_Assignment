package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class ManageClassesPage extends BasePage {
    public ManageClassesPage(WebDriver driver) {
        super(driver);
    }

    // Locators
    private By classCard = By.cssSelector(".class-card");
    private By classTitle = By.cssSelector(".class-card .card-title");
    private By viewStudentsButton = By.cssSelector(".btn-view-students");
    private By paginationNext = By.cssSelector("#classPagination .page-item:not(.disabled) .fa-chevron-right");
    private By paginationPrev = By.cssSelector("#classPagination .page-item:not(.disabled) .fa-chevron-left");
    private By paginationPage = By.cssSelector("#classPagination .page-link");
    private By searchInput = By.id("searchInput");
    private By selectedClassName = By.id("selectedClassName");
    private By backToClassListBtn = By.cssSelector("button[onclick*='showClassView']");
    private By studentViewBtn = By.cssSelector(".btn-view-students");
    private By studentProgressBtn = By.cssSelector(".btn-outline-primary.btn-sm");
    private By studentMessageBtn = By.cssSelector(".btn-outline-info.btn-sm");
    private By backToStudentListBtn = By.cssSelector("button[onclick*='showStudentView']");

    // Actions
    public int getClassCardCount() {
        return driver.findElements(classCard).size();
    }

    public String getFirstClassTitle() {
        List<WebElement> titles = driver.findElements(classTitle);
        return titles.isEmpty() ? null : titles.get(0).getText();
    }

    public void clickViewStudentsOfFirstClass() {
        List<WebElement> btns = driver.findElements(viewStudentsButton);
        if (!btns.isEmpty()) btns.get(0).click();
    }

    public void goToNextPage() {
        driver.findElement(paginationNext).click();
    }

    public void goToPrevPage() {
        driver.findElement(paginationPrev).click();
    }

    public void clickPaginationPage(int pageIndex) {
        List<WebElement> pages = driver.findElements(paginationPage);
        if (pageIndex >= 0 && pageIndex < pages.size()) {
            pages.get(pageIndex).click();
        }
    }

    public void searchClass(String keyword) {
        type(searchInput, keyword);
    }

    public String getSelectedClassName() {
        return getText(selectedClassName);
    }

    public void clickBackToClassList() {
        click(backToClassListBtn);
    }

    public void clickStudentProgressBtn(int index) {
        List<WebElement> btns = driver.findElements(studentProgressBtn);
        if (index >= 0 && index < btns.size()) {
            btns.get(index).click();
        }
    }

    public void clickStudentMessageBtn(int index) {
        List<WebElement> btns = driver.findElements(studentMessageBtn);
        if (index >= 0 && index < btns.size()) {
            btns.get(index).click();
        }
    }

    public void clickBackToStudentList() {
        click(backToStudentListBtn);
    }
} 