package utils;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

public class SessionManager {
    private WebDriver driver;

    public SessionManager(WebDriver driver) {
        this.driver = driver;
    }

    public void byPassLoginUsingCookies(String authToken, String domain) {
        Cookie cookie = new Cookie.Builder("JSESSIONID", authToken)
                .domain(domain)
                .path("/")
                .isHttpOnly(true)
                .build();
        driver.manage().addCookie(cookie);
    }
}
