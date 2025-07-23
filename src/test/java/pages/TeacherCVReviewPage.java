package pages;

import org.openqa.selenium.*;

public class TeacherCVReviewPage extends BasePage {
    public TeacherCVReviewPage(WebDriver driver) { super(driver); }
    private By reviewBtn = By.cssSelector("button[data-bs-toggle='modal']");
    private By statusSelect = By.cssSelector("select[name='status']");
    private By interviewStatusSelect = By.cssSelector("select[name='interviewStatus']");
    private By commentsInput = By.cssSelector("textarea[name='comments']");
    private By saveBtn = By.cssSelector(".modal.show button[type='submit']");
    private By closeModalBtn = By.cssSelector(".modal.show .btn-secondary[data-bs-dismiss='modal']");

    public void clickReviewBtn(int idx) { driver.findElements(reviewBtn).get(idx).click(); }
    public void fillReviewForm(String status, String interviewStatus, String comments) {
        driver.findElement(statusSelect).sendKeys(status);
        driver.findElement(interviewStatusSelect).sendKeys(interviewStatus);
        driver.findElement(commentsInput).sendKeys(comments);
    }
    public void saveReview() { driver.findElement(saveBtn).click(); }
    public void closeModal() { driver.findElement(closeModalBtn).click(); }
} 