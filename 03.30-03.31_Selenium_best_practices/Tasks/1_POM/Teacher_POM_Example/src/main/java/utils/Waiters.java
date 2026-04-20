package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Waiters {
    public static Duration DEFAULT_TIMEOUT_SECONDS = Duration.ofSeconds(3);

    public static void waitForPageTitle(WebDriver driver, String title) {
        waitForPageTitle(driver, title, DEFAULT_TIMEOUT_SECONDS);
    }

    public static void waitForPageTitle(WebDriver driver, String title, Duration timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.titleIs(title));
    }
}
