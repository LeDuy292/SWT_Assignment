package pages;

import org.openqa.selenium.*;

public class EditCoursePage extends BasePage {
    public EditCoursePage(WebDriver driver) { super(driver); }
    public void setCourseID(String CourseID) { driver.findElement(By.id("CourseID")).clear(); driver.findElement(By.id("CourseID")).sendKeys(CourseID); }
    public void setTitle(String title) { driver.findElement(By.id("title")).clear(); driver.findElement(By.id("title")).sendKeys(title); }
    public void setDescription(String desc) { driver.findElement(By.id("description")).clear(); driver.findElement(By.id("description")).sendKeys(desc); }
    public void setFee(String fee) { driver.findElement(By.id("fee")).clear(); driver.findElement(By.id("fee")).sendKeys(fee); }
    public void setDuration(String duration) { driver.findElement(By.id("duration")).clear(); driver.findElement(By.id("duration")).sendKeys(duration); }
    public void setStartDate(String date) { driver.findElement(By.id("startDate")).sendKeys(date); }
    public void setEndDate(String date) { driver.findElement(By.id("endDate")).sendKeys(date); }
    public void setIsActive(String value) { driver.findElement(By.id("isActive")).sendKeys(value); }
    public void uploadImage(String filePath) { driver.findElement(By.id("imageUrl")).sendKeys(filePath); }
    public void submit() { driver.findElement(By.cssSelector("button[type='submit']")).click(); }
} 