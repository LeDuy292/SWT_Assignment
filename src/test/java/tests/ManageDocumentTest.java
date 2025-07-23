package tests;

import org.junit.jupiter.api.Test;
import pages.LoginPage;
import pages.ManageDocumentPage;
import java.io.File;

public class ManageDocumentTest extends BaseTest {
    private final String baseUrl = "http://localhost:8080/Hikari/manageDocuments";
    private final String loginUrl = "http://localhost:8080/Hikari/loginPage";

    private void doLogin() {
        driver.get(loginUrl);
        new LoginPage(driver).login("tung123", "password123");
    }

    @Test
    public void testAllButtons() throws InterruptedException {
        doLogin();
        ManageDocumentPage page = new ManageDocumentPage(driver);
        page.navigateTo(baseUrl);

        // Chọn lớp học đầu tiên (nếu có)
        page.selectClassByIndex(1);
        Thread.sleep(500);

        // Thêm tài liệu (mở modal)
        page.clickAddDocument();
        Thread.sleep(500);
        assert page.isModalDisplayed();
        page.closeModal();

        // Phân trang
        page.clickPaginationNext();
        Thread.sleep(500);
        page.clickPaginationPrev();
        Thread.sleep(500);
        page.clickPaginationDot(0);

        // Nếu có tài liệu, thử các nút trên card
        if (page.getDocumentCardCount() > 0) {
            page.clickViewBtn(0);
            // Có thể kiểm tra tab mới mở ra

            // Nếu có quyền, thử cập nhật và xóa
            try { page.clickUpdateBtn(0); Thread.sleep(500); page.closeModal(); } catch (Exception ignored) {}
            try { page.clickDeleteBtn(0); driver.switchTo().alert().dismiss(); } catch (Exception ignored) {}
        }
    }

    @Test
    public void testAddDocumentWithFile() throws InterruptedException {
        doLogin();
        ManageDocumentPage page = new ManageDocumentPage(driver);
        page.navigateTo(baseUrl);
        page.clickAddDocument();
        Thread.sleep(500);
        page.fillModalTitle("Tài liệu test tự động");
        page.selectModalClass(1);
        // Đường dẫn tuyệt đối tới file PDF mẫu trong resource
        String filePath = new File("src/test/resources/dummy.pdf").getAbsolutePath();
        page.uploadFile(filePath);
        Thread.sleep(500);
        page.submitModal();
        // Có thể kiểm tra thông báo thành công hoặc số lượng tài liệu tăng lên
        Thread.sleep(1500);
    }
} 