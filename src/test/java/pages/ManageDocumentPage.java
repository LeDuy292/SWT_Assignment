package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class ManageDocumentPage extends BasePage {
    public ManageDocumentPage(WebDriver driver) { super(driver); }

    // Locators
    private By classSelect = By.id("classSelect");
    private By addDocumentBtn = By.id("addDocumentBtn");
    private By documentCard = By.cssSelector(".document-card");
    private By viewBtn = By.cssSelector(".document-actions .btn-primary");
    private By updateBtn = By.cssSelector(".document-actions .btn-accent");
    private By deleteBtn = By.cssSelector(".document-actions .btn-danger");
    private By paginationPrev = By.id("prevBtn");
    private By paginationNext = By.id("nextBtn");
    private By paginationDot = By.cssSelector(".pagination-dot");
    private By modal = By.id("documentModal");
    private By modalCloseBtn = By.cssSelector(".btn-close");
    private By modalSubmitBtn = By.cssSelector("#documentForm button[type='submit']");
    private By modalTitleInput = By.id("documentName");
    private By modalClassSelect = By.id("classId");
    private By modalFileInput = By.id("documentFile");

    // Actions
    public void selectClassByIndex(int idx) {
        WebElement select = driver.findElement(classSelect);
        List<WebElement> options = select.findElements(By.tagName("option"));
        if (idx >= 0 && idx < options.size()) {
            options.get(idx).click();
        }
    }

    public void clickAddDocument() { click(addDocumentBtn); }
    public int getDocumentCardCount() { return driver.findElements(documentCard).size(); }
    public void clickViewBtn(int idx) { driver.findElements(viewBtn).get(idx).click(); }
    public void clickUpdateBtn(int idx) { driver.findElements(updateBtn).get(idx).click(); }
    public void clickDeleteBtn(int idx) { driver.findElements(deleteBtn).get(idx).click(); }
    public void clickPaginationNext() { click(paginationNext); }
    public void clickPaginationPrev() { click(paginationPrev); }
    public void clickPaginationDot(int idx) { driver.findElements(paginationDot).get(idx).click(); }
    public boolean isModalDisplayed() { return driver.findElement(modal).isDisplayed(); }
    public void closeModal() { click(modalCloseBtn); }
    public void fillModalTitle(String title) { type(modalTitleInput, title); }
    public void selectModalClass(int idx) {
        WebElement select = driver.findElement(modalClassSelect);
        List<WebElement> options = select.findElements(By.tagName("option"));
        if (idx >= 0 && idx < options.size()) {
            options.get(idx).click();
        }
    }
    public void submitModal() { click(modalSubmitBtn); }
    public void uploadFile(String filePath) {
        driver.findElement(modalFileInput).sendKeys(filePath);
    }
} 