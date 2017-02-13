package com.github.selenium;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import io.github.bonigarcia.wdm.ChromeDriverManager;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

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
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @After
    public void tearDownDriver() {

        driver.quit();
    }

    @Test
    public void openGithubProfile() {

        // open hemantsonu20's github profile
        driver.get(BASE_PATH);

        // assert title of the page with full name
        assertEquals("hemantsonu20 (Pratapi Hemant) · GitHub", driver.getTitle());

        // fetch fullName and username webelement
        WebElement fullName = driver.findElement(By.className("vcard-fullname"));
        WebElement userName = driver.findElement(By.className("vcard-username"));

        // assert both elements for visibility
        assertTrue(fullName.isDisplayed());
        assertTrue(userName.isDisplayed());

        assertEquals("Pratapi Hemant", fullName.getText());
        assertEquals("hemantsonu20", userName.getText());

        // go to search box, search "hemantsonu20/selenium-sample" and submit
        WebElement searchBox = driver.findElement(By.className("header-search-input"));
        searchBox.sendKeys("hemantsonu20/selenium-sample");
        searchBox.submit();

        // fetch web-element representing repo-list
        WebElement repoList = driver.findElement(By.className("repo-list"));

        // fetch all <a> link tags
        List<WebElement> repoNames = repoList.findElements(By.tagName("a"));

        // assert one of the repoNames "href" attribute will contain
        // "/hemantsonu20/selenium-sample"
        boolean found = repoNames.stream().anyMatch(
                e -> e.getAttribute("href").contains("/hemantsonu20/selenium-sample"));
        assertTrue(found);
    }
}
