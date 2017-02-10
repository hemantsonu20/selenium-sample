package com.github.selenium;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.ChromeDriverManager;

public class ChromeTest {

    private static final String BASE_PATH = "https://github.com/hemantsonu20";

    private WebDriver driver;

    @BeforeClass
    public static void loadChromeDriver() {

        ChromeDriverManager.getInstance().setup();
    }

    @Before
    public void setUpDriver() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @After
    public void tearDownDriver() {

        driver.quit();
    }

    @Test
    public void openChrome() throws InterruptedException {

        driver.get(BASE_PATH);
        Thread.sleep(10000);
        
        assertEquals("hemantsonu20 (Pratapi Hemant) · GitHub", driver.getTitle());
    }
}
