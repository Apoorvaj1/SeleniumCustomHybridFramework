package org.selenium.aj.driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import java.util.Objects;

public class DriverManagerTL {

        public static final ThreadLocal<WebDriver> dr = new ThreadLocal<>();

        public static void setDriver(WebDriver driverRef){
            dr.set(driverRef);
        }

        public static synchronized WebDriver getDriver(){
            return dr.get();
        }

        // Unload
        public static void unload(){
            dr.remove();
        }


        public static void init(String browserName) {
            if(Objects.isNull(DriverManagerTL.getDriver())){
                if (browserName.equals("Edge")) {
                    EdgeOptions edgeOptions = new EdgeOptions();
                    edgeOptions.addArguments("--start-maximized");
                    edgeOptions.addArguments("--guest");
                    edgeOptions.addArguments("--incognito");
                    edgeOptions.addArguments("--user-agent= Edge/123.0.2420.97");
                    WebDriver driver = new EdgeDriver(edgeOptions);
                    setDriver(driver);
                }
                else if((browserName.equals("Chrome"))) {
                    ChromeOptions chromeOptions = new ChromeOptions();
                    chromeOptions.addArguments("--start-maximized");
                    chromeOptions.addArguments("--guest");
                    chromeOptions.addArguments("--incognito");
                    chromeOptions.addArguments("--user-agent= Chrome/123.0.2420.97");
                    WebDriver driver = new ChromeDriver(chromeOptions);
                    setDriver(driver);
                }
            }
        }

        public static void down() {
            if(Objects.nonNull(DriverManagerTL.getDriver())){
                getDriver().quit();
                unload();
            }
        }
}

