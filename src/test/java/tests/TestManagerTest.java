package tests;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import pages.LoginPage;
import pages.TestManagerPage;
import org.openqa.selenium.By;
import java.io.File;

public class TestManagerTest extends BaseTest {
    private final String baseUrl = "http://localhost:8080/Hikari/manageTests";
    private final String loginUrl = "http://localhost:8080/Hikari/loginPage";

    private void doLogin() {
        driver.get(loginUrl);
        new LoginPage(driver).login("tung123", "password123");
    }

    @Test
    public void testUploadExcelAndAddTest() throws InterruptedException {
        doLogin();
        driver.get(baseUrl);
        TestManagerPage page = new TestManagerPage(driver);
        page.openUploadModal();
        Thread.sleep(500);
        String filePath = new File("src/test/resources/test-questions.xlsx").getAbsolutePath();
        page.uploadExcelFile(filePath);
        Thread.sleep(2000);
        // Kiểm tra modal preview xuất hiện
        Assertions.assertTrue(driver.findElement(By.id("testPreviewModal")).isDisplayed());
        // Đóng modal preview nếu cần
        driver.findElement(By.cssSelector("#testPreviewModal .btn-secondary")).click();
        Thread.sleep(500);
    }

    @Test
    public void testAddQuestion() throws InterruptedException {
        doLogin();
        driver.get(baseUrl);
        TestManagerPage page = new TestManagerPage(driver);
        page.clickEditTest(0);
        Thread.sleep(1000);
        int before = driver.findElements(By.cssSelector(".question-item")).size();
        page.clickAddQuestion();
        Thread.sleep(500);
        page.fillAddQuestionForm(
            "Câu hỏi tự động?",
            new String[]{"A1", "B1", "C1", "D1"},
            "A"
        );
        page.submitAddQuestion();
        Thread.sleep(1000);
        int after = driver.findElements(By.cssSelector(".question-item")).size();
        Assertions.assertTrue(after > before);
    }

    @Test
    public void testEditQuestion() throws InterruptedException {
        doLogin();
        driver.get(baseUrl);
        TestManagerPage page = new TestManagerPage(driver);
        page.clickEditTest(0);
        Thread.sleep(1000);
        // Chọn câu hỏi đầu tiên
        driver.findElements(By.cssSelector(".question-item")).get(0).click();
        Thread.sleep(500);
        // Mở form sửa
        driver.findElement(By.id("editQuestionBtn")).click();
        Thread.sleep(500);
        driver.findElement(By.id("editQuestionText")).clear();
        driver.findElement(By.id("editQuestionText")).sendKeys("Câu hỏi đã sửa tự động");
        driver.findElement(By.id("saveEditBtn")).click();
        Thread.sleep(1000);
        String text = driver.findElement(By.cssSelector(".question-text")).getText();
        Assertions.assertTrue(text.contains("Câu hỏi đã sửa tự động"));
    }

    @Test
    public void testDeleteQuestion() throws InterruptedException {
        doLogin();
        driver.get(baseUrl);
        TestManagerPage page = new TestManagerPage(driver);
        page.clickEditTest(0);
        Thread.sleep(1000);
        int before = driver.findElements(By.cssSelector(".question-item")).size();
        // Chọn câu hỏi đầu tiên
        driver.findElements(By.cssSelector(".question-item")).get(0).click();
        Thread.sleep(500);
        // Xóa câu hỏi
        driver.findElement(By.cssSelector(".question-actions .btn-danger")).click();
        driver.switchTo().alert().accept();
        Thread.sleep(1000);
        int after = driver.findElements(By.cssSelector(".question-item")).size();
        Assertions.assertTrue(after < before);
    }

    @Test
    public void testViewResults() throws InterruptedException {
        doLogin();
        driver.get(baseUrl);
        TestManagerPage page = new TestManagerPage(driver);
        page.clickViewResults(0);
        Thread.sleep(1500);
        Assertions.assertTrue(driver.findElement(By.id("testResults")).isDisplayed());
        // Kiểm tra bảng kết quả có thể có dữ liệu hoặc empty state
    }

    @Test
    public void testViewStudentDetail() throws InterruptedException {
        doLogin();
        driver.get(baseUrl);
        TestManagerPage page = new TestManagerPage(driver);
        page.clickViewResults(0);
        Thread.sleep(1500);
        // Nếu có kết quả, click xem chi tiết bài làm học sinh đầu tiên
        if (driver.findElements(By.cssSelector(".view-details-btn")).size() > 0) {
            driver.findElements(By.cssSelector(".view-details-btn")).get(0).click();
            Thread.sleep(1000);
            Assertions.assertTrue(driver.findElement(By.id("studentAnswerDetail")).isDisplayed());
        }
    }

    @Test
    public void testPagination() throws InterruptedException {
        doLogin();
        driver.get(baseUrl);
        TestManagerPage page = new TestManagerPage(driver);
        int before = page.getTestCardCount();
        if (driver.findElements(By.cssSelector("#testListPagination .page-link")).size() > 1) {
            page.clickPagination(1); // sang trang 2
            Thread.sleep(1000);
            int after = page.getTestCardCount();
            Assertions.assertNotEquals(before, after);
        }
    }

    @Test
    public void testSearch() throws InterruptedException {
        doLogin();
        driver.get(baseUrl);
        // Nếu có ô tìm kiếm
        if (driver.findElements(By.id("searchInput")).size() > 0) {
            driver.findElement(By.id("searchInput")).sendKeys("test");
            Thread.sleep(1000);
            // Kiểm tra các test card hiển thị phù hợp
            int visible = 0;
            for (var card : driver.findElements(By.cssSelector(".test-card"))) {
                if (card.isDisplayed()) visible++;
            }
            Assertions.assertTrue(visible > 0);
        }
    }
} 