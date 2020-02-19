package com.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class TestBase {
    public int RESPONSE_ERROR_CODE_200 = 200;
    public int RESPONSE_ERROR_CODE_400 = 400;
    public int RESPONSE_ERROR_CODE_404 = 200;
    public int RESPONSE_ERROR_CODE_405 = 200;

    public Properties prop;

    public TestBase(){
        prop = new Properties();
        try {
            FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+"/src/main/java/com/qa/config/config.properties");
            prop.load(ip);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
