package tests;

import org.junit.jupiter.api.Test;
import pages.LoginPage;
import pages.MessagePage;
import java.io.File;

public class MessageTest extends BaseTest {
    private final String baseUrl = "http://localhost:8080/Hikari/message";
    private final String loginUrl = "http://localhost:8080/Hikari/loginPage";

    private void doLogin() {
        driver.get(loginUrl);
        new LoginPage(driver).login("tung123", "password123");
    }

    @Test
    public void testSendTextMessage() throws InterruptedException {
        doLogin();
        driver.get(baseUrl);
        MessagePage page = new MessagePage(driver);

        // Chọn người chat đầu tiên
        Thread.sleep(1000);
        page.selectChatPartner(0);
        Thread.sleep(500);

        int before = page.getMessageCount();
        page.sendMessage("Tin nhắn test tự động");
        Thread.sleep(1000);

        int after = page.getMessageCount();
        assert after > before;
        assert page.getLastMessageText().contains("Tin nhắn test tự động");
    }

    @Test
    public void testSendImageMessage() throws InterruptedException {
        doLogin();
        driver.get(baseUrl);
        MessagePage page = new MessagePage(driver);

        // Chọn người chat đầu tiên
        Thread.sleep(1000);
        page.selectChatPartner(0);
        Thread.sleep(500);

        int before = page.getMessageCount();
        String filePath = new File("src/test/resources/test-image.png").getAbsolutePath();
        page.sendImage(filePath);
        Thread.sleep(2000);

        int after = page.getMessageCount();
        assert after > before;
        // Có thể kiểm tra có thẻ <img> trong tin nhắn cuối cùng
    }
} 