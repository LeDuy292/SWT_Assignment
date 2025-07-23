package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverFactory {
    public static WebDriver createDriver() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("--disable-extensions"); // Tắt tiện ích để tránh can thiệp
        options.addArguments("--no-sandbox"); // Tăng độ ổn định
        options.addArguments("--disable-dev-shm-usage"); // Tránh lỗi bộ nhớ
        return new ChromeDriver(options);
    }
}