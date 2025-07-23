package pages;

import org.openqa.selenium.*;
import java.util.List;

public class LessonApprovalPage extends BasePage {
    public LessonApprovalPage(WebDriver driver) { super(driver); }

    private By pageSizeSelect = By.cssSelector("select[name='pageSize']");
    private By pagination = By.cssSelector(".pagination .page-link");
    private By reviewBtn = By.cssSelector(".btn-outline-primary[data-bs-toggle='modal']");
    private By ratingSelect = By.cssSelector("select[name='rating']");
    private By commentInput = By.id("adminComments");
    private By statusSelect = By.cssSelector("select[name='reviewStatus']");
    private By submitBtn = By.cssSelector("button[type='submit'][name='action']");
    private By closeModalBtn = By.cssSelector(".btn-secondary[data-bs-dismiss='modal']");

    public void selectPageSize(String value) {
        driver.findElement(pageSizeSelect).sendKeys(value);
    }
    public void clickPagination(int idx) {
        driver.findElements(pagination).get(idx).click();
    }
    public void clickReviewBtn(int idx) {
        driver.findElements(reviewBtn).get(idx).click();
    }
    public void fillReviewForm(String rating, String comment, String status) {
        driver.findElement(ratingSelect).sendKeys(rating);
        driver.findElement(commentInput).sendKeys(comment);
        driver.findElement(statusSelect).sendKeys(status);
    }
    public void submitReview() { driver.findElement(submitBtn).click(); }
    public void closeModal() { driver.findElement(closeModalBtn).click(); }
} 