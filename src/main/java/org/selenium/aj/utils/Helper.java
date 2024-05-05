package org.selenium.aj.utils;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.selenium.aj.driver.DriverManagerTL;

import java.io.File;
import java.io.IOException;

public class Helper {

    public static void captureScreenshot(WebDriver driver){
        File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileHandler.copy(src,new File("src/Screenshots/Login.png"));
            System.out.println("Screenshot Captured");
        } catch (IOException e) {
            System.out.println("Unable to capture screenshot "+e.getMessage());
        }
    }
}
