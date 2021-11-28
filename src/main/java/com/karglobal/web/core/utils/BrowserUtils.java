package com.karglobal.web.core.utils;

import com.karglobal.web.core.enums.BrowserTypeEnum;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import java.util.Set;


public class BrowserUtils {
    private static WebDriver driver = null;
    private static HashMap<BrowserTypeEnum, WebDriver> driverMap = new HashMap<>();
    private static BrowserTypeEnum browser;

    public static synchronized WebDriver getDriver() {

        if (Objects.nonNull(System.getProperty("browser")))
            BrowserUtils.browser = BrowserTypeEnum.valueOf(System.getProperty("browser").toUpperCase());
        else
            BrowserUtils.browser = BrowserTypeEnum.valueOf(ConfigUtils.getProperty("browser").toUpperCase());

        if (driverMap.containsKey(BrowserUtils.browser))
            return driverMap.get(BrowserUtils.browser);

        switch (BrowserUtils.browser) {
            case CHROME: {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            }
            case SAFARI: {
                driver = new SafariDriver();
                break;
            }
            case FIREFOX: {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            }
            default: {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
            }
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driverMap.put(BrowserUtils.browser, driver);

        return driverMap.get(BrowserUtils.browser);
    }

    public static synchronized void closeBrowser() {
        if (driver != null) {
            driverMap.remove(BrowserUtils.browser);
            driver.quit();
        }
    }

    public static synchronized WebElement waitForElement(WebElement element){
        Wait wait = new FluentWait<>(BrowserUtils.getDriver());
        wait.until(ExpectedConditions.elementToBeClickable(element));
        return element;
    }

    public static synchronized ArrayList<String> getWindowHandles(){
        Set<String> windows = BrowserUtils.getDriver().getWindowHandles();
        return new ArrayList<String>(windows);
    }
}
