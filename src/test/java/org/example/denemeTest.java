package org.example;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import java.util.concurrent.TimeUnit;

public class denemeTest {
    public WebDriver driver;
    @Before
    public void setupDriver(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\OYA BEYZA\\Desktop\\SeleniumWebOtomasyon\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        String url = "https://www.trendyol.com/";
        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }
    @Test
    public void TestHome(){
        WebElement signbtn = driver.findElement(By.xpath("//*[@id=\"not-logged-in-container\"]/div/div[1]"));
        signbtn.click();
        driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);

        WebElement mailbox = driver.findElement(By.id("email"));
        mailbox.click();
        mailbox.sendKeys("your mail address");

        WebElement password = driver.findElement(By.id("password"));
        password.click();
        password.sendKeys("Your Password");
        driver.manage().timeouts().implicitlyWait(45,TimeUnit.SECONDS);
        driver.findElement(By.id("loginSubmit")).click();
    }
    @After
    public void quitDriver(){
        driver.manage().timeouts().implicitlyWait(45,TimeUnit.SECONDS);
        driver.quit();
    }
}
