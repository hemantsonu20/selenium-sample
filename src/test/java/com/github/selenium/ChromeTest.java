package com.github.selenium;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
    public void openGithubProfile() throws InterruptedException {

        driver.get(BASE_PATH);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        
        assertEquals("hemantsonu20 (Pratapi Hemant) · GitHub", driver.getTitle());
        
        WebElement fullName = driver.findElement(By.className("vcard-fullname"));
        WebElement userName = driver.findElement(By.className("vcard-username"));
        
        assertTrue(fullName.isDisplayed());
        assertTrue(userName.isDisplayed());
        
        assertEquals("Pratapi Hemant", fullName.getText());
        assertEquals("hemantsonu20", userName.getText());
    }
}
