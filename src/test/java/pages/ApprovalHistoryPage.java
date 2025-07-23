package pages;

import org.openqa.selenium.*;
import java.util.List;

public class ApprovalHistoryPage extends BasePage {
    public ApprovalHistoryPage(WebDriver driver) { super(driver); }

    private By videoBtn = By.cssSelector("button[data-bs-target='#videoModal']");
    private By quizBtn = By.cssSelector("button[data-bs-target='#quizModal']");
    private By closeModalBtn = By.cssSelector(".modal .btn-secondary[data-bs-dismiss='modal']");

    public void clickVideoBtn(int idx) {
        driver.findElements(videoBtn).get(idx).click();
    }
    public void clickQuizBtn(int idx) {
        driver.findElements(quizBtn).get(idx).click();
    }
    public void closeModal() {
        driver.findElement(closeModalBtn).click();
    }
} 