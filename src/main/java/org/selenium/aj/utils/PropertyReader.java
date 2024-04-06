package org.selenium.aj.utils;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertyReader {
    public PropertyReader() {
    }

    public static String readKey(String key){
        FileInputStream fileInputStream = null;
        Properties p = null;
        try {
            fileInputStream = new FileInputStream(System.getProperty("user.dir")+"/src/main/resources/data.properties");
            p = new Properties();
            p.load(fileInputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                fileInputStream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return p.getProperty(key);

    }
}
