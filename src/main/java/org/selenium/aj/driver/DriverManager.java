package org.selenium.aj.driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class DriverManager {
    public static WebDriver driver;
    public static WebDriver getDriver() {
        return driver;
    }

    public static void init() {
        if (driver == null) {
            EdgeOptions edgeOptions = new EdgeOptions();
            edgeOptions.addArguments("--start-maximized");
            edgeOptions.addArguments("--guest");
            edgeOptions.addArguments("--incognito");
            edgeOptions.addArguments("--user-agent= Edge/122.0.2365.92");
            driver = new EdgeDriver(edgeOptions);
        }
    }

    public static void down() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

}
