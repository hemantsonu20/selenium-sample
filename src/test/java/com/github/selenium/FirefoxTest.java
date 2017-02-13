package com.github.selenium;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

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
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @After
    public void tearDownDriver() {

        driver.quit();
    }

    @Test
    public void openFireFox() throws InterruptedException {

        driver.get(BASE_PATH);
        
        assertEquals("hemantsonu20 (Pratapi Hemant) · GitHub", driver.getTitle());
    }
}
