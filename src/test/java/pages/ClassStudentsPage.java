package pages;

import org.openqa.selenium.*;
import java.util.List;

public class ClassStudentsPage extends BasePage {
    public ClassStudentsPage(WebDriver driver) { super(driver); }
    private By viewBtn = By.cssSelector(".btn-view");
    public int getStudentCount() { return driver.findElements(viewBtn).size(); }
    public void clickViewBtn(int idx) {
        List<WebElement> btns = driver.findElements(viewBtn);
        if (idx >= 0 && idx < btns.size()) btns.get(idx).click();
    }
} 