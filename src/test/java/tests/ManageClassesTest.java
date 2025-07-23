package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.ManageClassesPage;
import pages.LoginPage;

public class ManageClassesTest extends BaseTest {
    private final String baseUrl = "http://localhost:8080/Hikari/manageClass";
    private final String loginUrl = "http://localhost:8080/Hikari/loginPage";

    private void doLogin() {
        driver.get(loginUrl);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("tung123", "password123");
    }

    @Test
    public void testClassListDisplayed() {
        doLogin();
        ManageClassesPage page = new ManageClassesPage(driver);
        page.navigateTo(baseUrl);
        Assertions.assertTrue(page.getClassCardCount() > 0, "Không có lớp học nào hiển thị");
    }

    @Test
    public void testPaginationNextPrev() {
        doLogin();
        ManageClassesPage page = new ManageClassesPage(driver);
        page.navigateTo(baseUrl);
        // Chuyển trang tiếp và lùi (nếu có nhiều trang)
        try { page.goToNextPage(); Thread.sleep(500); page.goToPrevPage(); } catch (Exception ignored) {}
    }

    @Test
    public void testPaginationPageClick() {
        doLogin();
        ManageClassesPage page = new ManageClassesPage(driver);
        page.navigateTo(baseUrl);
        // Click vào trang số 2 (nếu có)
        try { page.clickPaginationPage(1); Thread.sleep(500); } catch (Exception ignored) {}
    }


    @Test
    public void testViewStudentsAndBack() {
        doLogin();
        ManageClassesPage page = new ManageClassesPage(driver);
        page.navigateTo(baseUrl);
        page.clickViewStudentsOfFirstClass();
        try { Thread.sleep(1000); } catch (InterruptedException ignored) {}
        page.clickBackToClassList();
        try { Thread.sleep(500); } catch (InterruptedException ignored) {}
    }

    @Test
    public void testStudentProgressAndBack() {
        doLogin();
        ManageClassesPage page = new ManageClassesPage(driver);
        page.navigateTo(baseUrl);
        page.clickViewStudentsOfFirstClass();
        try { Thread.sleep(1000); } catch (InterruptedException ignored) {}
        page.clickStudentProgressBtn(0); // Xem tiến độ học sinh đầu tiên
        try { Thread.sleep(1000); } catch (InterruptedException ignored) {}
        page.clickBackToStudentList();
        try { Thread.sleep(500); } catch (InterruptedException ignored) {}
    }

    @Test
    public void testStudentMessageBtn() {
        doLogin();
        ManageClassesPage page = new ManageClassesPage(driver);
        page.navigateTo(baseUrl);
        page.clickViewStudentsOfFirstClass();
        try { Thread.sleep(1000); } catch (InterruptedException ignored) {}
        page.clickStudentMessageBtn(0); // Nhắn tin học sinh đầu tiên
        // Có thể kiểm tra chuyển trang hoặc popup nếu có
    }
} 