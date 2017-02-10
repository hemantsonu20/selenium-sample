package com.github.selenium.chrome;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxTest {

    private static final String BASE_PATH = "https://github.com/hemantsonu20";

    private WebDriver driver;

    @Before
    public void setUpDriver() {

        driver = new FirefoxDriver();
        driver.manage().window().maximize();
    }

    @After
    public void tearDownDriver() {

        driver.quit();
    }

    @Test
    public void openFireFox() throws InterruptedException {

        driver.get(BASE_PATH);
        Thread.sleep(10000);
        
        assertEquals("hemantsonu20 (Pratapi Hemant) · GitHub", driver.getTitle());
    }
}
