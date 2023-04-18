package com.example.task;

import fw.AppManager;
import org.openqa.selenium.remote.Browser;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {

    protected static AppManager app = new AppManager(System.getProperty("browser", Browser.CHROME.browserName()));

    @BeforeMethod
    public void setUp() {
        app.init();
    }

    @AfterMethod(enabled = true)
    public void tearDown() {
        app.stop();
    }

}
