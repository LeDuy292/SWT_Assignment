package pages;

import org.openqa.selenium.*;
import java.util.List;

public class ClassListPage extends BasePage {
    public ClassListPage(WebDriver driver) { super(driver); }

    private By viewBtn = By.cssSelector(".btn-view");

    public int getClassCount() { return driver.findElements(viewBtn).size(); }
    public void clickViewBtn(int idx) {
        List<WebElement> btns = driver.findElements(viewBtn);
        if (idx >= 0 && idx < btns.size()) btns.get(idx).click();
    }
} 