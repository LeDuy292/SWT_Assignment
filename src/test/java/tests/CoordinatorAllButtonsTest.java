package tests;

import org.junit.jupiter.api.Test;
import pages.LoginPage;
import pages.ClassListPage;
import pages.LessonApprovalPage;
import pages.ApprovalHistoryPage;
import pages.EditCoursePage;
import java.io.File;

public class CoordinatorAllButtonsTest extends BaseTest {
    private final String loginUrl = "http://localhost:8080/Hikari/loginPage";
    private final String lessonApprovalUrl = "http://localhost:8080/Hikari/LessonApprovalServlet";
    private final String editCourseUrl = "http://localhost:8080/Hikari/NextEditCourse??courseNum=CO001";

    private void doLogin() {
        driver.get(loginUrl);
        new LoginPage(driver).login("huy123", "password123");
    }


    @Test
    public void testLessonApprovalAllButtons() throws InterruptedException {
        doLogin();
        driver.get(lessonApprovalUrl);
        LessonApprovalPage page = new LessonApprovalPage(driver);
        // Chọn pageSize
        page.selectPageSize("10 bài/trang");
        Thread.sleep(500);
        // Click phân trang
        for (int i = 0; i < 2; i++) {
            page.clickPagination(i);
            Thread.sleep(500);
        }
        // Mở modal đánh giá đầu tiên
        page.clickReviewBtn(0);
        Thread.sleep(500);
        page.fillReviewForm("5", "Nhận xét tự động", "Approved");
        page.submitReview();
        Thread.sleep(1000);
        page.closeModal();
    }


    @Test
    public void testEditCourseFormAllFields() throws InterruptedException {
        doLogin();
        driver.get(editCourseUrl);
        EditCoursePage page = new EditCoursePage(driver);
        page.setCourseID("CO111");
        page.setTitle("Khóa học tự động");
        page.setDescription("Mô tả tự động");
        page.setFee("1000000");
        page.setDuration("40");
        page.setStartDate("2024-06-01");
        page.setEndDate("2024-07-01");
        page.setIsActive("Có");
        String imgPath = new File("src/test/resources/test-image.jpg").getAbsolutePath();
        page.uploadImage(imgPath);
        Thread.sleep(500);
        page.submit();
        Thread.sleep(1000);
    }
} 