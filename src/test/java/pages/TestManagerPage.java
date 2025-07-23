package pages;

import org.openqa.selenium.*;
import java.util.List;

public class TestManagerPage extends BasePage {
    public TestManagerPage(WebDriver driver) { super(driver); }

    // Locators
    private By uploadExcelBtn = By.id("uploadExcelBtn");
    private By uploadExcelModal = By.id("uploadExcelModal");
    private By excelFileInput = By.id("excelFileInput");
    private By uploadFileBtn = By.id("uploadFileBtn");
    private By testCard = By.cssSelector(".test-card");
    private By editBtn = By.cssSelector(".btn-edit");
    private By viewResultsBtn = By.cssSelector(".btn-view");
    private By pagination = By.cssSelector("#testListPagination .page-link");
    private By addQuestionBtn = By.id("addQuestionBtn");
    private By saveAddBtn = By.id("saveAddBtn");
    private By addQuestionText = By.id("addQuestionText");
    private By optionInputAdd = By.cssSelector(".option-input-add");
    private By correctAnswerAdd = By.cssSelector("input[name='correctAnswerAdd']");
    private By cancelAddBtn = By.id("cancelAddBtn");

    // Actions
    public void openUploadModal() { click(uploadExcelBtn); }
    public void uploadExcelFile(String filePath) {
        driver.findElement(excelFileInput).sendKeys(filePath);
        click(uploadFileBtn);
    }
    public int getTestCardCount() { return driver.findElements(testCard).size(); }
    public void clickEditTest(int idx) { driver.findElements(editBtn).get(idx).click(); }
    public void clickViewResults(int idx) { driver.findElements(viewResultsBtn).get(idx).click(); }
    public void clickPagination(int idx) { driver.findElements(pagination).get(idx).click(); }
    public void clickAddQuestion() { click(addQuestionBtn); }
    public void fillAddQuestionForm(String question, String[] options, String correct) {
        type(addQuestionText, question);
        List<WebElement> optionInputs = driver.findElements(optionInputAdd);
        for (int i = 0; i < options.length && i < optionInputs.size(); i++) {
            optionInputs.get(i).clear();
            optionInputs.get(i).sendKeys(options[i]);
        }
        for (WebElement radio : driver.findElements(correctAnswerAdd)) {
            if (radio.getAttribute("value").equals(correct)) radio.click();
        }
    }
    public void submitAddQuestion() { click(saveAddBtn); }
    public void cancelAddQuestion() { click(cancelAddBtn); }
} 