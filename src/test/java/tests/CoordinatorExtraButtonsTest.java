package tests;

import org.junit.jupiter.api.Test;
import pages.LoginPage;
import pages.InstructorAssignmentPage;
import pages.TeacherCVReviewPage;
import pages.ClassStudentsPage;

public class CoordinatorExtraButtonsTest extends BaseTest {
    private final String loginUrl = "http://localhost:8080/Hikari/loginPage";
    private final String instructorAssignmentUrl = "http://localhost:8080/Hikari/LoadTeacher";
    private final String teacherCVReviewUrl = "http://localhost:8080/Hikari/cv";

    private void doLogin() {
        driver.get(loginUrl);
        new LoginPage(driver).login("huy123", "password123");
    }

    @Test
    public void testInstructorAssignmentAllButtons() throws InterruptedException {
        doLogin();
        driver.get(instructorAssignmentUrl);
        InstructorAssignmentPage page = new InstructorAssignmentPage(driver);
        page.clickAddBtn();
        Thread.sleep(500);
        page.selectTeacherForClass(0, 1);
        page.clickAssignBtn(0);
        Thread.sleep(1000);
        // Click tất cả các nút phân công còn lại
        page.clickAssignBtnAll();
        Thread.sleep(1000);
        assert page.hasAlert();
    }

    @Test
    public void testTeacherCVReviewAllButtons() throws InterruptedException {
        doLogin();
        driver.get(teacherCVReviewUrl);
        TeacherCVReviewPage page = new TeacherCVReviewPage(driver);
        page.clickReviewBtn(0);
        Thread.sleep(500);
        page.fillReviewForm("Approved", "Pass", "Nhận xét tự động");
        page.saveReview();
        Thread.sleep(1000);
    }

} 