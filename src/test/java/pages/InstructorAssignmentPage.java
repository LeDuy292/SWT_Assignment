package pages;

import org.openqa.selenium.*;
import java.util.List;

public class InstructorAssignmentPage extends BasePage {
    public InstructorAssignmentPage(WebDriver driver) { super(driver); }
    private By addBtn = By.cssSelector(".btn-primary.btn-sm");
    private By searchInput = By.cssSelector(".input-group input");
    private By searchBtn = By.cssSelector(".input-group .btn-outline-primary");
    private By teacherSelect = By.cssSelector("select.teacher-select");
    private By assignBtn = By.cssSelector(".assign-btn");
    private By alert = By.cssSelector(".alert");

    public void clickAddBtn() { click(addBtn); }
    public void searchTeacher(String keyword) {
        type(searchInput, keyword);
        click(searchBtn);
    }
    public void selectTeacherForClass(int classIdx, int teacherIdx) {
        List<WebElement> selects = driver.findElements(teacherSelect);
        if (classIdx < selects.size()) {
            WebElement select = selects.get(classIdx);
            List<WebElement> options = select.findElements(By.tagName("option"));
            if (teacherIdx < options.size()) options.get(teacherIdx).click();
        }
    }
    public void clickAssignBtn(int idx) {
        driver.findElements(assignBtn).get(idx).click();
    }
    public void clickAssignBtnAll() {
        List<WebElement> btns = driver.findElements(assignBtn);
        for (WebElement btn : btns) {
            btn.click();
        }
    }
    public boolean hasAlert() { return driver.findElements(alert).size() > 0; }
} 