package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Tăng lên 20 giây
    }

    public WebElement waitForVisibility(By locator) {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        } catch (TimeoutException e) {
            System.out.println("Hết thời gian chờ phần tử: " + locator);
            throw e;
        }
    }

    public void click(By locator) {
        try {
            waitForVisibility(locator).click();
        } catch (TimeoutException e) {
            System.out.println("Hết thời gian chờ phần tử có thể click: " + locator);
            throw e;
        }
    }

    public void type(By locator, String text) {
        try {
            WebElement element = waitForVisibility(locator);
            element.clear();
            element.sendKeys(text);
        } catch (TimeoutException e) {
            System.out.println("Hết thời gian chờ phần tử để nhập: " + locator);
            throw e;
        }
    }

    protected String getText(By locator) {
        try {
            return waitForVisibility(locator).getText();
        } catch (TimeoutException e) {
            System.out.println("Hết thời gian chờ lấy text của phần tử: " + locator);
            throw e;
        }
    }

    public void navigateTo(String url) {
        driver.get(url);
//        wait.until(ExpectedConditions.jsReturnsValue("return document.readyState == 'complete'"));
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("practice-form-wrapper")));
    }

    public boolean isElementVisible(By locator) {
        try {
            return waitForVisibility(locator).isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }
}