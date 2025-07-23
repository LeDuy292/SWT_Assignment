package tests;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import pages.LoginPage;
import pages.CoordinatorDashboardPage;
import org.openqa.selenium.By;

public class CoordinatorDashboardTest extends BaseTest {
    private final String baseUrl = "http://localhost:8080/Hikari/LoadDashboard";
    private final String loginUrl = "http://localhost:8080/Hikari/loginPage";

    private void doLogin() {
        driver.get(loginUrl);
        new LoginPage(driver).login("huy123", "password123");
    }

    @Test
    public void testDashboardStatsAndActivities() throws InterruptedException {
        doLogin();
        driver.get(baseUrl);
        CoordinatorDashboardPage page = new CoordinatorDashboardPage(driver);
        Assertions.assertEquals(4, page.getStatCardCount());
        Assertions.assertTrue(page.getCourseListCount() > 0);
        Assertions.assertTrue(page.getActivityCount() > 0);
        Assertions.assertFalse(page.hasErrorAlert());
    }


} 