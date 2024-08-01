package org.prashant.UI;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.internal.Require;

import java.io.Serializable;

public class WebDriverFactory implements Serializable {

    private static WebDriverFactory webDriverFactoryInstance = null;
    private static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

    private WebDriverFactory() {
        if (webDriverFactoryInstance != null) {
            throw new IllegalArgumentException("");
        }
    }

    public static WebDriverFactory getInstance() {
        if (webDriverFactoryInstance == null) {
            synchronized (WebDriverFactory.class) {
                if (webDriverFactoryInstance == null) {
                    webDriverFactoryInstance = new WebDriverFactory();
                }
            }
        }
        return webDriverFactoryInstance;
    }

    private void initDriver(String browser) {
        Require.nonNull("browser", browser);
        switch (browser) {
            case "Chrome":
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--start-maximized");
                options.addArguments("--incognito");
                tlDriver.set(new ChromeDriver(options));
                break;
            default:
                throw new IllegalArgumentException("Unsupported browser " + browser);
        }
    }

    public WebDriver getDriver(String browserName) {
        if (tlDriver.get() == null) {
            webDriverFactoryInstance.initDriver(browserName);
        }
            return tlDriver.get();
    }

    public void quitDriver(){
        if(tlDriver.get()!=null){
            tlDriver.get().quit();
        }
    }
}
