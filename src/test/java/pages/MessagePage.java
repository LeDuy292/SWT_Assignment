package pages;

import org.openqa.selenium.*;
import java.util.List;

public class MessagePage extends BasePage {
    public MessagePage(WebDriver driver) { super(driver); }

    private By chatItem = By.cssSelector(".chat-item");
    private By messageInput = By.id("messageText");
    private By sendBtn = By.id("sendMessageBtn");
    private By chatMessages = By.id("chatMessages");
    private By imageUpload = By.id("imageUpload");

    // Chọn người chat theo index
    public void selectChatPartner(int idx) {
        List<WebElement> items = driver.findElements(chatItem);
        if (idx >= 0 && idx < items.size()) items.get(idx).click();
    }

    // Gửi tin nhắn text
    public void sendMessage(String text) {
        type(messageInput, text);
        click(sendBtn);
    }

    // Gửi ảnh
    public void sendImage(String filePath) {
        driver.findElement(imageUpload).sendKeys(filePath);
    }

    // Lấy số lượng tin nhắn hiện tại
    public int getMessageCount() {
        return driver.findElements(By.cssSelector("#chatMessages .message-container")).size();
    }

    // Lấy nội dung tin nhắn cuối cùng
    public String getLastMessageText() {
        List<WebElement> msgs = driver.findElements(By.cssSelector("#chatMessages .message-container .content span"));
        return msgs.isEmpty() ? "" : msgs.get(msgs.size() - 1).getText();
    }
} 