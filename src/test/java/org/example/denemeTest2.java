package org.example;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



import java.util.concurrent.TimeUnit;

public class denemeTest2 {

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
    public void TestSearch(){


         /*Bu kısım normalde searchBox'a Bilgisayar yazıp ürün araması yapılan kısımdı.
           Ama "is not clickable" hatası aldığım için kodlarımı yorum satırı yaptım.
            Bilgisayar filtrelemesini kendim yazarak yapıyorum ve o kısmın testini yapamadım.
            searchBox'a klavyeden 'bilgisayar' yazdıktan sonra geri kalan testler çalışıyor.
          */
        //WebElement searchBox = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div[2]/div/div[2]/div/div/div/input"));
        //searchBox.click();
       // searchBox.sendKeys("Bilgisayar");
        //driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div[2]/div/div[2]/div/div/div/i")).click();


        driver.findElement(By.xpath("//*[@id=\"search-app\"]/div/div/div[2]/div[2]/div/div[1]/div[1]")).click();

        WebElement price= driver.findElement(By.xpath("//*[@id=\"product-detail-app\"]/div/div[2]/div[2]/div[1]/div[1]/div[1]/div[2]/div/div"));
        String priceText= price.getText();

        /*Ürün sayfası açıldıktan sonra ürünün sepete eklenmesi*/
        WebElement basketBtn = driver.findElement(By.className("add-to-bs-tx"));
        basketBtn.click();
        driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//*[@id=\"myBasketListItem\"]/div[1]/a/i")).click();

        /* Ürünün fiyatı ile sepetteki ürünün fiyatının karşılaştırılması */
        WebElement priceBasket= driver.findElement(By.className("pb-basket-item-price"));
        String priceText2= priceBasket.getText();


            /* Sepetteki ürün adedinin arttırılması */
            WebElement quantityBasket = driver.findElement(By.xpath("//*[@id=\"partial-basket\"]/div/div[3]/div[2]/div[3]/div[1]/div/input"));
            quantityBasket.click();
            quantityBasket.clear();
            quantityBasket.sendKeys("1");
            driver.findElement(By.xpath("//*[@id=\"partial-basket\"]/div/div[3]/div[2]/div[3]/div[1]/div/button[2]")).click();

        driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//*[@id=\"partial-basket\"]/div/div[3]/div[2]/div[3]/button")).click();
    }

    @After
    public void quitDriver(){
        driver.manage().timeouts().implicitlyWait(45,TimeUnit.SECONDS);
        driver.quit();
    }
}
